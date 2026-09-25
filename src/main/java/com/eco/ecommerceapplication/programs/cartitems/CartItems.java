package com.eco.ecommerceapplication.programs.cartitems;

import com.eco.ecommerceapplication.programs.cart.Cart;
import com.eco.ecommerceapplication.programs.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cartItems")
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartItemId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;


    @ManyToOne
@JoinColumn(name = "cart_id")
private Cart cart;
}