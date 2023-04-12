package com.example.task14.controller;

import com.example.task14.model.Client;
import com.example.task14.model.User;
import com.example.task14.service.ClientService;
import com.example.task14.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    @PostMapping("/register")
    public boolean register(@RequestBody Client client) {
        return clientService.saveUser(client);
    }
}
