package com.example.demo.servicios;

import com.example.demo.models.ProductModel;
import com.example.demo.repositorios.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ArrayList<ProductModel> getAllProducts(){
        return (ArrayList<ProductModel>) productRepository.findAll();
    }

    public ProductModel saveProduct(ProductModel product){
        return productRepository.save(product);
    }

    public ProductModel editProduct(ProductModel product){
        return productRepository.save(product);
    }

    public Optional<ProductModel> getById(Long id){
        return productRepository.findById(id);
    }

    public ResponseEntity<Map<String,Boolean>> deleteProduct(Long id) {
        ProductModel product = productRepository.findById(id).orElseThrow();
            productRepository.delete(product);
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("eliminar",Boolean.TRUE);
            return ResponseEntity.ok(respuesta);
    }

    public boolean existProduct(Long id){
        if(productRepository.findById(id).isPresent()){
            return true;
        }
        return false;
    }

}
