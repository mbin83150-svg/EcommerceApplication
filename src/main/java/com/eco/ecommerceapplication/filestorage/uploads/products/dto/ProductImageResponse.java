package com.eco.ecommerceapplication.filestorage.uploads.products.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductImageResponse {
    
    private Long imageId;
    private  String imageUrl;
}