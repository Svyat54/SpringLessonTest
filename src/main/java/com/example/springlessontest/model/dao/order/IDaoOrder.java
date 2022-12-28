package com.example.springlessontest.model.dao.order;

import com.example.springlessontest.model.entity.Order;
import java.util.List;
import java.util.Optional;

public interface IDaoOrder {
    List<Order> findAll();
    Optional findById(Integer id);
    Order save(Order item);
    Order update(Order item);
    Order delete(Integer id);
}