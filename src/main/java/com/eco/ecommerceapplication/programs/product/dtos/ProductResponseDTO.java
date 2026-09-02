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

     private List<String> imageurl ;



}
