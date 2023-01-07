package com.example.springlessontest.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "order_t")
public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrdersItem> ordersItems;

    public Order() {}

    public Order(Integer id, String description, Client client) {
        this.id = id;
        this.description = description;
        this.client = client;
    }

    public Order(String description, Client client) {
        this.description = description;
        this.client = client;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", client=" + client +
                '}';
    }
}
