package com.eco.ecommerceapplication.Entites;

import com.eco.ecommerceapplication.programs.product.Product;

import jakarta.persistence.*;

@Entity
@Table(name = "orderItems")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderItemId;
    private double totalPrice;
    private int quantity;
    @ManyToOne
    private Product product;








}
