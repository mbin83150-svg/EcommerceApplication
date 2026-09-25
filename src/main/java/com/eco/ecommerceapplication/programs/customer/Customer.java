package com.eco.ecommerceapplication.programs.customer;

import com.eco.ecommerceapplication.programs.cart.Cart;
import com.eco.ecommerceapplication.programs.order.Order;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @OneToOne(mappedBy = "customer")
    private Cart cart;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
