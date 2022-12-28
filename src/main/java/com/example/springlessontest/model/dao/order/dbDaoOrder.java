package com.example.springlessontest.model.dao.order;

import com.example.springlessontest.model.dao.repository.OrderRepository;
import com.example.springlessontest.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class dbDaoOrder implements IDaoOrder{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Optional findById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order item) {
        return null;
    }

    @Override
    public Order update(Order item) {
        return null;
    }

    @Override
    public Order delete(Integer id) {
        return null;
    }
}
