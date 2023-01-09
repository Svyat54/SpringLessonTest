package com.example.springlessontest.controller;

import com.example.springlessontest.model.dao.client.IDaoClient;
import com.example.springlessontest.model.dao.order.IDaoOrder;
import com.example.springlessontest.model.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    private IDaoOrder iDaoOrder;
    @Autowired
    private IDaoClient iDaoClient;

//    @GetMapping("/add")
//    public void add(){
//        iDaoOrder.save(new Order(1, "Описание 1 заказа", ));
//        iDaoOrder.save(new Order(2, "Описание 2 заказа", ));
//        iDaoOrder.save(new Order(3, "Описание 3 заказа", ));
//    }

    @GetMapping("/all")
    public List<Order> all(){
        return iDaoOrder.findAll();
    }

    @GetMapping("/get")
    public Optional<Order> get(@RequestParam Integer id){
        return iDaoOrder.findById(id);
    }

    @PostMapping("/save")
    public Order save(@RequestParam String description, @RequestParam Integer idClient){
        if(iDaoClient.findById(idClient).isEmpty())
            return null;
        return iDaoOrder.save(new Order(description, iDaoClient.findById(idClient).get()));
    }

    @PostMapping("/update")
    public Order update(@RequestParam Integer id, @RequestParam(required = false) String description,
                        @RequestParam(required = false) Integer idClient){
        if(iDaoOrder.findById(id).isEmpty())
            return null;
        Order order = iDaoOrder.findById(id).get();
        if(description != null)
            order.setDescription(description);
        if(idClient != null)
            if(iDaoClient.findById(idClient).isPresent())
                order.setClient(iDaoClient.findById(idClient).get());
        return iDaoOrder.update(order);
    }

    @GetMapping("/delete")
    public Order delete(@RequestParam Integer id){
        if(iDaoOrder.findById(id).isPresent()){
            Order order = iDaoOrder.findById(id).get();
            iDaoOrder.delete(id);
            return order;
        }
        return null;
    }
}
