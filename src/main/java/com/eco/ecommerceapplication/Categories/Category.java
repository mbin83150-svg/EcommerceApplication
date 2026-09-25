package com.eco.ecommerceapplication.Categories;


import com.eco.ecommerceapplication.programs.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long categoryId;


    @Column(nullable = false, unique = true)
    String categoryName;



    @ManyToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();



}
