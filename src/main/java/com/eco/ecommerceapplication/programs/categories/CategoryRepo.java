package com.eco.ecommerceapplication.programs.categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Query("""
       SELECT c
       FROM Category c
       WHERE LOWER(c.categoryName) = LOWER(:categoryName)
       """)
    Optional<Category> findByCategoryNameIgnoreCase(
            @Param("categoryName") String categoryName
    );
    List<Category> findByCategoryNameContainingIgnoreCase(String query);


}
