package com.eco.ecommerceapplication.Entites;

import jakarta.persistence.*;
import org.apache.catalina.User;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;



    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer  customer;
}
