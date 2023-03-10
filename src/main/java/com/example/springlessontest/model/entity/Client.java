package com.example.springlessontest.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "client_t")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String nameClient;

    @JsonIgnore
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet<>();

    public Client() {}

    public Client(Integer id, String nameClient, Set<Order> orders) {
        this.id = id;
        this.nameClient = nameClient;
        this.orders = orders;
    }

    public Client(Integer id,String nameClient) {
        this.id = id;
        this.nameClient = nameClient;
    }

    public Client(String nameClient) {
        this.nameClient = nameClient;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", nameClient='" + nameClient + '\'' +
                ", orders=" + orders +
                '}';
    }
}
