package com.eco.ecommerceapplication.programs.cart.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import com.eco.ecommerceapplication.programs.cartitems.dtos.CartItemResponseDTO;

@Getter 
@AllArgsConstructor 
@NoArgsConstructor
@Builder 
public class CartResponseDTO {
    private long id;
    private long customerId;
    private List<CartItemResponseDTO> cartItems;
    private BigDecimal totalPrice;
}