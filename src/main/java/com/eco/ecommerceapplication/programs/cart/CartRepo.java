package com.eco.ecommerceapplication.programs.cart;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Long> {
     Optional<Cart> findByCustomerId(Long customerId);
    //Optional will trigger the orElseGet() method if the cart is not found for the given customerId, allowing you to create a new cart in that case.
}
