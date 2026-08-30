package com.eco.ecommerceapplication.programs.product.dtos;


import java.util.List;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ProductRequestDTO
{



         private String productName;
         private double price;
         private int quantity;
         private String description;

         List<String> imageurl ;

}

