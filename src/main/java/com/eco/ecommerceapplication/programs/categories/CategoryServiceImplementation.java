package com.eco.ecommerceapplication.programs.categories;

import com.eco.ecommerceapplication.programs.categories.dtos.CategoryResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryServiceImplementation implements CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryServiceImplementation(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> resolveOrCreateCategories(List<String> categoryNames) {
        List<Category> result = new ArrayList<>();
        for (String name : categoryNames) {
            String trimmed = name.trim();
            Category category = categoryRepo.findByCategoryNameIgnoreCase(trimmed)
                    .orElseGet(() -> {
                        Category newCategory = new Category();
                        newCategory.setCategoryName(trimmed);
                        return categoryRepo.save(newCategory);
                    });
            result.add(category);
        }
        return result;
    }

    @Override
    public List<CategoryResponseDTO> searchCategories(String query) {
        List<Category> categories = (query == null || query.isBlank())
                ? categoryRepo.findAll()
                : categoryRepo.findByCategoryNameContainingIgnoreCase(query.trim());

        List<CategoryResponseDTO> result = new ArrayList<>();
        for (Category category : categories) {
            result.add(new CategoryResponseDTO(category.getCategoryId(), category.getCategoryName()));
        }
        return result;
    }
}