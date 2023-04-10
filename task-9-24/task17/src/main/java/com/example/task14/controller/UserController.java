package com.example.task14.controller;

import com.example.task14.model.Post;
import com.example.task14.model.User;
import com.example.task14.repository.UserRepository;
import com.example.task14.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteById(id);
    }

    @GetMapping("/findByFirstName/{firstName}")
    public List<User> findByFirstName(@PathVariable String firstName){
        return userService.findByFirstName(firstName);
    }

    @GetMapping("/findByLastName/{lastName}")
    public List<User> findByLastName(@PathVariable String lastName){
        return userService.findByLastName(lastName);
    }

    @GetMapping("/findByMiddleName/{middleName}")
    public List<User> findByMiddleName(@PathVariable String middleName){
        return userService.findByMiddleName(middleName);
    }

    @GetMapping("/findByBirthDate/{birthDay}")
    public List<User> findByBirthDate(@PathVariable String birthDay){
        return userService.findByBirthDay(LocalDate.parse(birthDay));
    }

}