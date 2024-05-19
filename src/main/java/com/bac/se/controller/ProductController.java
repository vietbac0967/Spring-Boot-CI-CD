package com.bac.se.controller;

import com.bac.se.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")

public class ProductController {
    private final List<Product> products;

    public ProductController() {
        products = new ArrayList<>();
        products.add(Product.builder().id(1).createAt(LocalDate.now()).name("Banh bo").price(2000).build());
        products.add(Product.builder().id(2).createAt(LocalDate.now()).name("Hot Dog").price(2000).build());
    }


    @GetMapping
    public List<Product> getProducts() {
        return products;
    }

    @PostMapping("/create")
    public Product insertProduct(@RequestBody Product product) {
        product.setCreateAt(LocalDate.now());
        products.add(product);
        return product;
    }

    @PostMapping("delete/{id}")
    public Product deleteProduct(@PathVariable("id") int id) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId() == id) {
                // If the product is found, remove it from the list and return it
                iterator.remove();
                return product;
            }
        }
        // If the product with the specified ID is not found, return null
        return Product.builder().build();
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product find = iterator.next();
            if (find.getId() == id) {
                // If the product is found, remove it from the list
                iterator.remove();
                // Add the updated product to the list
                products.add(product);
                // Return the updated product
                return product;
            }
        }
        // If the product with the specified ID is not found, return null
        return Product.builder().build();
    }


}
