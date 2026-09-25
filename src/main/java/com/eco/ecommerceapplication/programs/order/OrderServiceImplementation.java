package com.eco.ecommerceapplication.programs.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import com.eco.ecommerceapplication.Exceptions.BadRequestException;
import com.eco.ecommerceapplication.Exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.eco.ecommerceapplication.programs.cart.Cart;
import com.eco.ecommerceapplication.programs.cart.CartRepo;
import com.eco.ecommerceapplication.programs.order.orderitem.OrderItemResponseDTO;
import com.eco.ecommerceapplication.programs.order.orderitem.OrderItems;
import com.eco.ecommerceapplication.programs.order.orderstatus.OrderStatus;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderServiceImplementation implements OrderService {
   private final OrderRepo orderRepo;
    private final CartRepo cartRepo;

public OrderResponseDTO checkout(Long customerId){

        Cart cart =  cartRepo.findByCustomerId(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found for customer with ID: " + customerId));
        if(cart.getCartItems().isEmpty()){
            throw new BadRequestException("Cart is empty for customer with ID: " + customerId);
        }

           List<OrderItems> orderItemsList = cart.getCartItems().stream()
                .map(cartItem -> OrderItems.builder()
                        .product(cartItem.getProduct())
                        .quantity(cartItem.getQuantity())
                        .unitPrice(cartItem.getProduct().getPrice())
                        .totalPrice(cartItem.getProduct().getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity())))
                        .build())
                .toList();




        BigDecimal totalPrice = orderItemsList.stream()
                            .map(OrderItems::getTotalPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);


           Order order = Order.builder()
          .customer(cart.getCustomer())
          .orderItems(orderItemsList)
          .status(OrderStatus.PLACED)
          .totalPrice(totalPrice)
          .orderDate(LocalDateTime.now(ZoneId.systemDefault()))
            .build();
            Order savedOrder = orderRepo.save(order);

        cart.getCartItems().clear();
        cartRepo.save(cart);

        return mapToOrderResponseDTO(savedOrder);
    }


private OrderResponseDTO mapToOrderResponseDTO(Order order) {
   return OrderResponseDTO.builder()
           .orderId(order.getOrderId())
           .status(order.getStatus())
             .totalPrice(order.getTotalPrice())
             .orderDate(order.getOrderDate())
             .customerId(order.getCustomer().getCustomerId())
             .orderItems(
               order.getOrderItems()
                      .stream()
                      .map(item -> OrderItemResponseDTO.builder()
                      .orderItemId(item.getOrderItemId())
                      .productId(item.getProduct().getProductId())
                      .productName(item.getProduct().getProductName())
                      .unitPrice(item.getUnitPrice())
                      .quantity(item.getQuantity())
                      .totalPrice(item.getTotalPrice())
                      .build())
                      .toList()
             )
             .build();





         }
        }


      