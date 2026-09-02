package com.eco.ecommerceapplication.programs.product;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ProductRepo  extends JpaRepository<Product, Long> {


    @Query("SELECT p FROM Product p WHERE p.productName LIKE %:productName%")
    List<Product> findProductByName(@Param("productName") String productName);


}
