package com.example.springlessontest.controller;

import com.example.springlessontest.model.dao.client.IDaoClient;
import com.example.springlessontest.model.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/client")
public class ClientController {
    @Autowired
    private IDaoClient iDaoClient;

//    @GetMapping("/add")
//    public void add(){
//        iDaoClient.save(new Client(1, "Jon"));
//        iDaoClient.save(new Client(2, "Bob" ));
//        iDaoClient.save(new Client(3, "Karl" ));
//    }

    @GetMapping("/all")
    public List<Client> all(){
        return iDaoClient.findAll();
    }

    @GetMapping("/get")
    public Optional<Client> get(@RequestParam Integer id){
        return iDaoClient.findById(id);
    }

    @PostMapping("/save")
    public Client save(@RequestParam String nameClient){
        return iDaoClient.save(new Client(nameClient));
    }

    @PostMapping("/update")
    public Client update(@RequestParam Integer id,@RequestParam String nameClient){
        Client client = new Client(id,nameClient);
        return iDaoClient.update(client);
    }

    @GetMapping("/delete")
    public Client delete(@RequestParam Integer id){
        return iDaoClient.delete(id);
    }

}
