package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String name;
    private int inInventrory;
    private boolean enable;
    private int min;
    private int max;
    private int quantity;


    public ProductModel() {}

    public ProductModel(String name, int inInventrory, boolean enable, int min, int max) {
        this.name = name;
        this.inInventrory = inInventrory;
        this.enable = enable;
        this.min = min;
        this.max = max;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInInventrory() {
        return inInventrory;
    }

    public void setInInventrory(int inInventrory) {
        this.inInventrory = inInventrory;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
