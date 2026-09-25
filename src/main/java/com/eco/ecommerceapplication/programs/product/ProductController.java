package com.eco.ecommerceapplication.programs.product;

<<<<<<< HEAD
=======
import com.eco.ecommerceapplication.filestorage.uploads.products.ProductImageRepo;
>>>>>>> 84bb21bb077be285a673840d5d72ab1c77390f50
import com.eco.ecommerceapplication.filestorage.uploads.products.dto.ProductImageResponse;
import com.eco.ecommerceapplication.programs.product.dtos.ProductRequestDTO;
import com.eco.ecommerceapplication.programs.product.dtos.ProductResponseDTO;
import com.eco.ecommerceapplication.shared.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
=======
import org.hibernate.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedOperation;
>>>>>>> 84bb21bb077be285a673840d5d72ab1c77390f50
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
@Validated

public class ProductController {

    private final ProductService productService;
    //Create Product ===================
    @PostMapping
public ResponseEntity<ApiResponse<ProductResponseDTO>> addProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO createdProduct = productService.addProduct(
                productRequestDTO
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(createdProduct, "Product Added Successfully : "));
    }
    @PutMapping("/{productId}")

    public ResponseEntity<ApiResponse<ProductResponseDTO>> updateProduct(

            @PathVariable long productId,

            @Valid @RequestBody ProductRequestDTO productRequestDTO) {

        ProductResponseDTO updatedProduct = productService.updateProduct(productRequestDTO, productId);
        return ResponseEntity.ok(
                ApiResponse.success(updatedProduct, "Product updated successfully"));
    }

    // Upload Images ====================

    @PostMapping("/{productId}/images")
    public ResponseEntity<ApiResponse<List<ProductImageResponse>>> uploadImage(

            @PathVariable Long productId,
            @RequestParam("files") MultipartFile[] files
    ) {
        List<ProductImageResponse> uploadImages =
                productService.uploadImages(productId, files);

        return ResponseEntity.ok(
                ApiResponse.success(
                        uploadImages,
                        "Images Uploaded successfully"
                )
        );
    }


    //  Delete Product ==================
    @DeleteMapping("/{productId}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok(
                ApiResponse.success(null, "Product Deleted Successfully : ")
        );
    }

    //Search Product
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<ProductResponseDTO>>> searchProduct(
            @RequestParam String productName
            ){
        List<ProductResponseDTO> products = productService.searchProduct(productName);
        return ResponseEntity.ok(ApiResponse.success(products , products.size() +
                "product(s) found successfully "));
    }

    }


