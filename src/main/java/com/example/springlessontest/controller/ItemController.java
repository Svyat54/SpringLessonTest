package com.example.springlessontest.controller;

import com.example.springlessontest.model.dao.item.IDaoItem;
import com.example.springlessontest.model.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private IDaoItem iDaoItem;
    //Быстрое добавление объектов
    @GetMapping("/add")
    public void add(){
        iDaoItem.save(new Item(1, "Телевизор", 111L));
        iDaoItem.save(new Item(2, "Холодильник", 222L));
        iDaoItem.save(new Item(3, "X-Box", 333L));
    }

    @GetMapping("/all")
    public List<Item> all(){
        return iDaoItem.findAll();
    }

    @GetMapping("/get")
    public Optional<Item> get (@RequestParam Integer id){
        return iDaoItem.findById(id);
    }

    @PostMapping("/save")
    public Item save (@RequestParam String itemName, @RequestParam Long itemArticle){
        return iDaoItem.save(new Item(itemName, itemArticle));
    }

    @PostMapping("/update")
    public Item update(@RequestParam Integer id, @RequestParam(required = false) String itemName,
                       @RequestParam(required = false) Long itemArticle){
        Item item = new Item(id, itemName, itemArticle);
        return iDaoItem.update(item);
    }

    @GetMapping("/delete")
    public Item delete(@RequestParam Integer id){
        return iDaoItem.delete(id);
    }

    @GetMapping("/ping")
    public String ping(){
        return "item_pong";
    }
}
