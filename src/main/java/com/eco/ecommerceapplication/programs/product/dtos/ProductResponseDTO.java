package com.eco.ecommerceapplication.programs.product.dtos;

import java.math.BigDecimal;
import java.util.List;

import lombok.*;

@Value
@Setter
@Builder
@AllArgsConstructor
@Getter
public class ProductResponseDTO {

     private Long productId;
     private String productName;
     private Integer quantity;
     private BigDecimal price;
     private String description;

     private List<String> categories;

<<<<<<< HEAD
     private List<String> imageUrl ;
=======
     private List<String> imageurl ;
>>>>>>> 84bb21bb077be285a673840d5d72ab1c77390f50



}
