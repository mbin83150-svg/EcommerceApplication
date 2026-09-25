package com.eco.ecommerceapplication.Entites;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;


    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;


    @OneToOne   // is for before buying
     private Cart cart;


    @OneToMany   // is for after buying
    private List<Order> orders;

}
