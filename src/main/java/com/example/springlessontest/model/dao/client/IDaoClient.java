package com.example.springlessontest.model.dao.client;

import com.example.springlessontest.model.entity.Client;

import java.util.List;
import java.util.Optional;

public interface IDaoClient {
    List<Client> findAll();
    Optional findById(Integer id);
    Client save(Client client);
    Client update(Client client);
    Client delete(Integer id);
}
