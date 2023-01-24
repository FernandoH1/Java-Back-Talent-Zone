package com.example.demo.controllers;

import com.example.demo.models.ProductModel;
import com.example.demo.repositorios.ProductRepository;
import com.example.demo.servicios.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200" )
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @GetMapping()
    public ArrayList<ProductModel> getProducts(){
        return productService.getAllProducts();
    }

    @PostMapping()
    public ProductModel saveProduct(@RequestBody ProductModel product){
        return this.productService.saveProduct(product);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductModel> saveProductPut(@PathVariable("id") long id, @RequestBody ProductModel product){
        Optional<ProductModel> productData = productRepository.findById(id);

        if (productData.isPresent()) {
            ProductModel _product = productData.get();
            _product.setName(product.getName());
            _product.setInInventrory(product.getInInventrory());
            _product.setEnable(product.isEnable());
            _product.setMin(product.getMin());
            _product.setMax(product.getMax());
            return new ResponseEntity<>(productRepository.save(_product), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping( path = "/{id}")
    public Optional<ProductModel> getProductById(@PathVariable("id") Long id) {
        return this.productService.getById(id);
    }

    @DeleteMapping( path = "/{id}")
    public String deleteProductById(@PathVariable("id") Long id){
        boolean ok = this.productService.deleteProduct(id);
        if (ok){
            return "Se eliminó el producto con id " + id;
        }else{
            return "No se pudo eliminar el producto con id" + id;
        }
    }
}
