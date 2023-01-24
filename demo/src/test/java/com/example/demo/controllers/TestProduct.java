package com.example.demo.controllers;

import com.example.demo.models.ProductModel;
import com.example.demo.repositorios.ProductRepository;
import com.example.demo.servicios.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc

public class TestProduct {

    @MockBean
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAllProducts() throws Exception {
        ProductModel product = new ProductModel("1",500,true,8,200);
        ArrayList<ProductModel> results = productService.getAllProducts();
        results.add(product);
        Mockito.when(productRepository.findAll()).thenReturn(Arrays.asList(product));

        Assertions.assertEquals("1",results.get(0).getName());
        Assertions.assertEquals(500,results.get(0).getInInventrory());
        Assertions.assertEquals(true,results.get(0).isEnable());
        Assertions.assertEquals(8,results.get(0).getMin());
        Assertions.assertEquals(200,results.get(0).getMax());
    }


}
