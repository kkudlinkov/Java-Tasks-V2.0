package com.example.task14.repository;

import com.example.task14.model.User;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
public interface UserFilter {
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    List<User> findByMiddleName(String middleName);
    List<User> findByBirthDate(LocalDate birthDay);

}
