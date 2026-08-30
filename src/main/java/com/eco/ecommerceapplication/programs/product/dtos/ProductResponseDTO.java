package com.eco.ecommerceapplication.programs.product.dtos;

import java.util.List;

import lombok.*;

@Value
@Setter
@Builder
@AllArgsConstructor
public class ProductResponseDTO {
     long productId;
     String productName;
     double price;
     int quantity;
     String description;
     List<String> imageurl ;


}
