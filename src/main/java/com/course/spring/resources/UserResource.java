package com.course.spring.resources;

import com.course.spring.dto.UserDTO;
import com.course.spring.entities.User;
import com.course.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> users = userService.findAll();

        List<UserDTO> usersDto = users.stream().map(u -> new UserDTO(u))
                .collect(Collectors.toList());
        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        User user = userService.findById(id);

        UserDTO userDTO = new UserDTO(user);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserDTO> create(@RequestBody User user){
        User newUser = userService.create(user);

        UserDTO userDTO = new UserDTO(newUser);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody User user){
        user = userService.update(id, user);

        UserDTO userDTO = new UserDTO(user);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
