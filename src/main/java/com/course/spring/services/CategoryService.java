package com.course.spring.services;

import com.course.spring.entities.Category;
import com.course.spring.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        List<Category> categories = repository.findAll();
        return categories;
    }

    public Category findById(Long id){
        Optional<Category> categories = repository.findById(id);
        return categories.get();
    }
}
