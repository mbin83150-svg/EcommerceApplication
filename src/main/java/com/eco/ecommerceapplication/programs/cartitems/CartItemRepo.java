package com.eco.ecommerceapplication.programs.cartitems;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepo extends JpaRepository<CartItems, Long> {
    
}
