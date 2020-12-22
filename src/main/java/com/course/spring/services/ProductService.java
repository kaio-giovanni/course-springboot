package com.course.spring.services;

import com.course.spring.entities.Product;
import com.course.spring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        List<Product> products = repository.findAll();
        return products;
    }

    public Product findById(Long id){
        Optional<Product> product = repository.findById(id);
        return product.get();
    }
}
