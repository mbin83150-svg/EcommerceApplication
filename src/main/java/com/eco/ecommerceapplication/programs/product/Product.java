package com.eco.ecommerceapplication.programs.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.eco.ecommerceapplication.Categories.Category;
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
    
private List<ProductImage> images = new ArrayList<>();
    // list because there can be more Images for an single product 
   
 @Transient
 private ProductImage productImage;

 @ManyToMany
    @JoinTable(name = "product_categories" ,
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
     @Builder.Default
    private List<Category> categories = new ArrayList<>();
}
