package com.eco.ecommerceapplication.programs.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.eco.ecommerceapplication.programs.order.orderitem.OrderItemResponseDTO;
import com.eco.ecommerceapplication.programs.order.orderstatus.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter 
@Builder 
@AllArgsConstructor 
@NoArgsConstructor 
public class OrderResponseDTO {
    private long orderId;
    private long customerId;
    private List<OrderItemResponseDTO> orderItems;
    private OrderStatus status;
    private BigDecimal totalPrice;
    private LocalDateTime orderDate;

}
