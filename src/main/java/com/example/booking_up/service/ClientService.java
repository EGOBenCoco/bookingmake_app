package com.example.booking_up.service;

import com.example.booking_up.entity.Client;
import com.example.booking_up.repository.ClientRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class ClientService {
    ClientRepository clientRepository;

    public void createClient(Client client){
        clientRepository.save(client);
    }

    public Optional<Client> getClientById(int id){
        return clientRepository.findById(id);
    }

    public void deleteClient(int id){
        clientRepository.deleteById(id);
    }

    public void updateClient(Client client){
        clientRepository.save(client);
    }
}
