package com.example.demo.repositorios;

import com.example.demo.models.BuyModel;
import org.springframework.data.repository.CrudRepository;

public interface BuyRepository extends CrudRepository<BuyModel, Long> {
}
