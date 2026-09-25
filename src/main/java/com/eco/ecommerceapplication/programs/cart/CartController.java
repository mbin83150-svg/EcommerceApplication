package com.eco.ecommerceapplication.programs.cart;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eco.ecommerceapplication.programs.cart.dtos.AddToCartRequestDTO;
import com.eco.ecommerceapplication.programs.cart.dtos.CartResponseDTO;
import com.eco.ecommerceapplication.shared.response.ApiResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController 
@RequiredArgsConstructor 
@Validated 
@RequestMapping ("/api/v1/cart")
public class CartController {
         private final CartService cartService;
         @PostMapping("/{customerId}/add")
         public ResponseEntity<ApiResponse<CartResponseDTO>> addToCart(@Valid @RequestBody  long customerId, AddToCartRequestDTO request) {
            CartResponseDTO cartResponse = cartService.addToCart(customerId, request);
            return ResponseEntity.ok(ApiResponse.success(cartResponse, "Item added to cart successfully"));
       }
       @GetMapping ("/{customerId}")
       public ResponseEntity<ApiResponse<CartResponseDTO>> getCartByCustomerId(@Valid @RequestBody long customerId){
        CartResponseDTO cartResponse = cartService.getCartByCustomerId(customerId);

        return ResponseEntity.ok(ApiResponse.success(cartResponse, "Cart retrieved successfully"));
       }
       @PutMapping("/{customerId}/update")
       public ResponseEntity<ApiResponse<CartResponseDTO>> updateCartItemQuantity(@Valid @RequestBody long customerId , AddToCartRequestDTO request ){
           CartResponseDTO updatedCartResponse = cartService.updateCartItemQuantity(customerId, request);
              return ResponseEntity.ok(ApiResponse.success(updatedCartResponse, "Cart item quantity updated successfully"));
       }
       @DeleteMapping ("/{customerId}/remove")
       public ResponseEntity<ApiResponse<CartResponseDTO>> removeCartItem(@Valid @RequestBody long customerId , Long productId){
        CartResponseDTO updatedCartResponse = cartService.removeFromCart(customerId, productId);
        return ResponseEntity.ok(ApiResponse.success(updatedCartResponse, "Cart item removed successfully"));
       }
}