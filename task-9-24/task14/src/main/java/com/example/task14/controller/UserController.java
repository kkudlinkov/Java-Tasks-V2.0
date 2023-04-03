package com.example.task14.controller;

import com.example.task14.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final List<User> users = new ArrayList<>();

    @PostMapping
    public User createUser(@RequestBody User user){
        users.add(user);
        return user;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return users;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        if (id < users.size()){
            users.remove(id);
        }
    }
}
