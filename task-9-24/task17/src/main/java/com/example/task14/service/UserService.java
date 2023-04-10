package com.example.task14.service;

import com.example.task14.model.Post;
import com.example.task14.model.User;
import com.example.task14.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    public User getById(int id) {
        return findById(id).orElseThrow();
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    public List<User> findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public List<User> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public List<User> findByMiddleName(String middleName) {
        return userRepository.findByMiddleName(middleName);
    }

    public List<User> findByBirthDay(LocalDate birthDay) {
        return userRepository.findByBirthDate(birthDay);
    }
}
