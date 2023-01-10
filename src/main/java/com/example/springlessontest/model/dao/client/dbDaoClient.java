package com.example.springlessontest.model.dao.client;

import com.example.springlessontest.model.dao.repository.ClientRepository;
import com.example.springlessontest.model.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class dbDaoClient implements IDaoClient{
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        if(clientRepository.findById(client.getId()).isPresent()){
            return clientRepository.save(client);
        }
        return null;
    }

    @Override
    public Client delete(Integer id) {
        if(clientRepository.findById(id).isPresent()) {
            //Создаём экземпляр класа для вывода.
            Client client = clientRepository.findById(id).get();
            clientRepository.deleteById(id);
            return client;
        }
        return null;
    }
}
