package com.constock.api.resources;

import com.constock.api.models.Product;
import com.constock.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProductResource {
    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/products")
    public List<Product> ListProducts() {
        return productRepository.findAll();
    }

    @GetMapping(value = "/product/{id}")
    public Product showProduct(@PathVariable(value = "id") long id) {
        return productRepository.findById(id);
    }

    @PostMapping(value = "/product")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping(value = "/product/{id}")
    public void deleteProduct(@PathVariable(value = "id") long id) {
        productRepository.deleteById(id);
    }

    @PutMapping(value = "/product")
    public Product updateProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
