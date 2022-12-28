package com.example.springlessontest.model.dao.item;

import com.example.springlessontest.model.dao.IDaoBase;
import com.example.springlessontest.model.entity.Item;

import java.util.List;
import java.util.Optional;

public interface IDaoItem extends IDaoBase<Item> {
    List<Item> findAll();
    Optional findById(Integer id);
    Item save(Item item);
    Item update(Item item);
    Item delete(Integer id);
}
