package com.eco.ecommerceapplication.programs.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.List;

import com.eco.ecommerceapplication.programs.customer.Customer;
import com.eco.ecommerceapplication.programs.order.orderitem.OrderItems;
import com.eco.ecommerceapplication.programs.order.orderstatus.OrderStatus;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter 
@Setter 
@Builder 
@AllArgsConstructor 
@NoArgsConstructor 
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    
    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItems> orderItems ;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
    
    private BigDecimal totalPrice ;


    private LocalDateTime orderDate ;

}
