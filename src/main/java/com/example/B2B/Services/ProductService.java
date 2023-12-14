package com.example.B2B.Services;

import com.example.B2B.Entities.productEntity;

import java.util.List;

public interface ProductService {
    productEntity createProduct(productEntity product);
    productEntity getProductById(long id);
    List<productEntity> getAllProducts();
    productEntity updateProduct(productEntity product);
    void deleteProduct(long id);


}