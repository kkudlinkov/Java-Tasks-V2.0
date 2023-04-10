package com.example.task14.service;

import com.example.task14.model.Post;
import com.example.task14.model.User;
import com.example.task14.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public User save(User user) {
        log.info("Saving user: {}", user);
        return userRepository.save(user);
    }
    public Optional<User> findById(int id) {
        log.info("Finding user by id: {}", id);
        return userRepository.findById(id);
    }
    public User getById(int id) {
        log.info("Getting user by id: {}", id);
        return findById(id).orElseThrow();
    }
    public List<User> findAll(){
        log.info("Finding all users");
        return userRepository.findAll();
    }
    public void deleteById(int id){
        log.info("Deleting user by id: {}", id);
        userRepository.deleteById(id);
    }
    public List<User> findByFirstName(String firstName) {
        log.info("Finding user by first name: {}", firstName);
        return userRepository.findByFirstName(firstName);
    }
    public List<User> findByLastName(String lastName) {
        log.info("Finding user by last name: {}", lastName);
        return userRepository.findByLastName(lastName);
    }
    public List<User> findByMiddleName(String middleName) {
        log.info("Finding user by middle name: {}", middleName);
        return userRepository.findByMiddleName(middleName);
    }
    public List<User> findByBirthDay(LocalDate birthDay) {
        log.info("Finding user by birth day: {}", birthDay);
        return userRepository.findByBirthDate(birthDay);
    }
}
