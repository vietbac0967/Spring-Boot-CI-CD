package com.bac.se;

import com.bac.se.controller.ProductController;
import com.bac.se.model.Product;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SpringBootGithubActionApplicationTests {
    int a;
    @Autowired
    private ProductController productController;

    @Test
    void contextLoads() throws Exception {
        assertThat(productController).isNotNull();
    }

    @Test
    void testGetProducts() throws Exception {
        assertThat(productController.getProducts().size()).isNotNull();
    }

    @Test
    void testCreateProduct() {
        assertThat(productController.insertProduct(Product.builder()
                .id(3)
                .name("banh hoi")
                .price(2000)
                .createAt(LocalDate.now())
                .build()).getId()).isEqualTo(3);
    }

    @Test
    void testDeleteProduct() {
        Product product = productController.deleteProduct(1);
        assertEquals(product.getId(),1);
        assertEquals(productController.getProducts().size(),2);

    }

    @Test
    void testUpdateProduct() {

        Product updatedProduct = Product.builder()
                .id(1)
                .name("Banh bao xa xiu")
                .price(5000)
                .createAt(LocalDate.now())
                .build();

        // Act
        Product result = productController.updateProduct(1, updatedProduct);

        // Assert
        assertNotNull(result);
        assertEquals(updatedProduct.getName(), result.getName());

    }
}
