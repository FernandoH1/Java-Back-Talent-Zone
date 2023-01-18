package com.example.demo.servicios;

import com.example.demo.models.ProductModel;
import com.example.demo.repositorios.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public boolean deleteProduct(Long id) {
        try{
            productRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public boolean existProduct(Long id){
        if(productRepository.findById(id).isPresent()){
            return true;
        }
        return false;
    }

}
