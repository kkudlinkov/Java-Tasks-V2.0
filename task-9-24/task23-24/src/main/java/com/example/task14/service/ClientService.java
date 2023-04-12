package com.example.task14.service;

import com.example.task14.model.Client;
import com.example.task14.model.User;
import com.example.task14.repository.ClientRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    private final ClientRepository clientRepository;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByUsername(username);
        if (client == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return client;
    }

    public Client findUserById(Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        return client.orElse(new Client());
    }

    public List<Client> allUsers() {
        return clientRepository.findAll();
    }

    public boolean saveUser(Client client) {
        Client clientFromDB = clientRepository.findByUsername(client.getUsername());

        if (clientFromDB != null) {
            return false;
        }
        client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
        clientRepository.save(client);
        return true;
    }

    public boolean deleteUser(Long clientId) {
        if (clientRepository.findById(clientId).isPresent()) {
            clientRepository.deleteById(clientId);
            return true;
        }
        return false;
    }

}
