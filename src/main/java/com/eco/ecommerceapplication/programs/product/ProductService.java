package com.eco.ecommerceapplication.programs.product;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.eco.ecommerceapplication.filestorage.uploads.products.dto.ProductImageResponse;
import com.eco.ecommerceapplication.programs.product.dtos.ProductRequestDTO;
import com.eco.ecommerceapplication.programs.product.dtos.ProductResponseDTO;

public interface ProductService {

    ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO);

    ProductResponseDTO updateProduct(ProductRequestDTO productRequestDTO, long productId);

    void deleteProduct(Long productId);

    List<ProductResponseDTO> searchProduct(String productName);

  //   ProductResponseDTO uploadImages(Long productId, MultipartFile[] files);
    // interface
       List<ProductImageResponse> uploadImages(Long productId, MultipartFile[] files);
}


