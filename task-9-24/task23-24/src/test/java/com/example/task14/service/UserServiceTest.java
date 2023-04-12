package com.example.task14.service;

import com.example.task14.model.User;
import com.example.task14.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Captor
    ArgumentCaptor<User> captor;

    @Test
    void createUser() {
        LocalDate date = LocalDate.now();
        userService.save(new User(1, "Nikolai", "Kudlinkov","Sergeevich", date,null));
        Mockito.verify(userRepository).save(captor.capture());
        var captured = captor.getValue();
        Assertions.assertEquals("Nikolai", captured.getFirstName());
        Assertions.assertEquals("Kudlinkov", captured.getLastName());
    }

    @Test
    void deleteUser(){
        userService.deleteById(1);
        Mockito.verify(userRepository).deleteById(1);
    }

    @Test
    void getAll() {
        var user1 = new User(1, "Nikolai", "Kudlinkov","Sergeevich", LocalDate.now(),null);
        var user2 = new User(1, "Nikolai", "Kudlinkov","Sergeevich", LocalDate.now(),null);
        Mockito.when(userRepository.findAll()).thenReturn(List.of(user1, user2));

        Assertions.assertEquals(2, userService.findAll().size());
        Assertions.assertEquals("Nikolai", userService.findAll().get(0).getFirstName());
    }
}
