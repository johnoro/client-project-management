package com.johnoro.cpm.controller;

import com.johnoro.cpm.model.Client;
import com.johnoro.cpm.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping
    public List<Client> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Client save(@RequestBody Client client) {
        return service.save(client);
    }

    @PutMapping
    public Client update(@RequestBody Client client) {
        return service.update(client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}