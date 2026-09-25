package com.eco.ecommerceapplication.programs.product;

<<<<<<< HEAD
import com.eco.ecommerceapplication.programs.categories.Category;
import com.eco.ecommerceapplication.programs.categories.CategoryService;
=======
import com.eco.ecommerceapplication.Categories.Category;
import com.eco.ecommerceapplication.Categories.CategoryRepo;
>>>>>>> 84bb21bb077be285a673840d5d72ab1c77390f50
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eco.ecommerceapplication.Exceptions.ProductNotFoundException;
import com.eco.ecommerceapplication.filestorage.uploads.products.LocalImageStorage;
import com.eco.ecommerceapplication.filestorage.uploads.products.ProductImage;
import com.eco.ecommerceapplication.filestorage.uploads.products.dto.ProductImageResponse;
import com.eco.ecommerceapplication.programs.product.dtos.ProductRequestDTO;
import com.eco.ecommerceapplication.programs.product.dtos.ProductResponseDTO;

import java.util.List;
@RequiredArgsConstructor
@Transactional
@Service
public class ProductServiceImplementation implements ProductService {
    //object initialize
    private final ProductRepo productRepo;
<<<<<<< HEAD
    private final CategoryService categoryService;
=======
    private final CategoryRepo categoryRepo;
>>>>>>> 84bb21bb077be285a673840d5d72ab1c77390f50
    private final LocalImageStorage localImageStorage;
//Attach Image
private List<ProductImage> attachImages(Product product, MultipartFile[] files) {
    List<String> storedUrls = localImageStorage.store(files);
    List<ProductImage> newImages = storedUrls.stream()
            .map(url -> ProductImage.builder()
                    .imageUrl(url)
                    .product(product)
                    .build())
            .toList();
    product.getImages().addAll(newImages);
    productRepo.save(product);
    return newImages;
}
//================================================
//=========Upload Image ==========================
  @Transactional
@Override
public List<ProductImageResponse> uploadImages(Long productId, MultipartFile[] files) {
    Product product = productRepo.findById(productId)
            .orElseThrow(() -> new ProductNotFoundException("Product not found"));

    List<ProductImage> newImages = attachImages(product, files);

    return newImages.stream()
            .map(this::mapToImageResponse)
            .toList();
}
//=======================================================
    //Mapper method
<<<<<<< HEAD
     private ProductResponseDTO mapToResponseDTO(Product product ){
=======
     private ProductResponseDTO mapToResponseDTO(Product product){
>>>>>>> 84bb21bb077be285a673840d5d72ab1c77390f50

         return ProductResponseDTO.builder()
                 .productId(product.getProductId())
                 .productName(product.getProductName())
                 .quantity(product.getQuantity())
                 .price(product.getPrice())
                 .description(product.getDescription())
<<<<<<< HEAD
                 .imageUrl(
                         product.getImages()
                                 .stream()
                                 .map(ProductImage::getImageUrl)

                                 .toList()
                 )

=======
>>>>>>> 84bb21bb077be285a673840d5d72ab1c77390f50
                 .categories(
                         product.getCategories()
                                 .stream()
                                 .map(Category::getCategoryName)
                                 .toList()
                 )
<<<<<<< HEAD

=======
>>>>>>> 84bb21bb077be285a673840d5d72ab1c77390f50
                 .build();
    }
    //=======================================================
    //register product
    @Transactional
    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO) {

        List<Category> categories =
<<<<<<< HEAD
                categoryService.resolveOrCreateCategories(productRequestDTO.getCategoryName());
=======
                categoryRepo.findAllById(productRequestDTO.getCategoryIds());
>>>>>>> 84bb21bb077be285a673840d5d72ab1c77390f50

        Product product = Product.builder()
                .productName(productRequestDTO.getProductName())
                .price(productRequestDTO.getPrice())
                .quantity(productRequestDTO.getQuantity())
                .description(productRequestDTO.getDescription())
                .categories(categories)
                .build();

        Product savedProduct = productRepo.save(product);

        return mapToResponseDTO(savedProduct);
    }
    //========================================================
    //update product
    @Transactional
    @Override
    public ProductResponseDTO updateProduct(
            ProductRequestDTO productRequestDTO,
            long productId) {

        Product product = productRepo.findById(productId)
                .orElseThrow(() ->
                        new ProductNotFoundException("Product not found"));

        product.setProductName(productRequestDTO.getProductName());
        product.setQuantity(productRequestDTO.getQuantity());
        product.setPrice(productRequestDTO.getPrice());
        product.setDescription(productRequestDTO.getDescription());

        List<Category> categories =
<<<<<<< HEAD
                categoryService.resolveOrCreateCategories(productRequestDTO.getCategoryName());
=======
                categoryRepo.findAllById(productRequestDTO.getCategoryIds());
>>>>>>> 84bb21bb077be285a673840d5d72ab1c77390f50

        product.setCategories(categories);

        Product updatedProduct = productRepo.save(product);

        return mapToResponseDTO(updatedProduct);
    }

    //delete product
    @Override
    @Transactional
   public void deleteProduct(Long productId) {
    if (!productRepo.existsById(productId)) {
        throw new ProductNotFoundException("Product not found");
    }
    productRepo.deleteById(productId);
}
    //find product
    @Override
    public List<ProductResponseDTO> searchProduct(String productName){
        List<Product> products = productRepo.findProductByName(productName);

        return products.stream()
                .map(this::mapToResponseDTO).toList();                
    }

private ProductImageResponse mapToImageResponse(ProductImage image) {
    return ProductImageResponse.builder()
            .imageId(image.getImageId())
            .imageUrl(image.getImageUrl())
            .build();
}
}

