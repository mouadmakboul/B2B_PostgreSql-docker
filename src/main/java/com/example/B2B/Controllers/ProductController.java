// ProductController.java
package com.example.B2B.Controllers;

import com.example.B2B.Entities.productEntity;
import com.example.B2B.Services.ProductService;
import com.example.B2B.Exceptions.ProductException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping(consumes = "application/json")
    public ResponseEntity<productEntity> createProduct(@RequestBody productEntity product) {
        try {
            productEntity createdProduct = productService.createProduct(product);
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        } catch (ProductException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable long id) {
        try {
            productEntity product = productService.getProductById(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }catch (ProductException e) {
            return new ResponseEntity<>("Produit introuvable avec l'ID : " + id, HttpStatus.NOT_FOUND);
    }}

    @GetMapping
    public ResponseEntity<List<productEntity>> getAllProducts() {
        List<productEntity> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<productEntity> updateProduct(@PathVariable long id, @RequestBody productEntity product) {
        try {
            product.setId(id);
            productEntity updatedProduct = productService.updateProduct(product);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } catch (ProductException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id) {
        try {
            productService.deleteProduct(id);
            return new ResponseEntity<>("Produit supprimé avec succès", HttpStatus.OK);

        } catch (ProductException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
