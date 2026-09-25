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

<<<<<<< HEAD
       private  List<String> imageUrl ;
    private List<Long> categoryIds;
    private List<String> categoryName;
=======
       private  List<String> imageurl ;
    private List<Long> categoryIds;
>>>>>>> 84bb21bb077be285a673840d5d72ab1c77390f50
}

