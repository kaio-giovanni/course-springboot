package com.course.spring.services;

import com.course.spring.entities.Order;
import com.course.spring.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        List<Order> orders = repository.findAll();
        return orders;
    }

    public Order findById(Long id){
        Optional<Order> order = repository.findById(id);
        return order.get();
    }
}
