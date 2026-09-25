package com.eco.ecommerceapplication.programs.cart;

import com.eco.ecommerceapplication.programs.cart.dtos.AddToCartRequestDTO;
import com.eco.ecommerceapplication.programs.cart.dtos.CartResponseDTO;


public interface CartService {
   CartResponseDTO addToCart(long customerId, AddToCartRequestDTO request);
   CartResponseDTO getCartByCustomerId(long customerId);
   CartResponseDTO removeFromCart(long customerId, Long productId);
   CartResponseDTO updateCartItemQuantity(long customerId, AddToCartRequestDTO request);
}
