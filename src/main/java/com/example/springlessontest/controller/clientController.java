package com.example.springlessontest.controller;

import com.example.springlessontest.model.dao.client.IDaoClient;
import com.example.springlessontest.model.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/client")
public class clientController {
    @Autowired
    private IDaoClient iDaoClient;

    @GetMapping("/all")
    public List<Client> all(){
        return iDaoClient.findAll();
    }

    @GetMapping("/get")
    public Optional get(@RequestParam Integer id){
        return iDaoClient.findById(id);
    }

    @PostMapping("/save")
    public Client save(@RequestParam String nameClient){
        return iDaoClient.save(new Client(nameClient));
    }

    @PostMapping("/update")
    public Client update(@RequestParam String nameClient){
        Client client = new Client(nameClient);
        return iDaoClient.update(client);
    }

    @GetMapping("/delete")
    public Client delete(@RequestParam Integer id){
        return iDaoClient.delete(id);
    }

}
