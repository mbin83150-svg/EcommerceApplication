package com.eco.ecommerceapplication.programs.product.dtos;


import java.math.BigDecimal;
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
         private BigDecimal price;
         private Integer quantity;
         private String description;

       private  List<String> imageurl ;
    private List<Long> categoryIds;
}

