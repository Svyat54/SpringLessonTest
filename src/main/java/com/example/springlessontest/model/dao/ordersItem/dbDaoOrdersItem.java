package com.example.springlessontest.model.dao.ordersItem;

import com.example.springlessontest.model.dao.repository.OrdersItemRepository;
import com.example.springlessontest.model.entity.OrdersItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class dbDaoOrdersItem implements IDaoOrdersItem{
    @Autowired
    private OrdersItemRepository ordersItemRepository;

    @Override
    public List<OrdersItem> findAll() {
        return (List<OrdersItem>) ordersItemRepository.findAll();
    }

    @Override
    public Optional<OrdersItem> findById(Integer id) {
        return ordersItemRepository.findById(id);
    }

    @Override
    public OrdersItem save(OrdersItem item) {
        return null;
    }

    @Override
    public OrdersItem update(OrdersItem item) {
        return null;
    }

    @Override
    public OrdersItem delete(Integer id) {
        return null;
    }
}
