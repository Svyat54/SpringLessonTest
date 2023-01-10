package com.example.springlessontest.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
//@RequiredArgsConstructor
@Entity
@Table(name = "ordersItem_t")
public class OrdersItem {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public OrdersItem() {}

    public OrdersItem(Integer id, Integer quantity, Item item, Order order) {
        this.id = id;
        this.quantity = quantity;
        this.item = item;
        this.order = order;
    }

    public OrdersItem(Integer quantity, Item item, Order order) {
        this.quantity = quantity;
        this.item = item;
        this.order = order;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", item=" + item +
                ", order=" + order +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrdersItem that = (OrdersItem) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
