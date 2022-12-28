package com.example.springlessontest.controller;

import com.example.springlessontest.model.dao.order.IDaoOrder;
import com.example.springlessontest.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/order")
public class orderController {
    @Autowired
    private IDaoOrder iDaoOrder;

    @GetMapping("/all")
    public List<Order> all(){
        return iDaoOrder.findAll();
    }

    @GetMapping("/get")
    public Optional get(@RequestParam Integer id){
        return iDaoOrder.findById(id);
    }

    @PostMapping("/save")
    public Order save(@RequestParam String description, @RequestParam Integer id){
        return null;
    }

    @PostMapping("/update")
    public Order update(){
        return null;
    }

    @GetMapping("/delete")
    public Order delete(){
        return null;
    }
}
