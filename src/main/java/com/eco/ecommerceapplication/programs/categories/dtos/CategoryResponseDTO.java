package com.eco.ecommerceapplication.programs.categories.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDTO {
    private Long categoryId;
    private String categoryName;
}