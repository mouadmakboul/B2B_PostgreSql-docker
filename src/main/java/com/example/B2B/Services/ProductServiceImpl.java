// ProductServiceImpl.java
package com.example.B2B.Services;

import com.example.B2B.Entities.productEntity;

import com.example.B2B.Exceptions.ProductException;
import com.example.B2B.Repositories.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final productRepo productRepository;

    @Autowired
    public ProductServiceImpl(productRepo productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public productEntity createProduct(productEntity product) {
        // Exemple de vérification et de lancement d'une exception
        if (product.getPrix() <= 0) {
            throw new ProductException("Le prix du produit doit être supérieur à zéro.");
        }

        return productRepository.save(product);
    }
    @Override
    public productEntity getProductById(long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductException("Produit introuvable avec l'ID : " + id));
    }

    @Override
    public List<productEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public productEntity updateProduct(productEntity product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }


}