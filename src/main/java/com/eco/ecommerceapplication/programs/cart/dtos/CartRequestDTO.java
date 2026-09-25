///
package com.eco.ecommerceapplication.programs.cart.dtos;

import java.util.List;

import com.eco.ecommerceapplication.programs.cartitems.CartItems;
import com.eco.ecommerceapplication.programs.customer.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter 
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
public class CartRequestDTO {

    private Customer customer;
    private List<CartItems> cartItems;
}