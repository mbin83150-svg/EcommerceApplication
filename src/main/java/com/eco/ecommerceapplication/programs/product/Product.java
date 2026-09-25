package com.eco.ecommerceapplication.programs.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.eco.ecommerceapplication.programs.cart.Cart;
import com.eco.ecommerceapplication.programs.categories.Category;
import com.eco.ecommerceapplication.programs.vendor.Vendor;
import com.eco.ecommerceapplication.filestorage.uploads.products.ProductImage;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)   // <-- ADD THIS
@AllArgsConstructor(access = AccessLevel.PRIVATE)      // <-- Make private
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long productId;


    private String productName;
    private BigDecimal price;
    private int quantity;
    private String description;

   @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
 @Builder.Default
   private List<ProductImage> images = new ArrayList<>();
    // list because there can be more Images for an single product 
   
 @Transient
 private ProductImage productImage;

 @ManyToMany
    @JoinTable(name = "products_categories" ,
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
     @Builder.Default
    private List<Category> categories = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

 
    @ManyToOne
    @JoinColumn
    private Cart cart;
}