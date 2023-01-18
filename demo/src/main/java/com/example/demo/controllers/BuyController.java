package com.example.demo.controllers;

import com.example.demo.models.BuyModel;
import com.example.demo.repositorios.BuyRepository;
import com.example.demo.servicios.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/buys")
public class BuyController {

    @Autowired
    BuyService buyService;

    @Autowired
    BuyRepository buyRepository;

    @GetMapping()
    public ArrayList<BuyModel> getBuys(){
        return buyService.getAllBuys();
    }

   @PostMapping()
    public ResponseEntity<BuyModel> saveBuy(@RequestBody BuyModel buy){
        return this.buyService.saveBuy(buy);
    }
}
