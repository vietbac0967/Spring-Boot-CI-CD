package com.bac.se;

import com.bac.se.controller.ProductController;
import com.bac.se.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest

class SpringBootGithubActionApplicationTests {
    @Autowired
    private  ProductController productController;
    @Test
    void contextLoads() throws Exception {
        assertThat(productController).isNotNull();
    }
    @Test
    void testGetProducts() throws Exception{
        assertThat(productController.getProducts().size()).isNotNull();
    }
    @Test
    void testCreateProduct(){
        assertThat(productController.insertProduct(Product.builder()
                        .id(3)
                        .name("banh hoi")
                        .price(2000)
                        .createAt(LocalDate.now())
                .build()).getId()).isEqualTo(3);
    }


}
