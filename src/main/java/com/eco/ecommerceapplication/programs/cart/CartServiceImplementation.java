package com.eco.ecommerceapplication.programs.cart;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.eco.ecommerceapplication.Exceptions.BadRequestException;
import com.eco.ecommerceapplication.Exceptions.ProductNotFoundException;
import com.eco.ecommerceapplication.Exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.eco.ecommerceapplication.programs.cartitems.dtos.CartItemResponseDTO;
import com.eco.ecommerceapplication.programs.cart.dtos.AddToCartRequestDTO;
import com.eco.ecommerceapplication.programs.cart.dtos.CartResponseDTO;
import com.eco.ecommerceapplication.programs.cartitems.CartItems;
import com.eco.ecommerceapplication.programs.customer.Customer;
import com.eco.ecommerceapplication.programs.customer.CustomerRepo;
import com.eco.ecommerceapplication.programs.product.Product;
import com.eco.ecommerceapplication.programs.product.ProductRepo;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class CartServiceImplementation implements CartService {
        private static final String CART_NOT_FOUND_MESSAGE = "Cart not found for customer with ID: ";
    private final CartRepo cartRepo;
    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;
@Override
    public CartResponseDTO addToCart(long customerId, AddToCartRequestDTO request) {
        if (request.getQuantity() <= 0) {
            throw new BadRequestException("Quantity must be greater than 0");
        }

        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID: " + customerId));
        Product product = productRepo.findById(request.getProductId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + request.getProductId()));

        Cart cart = cartRepo.findByCustomerId(customerId).orElseGet(() -> {
              Cart newCart = new Cart();
              newCart.setCustomer(customer);
              return cartRepo.save(newCart);
          });
          Optional<CartItems> existingCartItem = cart.getCartItems().stream()
          .filter(item -> item.getProduct().getProductId().equals(request.getProductId()))
          .findFirst();

          if(existingCartItem.isPresent()){
                CartItems cartItem = existingCartItem.get();
                cartItem.setQuantity(cartItem.getQuantity() + request.getQuantity());
            } else {
                CartItems newCartItem = new CartItems();
                newCartItem.setProduct(product);
                newCartItem.setQuantity(request.getQuantity());
                newCartItem.setCart(cart);
                cart.getCartItems().add(newCartItem);
          }
          Cart savedCart = cartRepo.save(cart);
              return mapToCartResponseDTO(savedCart);
    }


   public CartResponseDTO mapToCartResponseDTO(Cart cart) {
    List<CartItemResponseDTO> itemDTOs = cart.getCartItems().stream()
            .map(item -> CartItemResponseDTO.builder()
                    .cartItemId(item.getCartItemId())
                    .productId(item.getProduct().getProductId())
                    .productName(item.getProduct().getProductName())
                    .quantity(item.getQuantity())
                    .unitPrice(item.getProduct().getPrice())
                    .subtotal(item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                    .build())
            .toList();

    BigDecimal totalPrice = itemDTOs.stream()
            .map(CartItemResponseDTO::getSubtotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

    return CartResponseDTO.builder()
            .id(cart.getId())
            .customerId(cart.getCustomer().getCustomerId())
            .cartItems(itemDTOs)
            .totalPrice(totalPrice)
            .build();


}


@Override
public CartResponseDTO getCartByCustomerId(long customerId) {
        Cart cart = cartRepo.findByCustomerId(customerId)
                .orElseThrow(() -> new ResourceNotFoundException(CART_NOT_FOUND_MESSAGE + customerId));
        return mapToCartResponseDTO(cart);
    }
@Override
   public CartResponseDTO removeFromCart(long customerId, Long productId) {
    Cart cart = cartRepo.findByCustomerId(customerId)
            .orElseThrow(() -> new ResourceNotFoundException(CART_NOT_FOUND_MESSAGE + customerId));

    CartItems itemToRemove = cart.getCartItems().stream()
            .filter(item -> item.getProduct().getProductId().equals(productId))
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException("Product not found in cart for customer with ID: " + customerId));

    cart.getCartItems().remove(itemToRemove);
    Cart savedCart = cartRepo.save(cart);

    return mapToCartResponseDTO(savedCart);
}




//
@Override
    public CartResponseDTO updateCartItemQuantity(long customerId, AddToCartRequestDTO request){
                             if (request.getQuantity() <= 0) {
                                 throw new BadRequestException("Quantity must be greater than 0");
                             }
                             Cart cart = cartRepo.findByCustomerId(customerId)
                             .orElseThrow(() -> new ResourceNotFoundException(CART_NOT_FOUND_MESSAGE + customerId));
                             CartItems itemToUpdate = cart.getCartItems().stream()
                             .filter(item -> item.getProduct().getProductId().equals(request.getProductId()))
                             .findFirst()
                             .orElseThrow(() -> new ResourceNotFoundException("Item not found in cart for customer with ID: " + customerId));

                            itemToUpdate.setQuantity(request.getQuantity());
                             Cart savedCart = cartRepo.save(cart);
                                    return mapToCartResponseDTO(savedCart);
    }


}
