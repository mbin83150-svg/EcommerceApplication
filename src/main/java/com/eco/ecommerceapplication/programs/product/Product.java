package com.eco.ecommerceapplication.programs.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import com.eco.ecommerceapplication.programs.cart.Cart;
import com.eco.ecommerceapplication.programs.categories.Category;
import com.eco.ecommerceapplication.programs.vendor.Vendor;
=======
import com.eco.ecommerceapplication.Categories.Category;
>>>>>>> 84bb21bb077be285a673840d5d72ab1c77390f50
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
<<<<<<< HEAD

   @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
 @Builder.Default
   private List<ProductImage> images = new ArrayList<>();
=======
    
private List<ProductImage> images = new ArrayList<>();
>>>>>>> 84bb21bb077be285a673840d5d72ab1c77390f50
    // list because there can be more Images for an single product 
   
 @Transient
 private ProductImage productImage;

 @ManyToMany
<<<<<<< HEAD
    @JoinTable(name = "products_categories" ,
=======
    @JoinTable(name = "product_categories" ,
>>>>>>> 84bb21bb077be285a673840d5d72ab1c77390f50
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
     @Builder.Default
    private List<Category> categories = new ArrayList<>();
<<<<<<< HEAD

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

 
    @ManyToOne
    @JoinColumn
    private Cart cart;
}
=======
}
>>>>>>> 84bb21bb077be285a673840d5d72ab1c77390f50
