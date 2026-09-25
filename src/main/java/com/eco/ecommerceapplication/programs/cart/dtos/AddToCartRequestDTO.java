package com.eco.ecommerceapplication.programs.cart.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder 
@Getter 
@AllArgsConstructor 
@NoArgsConstructor 
public class AddToCartRequestDTO {
    private long productId;
    private int quantity;
    
}