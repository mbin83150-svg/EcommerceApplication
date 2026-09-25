package com.eco.ecommerceapplication.programs.order.orderitem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItems , Long>{
    
}
