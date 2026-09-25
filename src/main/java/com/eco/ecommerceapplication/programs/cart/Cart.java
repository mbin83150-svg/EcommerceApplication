package com.eco.ecommerceapplication.programs.cart;

import com.eco.ecommerceapplication.programs.cartitems.CartItems;
import com.eco.ecommerceapplication.programs.customer.Customer;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter 
@Setter 

@NoArgsConstructor 
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItems> cartItems;
}