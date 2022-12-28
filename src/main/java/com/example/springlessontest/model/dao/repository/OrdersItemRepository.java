package com.example.springlessontest.model.dao.repository;

import com.example.springlessontest.model.entity.OrdersItem;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface OrdersItemRepository extends CrudRepository<OrdersItem, Integer> {
    Optional<OrdersItem> findById(Integer id);
}
