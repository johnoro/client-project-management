package com.johnoro.cpm.service;

import com.johnoro.cpm.model.Client;
import com.johnoro.cpm.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends BaseServiceImpl<Client> {
    @Autowired
    private ClientRepository repository;

    public ClientService(ClientRepository repository) {
        super(repository);
    }
}
