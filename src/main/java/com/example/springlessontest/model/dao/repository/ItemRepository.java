package com.example.springlessontest.model.dao.repository;

import com.example.springlessontest.model.entity.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Integer> {
    Optional<Item> findById(Integer id);
}
