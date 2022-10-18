package com.johnoro.cpm.service;

import com.johnoro.cpm.model.Client;
import com.johnoro.cpm.repository.ClientRepository;

public class ClientService extends BaseServiceImpl<Client> {
    public ClientService(ClientRepository repository) {
        super(repository);
    }
}
