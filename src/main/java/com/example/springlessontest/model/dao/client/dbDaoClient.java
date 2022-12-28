package com.example.springlessontest.model.dao.client;

import com.example.springlessontest.model.dao.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class dbDaoClient {
    @Autowired
    private ClientRepository clientRepository;
}
