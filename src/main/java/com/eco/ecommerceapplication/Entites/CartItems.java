package com.eco.ecommerceapplication.Entites;

import com.eco.ecommerceapplication.programs.product.Product;

import jakarta.persistence.*;

@Entity
@Table(name = "cartItems")
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartItemId;


    @ManyToOne
    private Product product;


}
