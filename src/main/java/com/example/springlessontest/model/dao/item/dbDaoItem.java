package com.example.springlessontest.model.dao.item;

import com.example.springlessontest.model.dao.repository.ItemRepository;
import com.example.springlessontest.model.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class dbDaoItem implements IDaoItem{

    @Autowired
    private ItemRepository itemRepository;
    @Override
    public List<Item> findAll() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public Optional<Item> findById(Integer id) {
        return itemRepository.findById(id);
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item update(Item item) {
        if(itemRepository.findById(item.getId()).isPresent()){
            return itemRepository.save(item);
        }
        return null;
    }

    @Override
    public Item delete(Integer id) {
        if(itemRepository.findById(id).isPresent()) {
            //Создаём экземпляр класа для вывода.
            Item item = itemRepository.findById(id).get();
            itemRepository.deleteById(id);
            return item;
        }
        return null;
    }
}
