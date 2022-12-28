package com.example.springlessontest.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "item_t")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Column(nullable = false, length = 200)
    @Column
    private String itemName;
    @Column(nullable = false)
    private Long itemArticle;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private Set<OrdersItem> ordersItem;

    public Item() {
        id = -1;
        itemName = "undefined";
        itemArticle = -1L;
    }

    public Item(Integer id, String itemName, Long itemArticle, Set<OrdersItem> ordersItems) {
        this.id = id;
        this.itemName = itemName;
        this.itemArticle = itemArticle;
        this.ordersItem = ordersItems;
    }

    public Item(Integer id, String itemName, Long itemArticle) {
        this.id = id;
        this.itemName = itemName;
        this.itemArticle = itemArticle;
    }

    public Item(String itemName, Long itemArticle) {
        this.itemName = itemName;
        this.itemArticle = itemArticle;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemArticle=" + itemArticle +
                '}';
    }
}
