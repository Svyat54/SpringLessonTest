package com.example.springlessontest.model.dao.ordersItem;

import com.example.springlessontest.model.dao.IDaoBase;
import com.example.springlessontest.model.entity.OrdersItem;
import java.util.List;
import java.util.Optional;


public interface IDaoOrdersItem extends IDaoBase<OrdersItem> {
    List<OrdersItem> findAll();
    Optional findById(Integer id);
    OrdersItem save(OrdersItem item);
    OrdersItem update(OrdersItem item);
    OrdersItem delete(Integer id);
}
