package com.course.spring.services;

import com.course.spring.entities.User;
import com.course.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> findAll(){
        List<User> users = repository.findAll();
        return users;
    }

    public User findById(Long id){
        Optional<User> user = repository.findById(id);
        return user.get();
    }

    public User create(User user){
        return repository.save(user);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(Long id, User user){
        User entity = repository.getOne(id);
        updateUser(entity, user);
        return repository.save(entity);
    }

    private void updateUser(User entity, User user){
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
