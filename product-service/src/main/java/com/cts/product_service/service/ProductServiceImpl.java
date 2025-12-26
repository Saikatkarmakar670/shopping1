package com.cts.product_service.service;

import com.cts.product_service.dtos.ProductDto;
import com.cts.product_service.entities.Product;
import com.cts.product_service.repository.ProductRepository;
import com.cts.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class); // Map DTO to Entity
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDto.class); // Map back to DTO
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}