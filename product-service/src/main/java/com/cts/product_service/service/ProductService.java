package com.cts.product_service.service;

import com.cts.product_service.dtos.ProductDto;
import java.util.List;

public interface ProductService {
    ProductDto addProduct(ProductDto productDto);
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long id);
    void deleteProduct(Long id);
}