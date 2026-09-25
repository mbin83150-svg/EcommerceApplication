package com.eco.ecommerceapplication.programs.categories;

import com.eco.ecommerceapplication.programs.categories.dtos.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {

    List<Category> resolveOrCreateCategories(List<String> categoryNames);

    List<CategoryResponseDTO> searchCategories(String query);

}
