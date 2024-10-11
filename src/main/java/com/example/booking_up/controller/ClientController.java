package com.example.booking_up.controller;

import com.example.booking_up.entity.Client;
import com.example.booking_up.service.ClientService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClientController {
    ClientService clientService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Client client) {
        clientService.createClient(client);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Client>> findById(@PathVariable int id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok("ok");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Client client) {
        clientService.updateClient(client);
        return ResponseEntity.ok("ok");
    }
}

