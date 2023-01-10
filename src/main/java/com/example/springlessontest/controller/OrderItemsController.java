package com.example.springlessontest.controller;

import com.example.springlessontest.model.dao.item.IDaoItem;
import com.example.springlessontest.model.dao.order.IDaoOrder;
import com.example.springlessontest.model.dao.ordersItem.IDaoOrdersItem;
import com.example.springlessontest.model.entity.Order;
import com.example.springlessontest.model.entity.OrdersItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/orderItems")
public class OrderItemsController {
    @Autowired
    private IDaoOrdersItem iDaoOrdersItem;
    @Autowired
    private IDaoItem iDaoItem;
    @Autowired
    private IDaoOrder iDaoOrder;

    @GetMapping("/all")
    public List<OrdersItem> all(){
        return iDaoOrdersItem.findAll();
    }

    @GetMapping("/get")
    public Optional<OrdersItem> get(@RequestParam Integer id){
        return iDaoOrdersItem.findById(id);
    }

    @PostMapping("/save")
    public OrdersItem save(@RequestParam Integer quantity, @RequestParam Integer idItem, @RequestParam Integer idOrder){
        if(iDaoItem.findById(idItem).isEmpty() || iDaoOrder.findById(idOrder).isEmpty())
            return null;
        return iDaoOrdersItem.save(new OrdersItem(quantity, iDaoItem.findById(idItem).get(),
                                    iDaoOrder.findById(idOrder).get()));
    }

    @PostMapping("/update")
    public OrdersItem update(@RequestParam Integer id, @RequestParam(required = false) Integer quantity
            , @RequestParam(required = false) Integer idItem, @RequestParam(required = false) Integer idOrder){
        if(iDaoOrdersItem.findById(id).isEmpty())
            return null;
        OrdersItem ordersItem = iDaoOrdersItem.findById(id).get();
        if(quantity != null)
            ordersItem.setQuantity(quantity);
        if(idItem != null)
            if(iDaoItem.findById(idItem).isPresent())
                ordersItem.setItem(iDaoItem.findById(idItem).get());
        if(idOrder != null)
            if(iDaoOrder.findById(idOrder).isPresent())
                ordersItem.setOrder(iDaoOrder.findById(idOrder).get());
        return iDaoOrdersItem.update(ordersItem);
    }

    @GetMapping("/delete")
    public OrdersItem delete(@RequestParam Integer id){
        return iDaoOrdersItem.delete(id);
    }
}
