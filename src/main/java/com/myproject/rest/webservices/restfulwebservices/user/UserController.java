package com.myproject.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping(value = "/users/{id}")
    public User getUser(@PathVariable int id){
        User user = userService.findById(id);
        if(user == null){
            throw new UserNotFoundException("id-" +id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> create(@Valid @RequestBody User user){
        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/users/{id}")
    public void delete(@PathVariable int id){
        User user = userService.deleteById(id);
        if(user == null){
            throw new UserNotFoundException("id-" +id);
        }
    }

}
