package com.example.springlessontest.model.dao.repository;

import com.example.springlessontest.model.entity.Order;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    Optional<Order> findById(Integer id);
}
