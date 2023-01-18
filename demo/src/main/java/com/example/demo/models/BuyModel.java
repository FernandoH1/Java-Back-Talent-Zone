package com.example.demo.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "buy")
public class BuyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;


    private LocalDate localDate;
    private String idType;
    private String clientName;
    private ArrayList<ProductBuy> products;

    public BuyModel() {}

    public BuyModel(String idType, String clientName, ArrayList<ProductBuy> products) {
        this.localDate = LocalDate.now();
        this.idType = idType;
        this.clientName = clientName;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public ArrayList<ProductBuy> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductBuy> products) {
        this.products = products;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
