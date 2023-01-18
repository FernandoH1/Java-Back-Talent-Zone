package com.example.demo.servicios;

import com.example.demo.models.BuyModel;
import com.example.demo.models.ProductModel;
import com.example.demo.repositorios.BuyRepository;
import com.example.demo.repositorios.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class BuyService {

    @Autowired
    BuyRepository buyRepository;

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    public ArrayList<BuyModel> getAllBuys(){
        return (ArrayList<BuyModel>) buyRepository.findAll();
    }

   public ResponseEntity<BuyModel> saveBuy(BuyModel buy) {
       for (int i = 0; i < buy.getProducts().size(); i++) {
            if (productService.existProduct(buy.getProducts().get(i).getId())) {
                Optional<ProductModel> productModel = productRepository.findById(buy.getProducts().get(i).getId());
                if (buy.getProducts().get(i).getQuantity() > productModel.get().getMin()
                        && buy.getProducts().get(i).getQuantity() < productModel.get().getMax()) {
                    productModel.get().setInInventrory(productModel.get().getInInventrory() - buy.getProducts().get(i).getQuantity());
                    return new ResponseEntity<>(buyRepository.save(buy),HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
