package com.eco.ecommerceapplication.programs.order;

public interface OrderService {
    OrderResponseDTO checkout(Long customerId);
}
