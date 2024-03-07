package com.example.smartvend;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
import java.util.List;
public interface ProductRepository extends MongoRepository<Product, String>{
    Optional<Product> findById(String id);
    List<Product> findAll();
    Product save(Product product);}
