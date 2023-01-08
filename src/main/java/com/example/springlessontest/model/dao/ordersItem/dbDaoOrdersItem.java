package com.example.springlessontest.model.dao.ordersItem;

import com.example.springlessontest.model.dao.repository.ItemRepository;
import com.example.springlessontest.model.dao.repository.OrderRepository;
import com.example.springlessontest.model.dao.repository.OrdersItemRepository;
import com.example.springlessontest.model.entity.OrdersItem;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class dbDaoOrdersItem implements IDaoOrdersItem{
    @Autowired
    private OrdersItemRepository ordersItemRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrdersItem> findAll() {
        return (List<OrdersItem>) ordersItemRepository.findAll();
    }

    @Override
    public Optional<OrdersItem> findById(Integer id) {
        return ordersItemRepository.findById(id);
    }

    @Override
    public OrdersItem save(OrdersItem ordersItem) {
        return ordersItemRepository.save(ordersItem);
    }

    @Transactional
    @Override
    public OrdersItem update(OrdersItem ordersItem) {
        if(ordersItemRepository.findById(ordersItem.getId()).isPresent())
            return updateOrdersItem(ordersItem);
        return null;
    }

    private OrdersItem updateOrdersItem(OrdersItem ordersItem){
        OrdersItem ordersItemUP = ordersItemRepository.findById(ordersItem.getId()).orElse(null);
        assert ordersItemUP != null;
        if(ordersItemUP.getQuantity() != null)
            ordersItemUP.setQuantity(ordersItem.getQuantity());
        if(!Objects.equals(ordersItemUP.getItem().getId(), ordersItem.getItem().getId())){
            itemRepository.findById(ordersItemUP.getItem().getId()).get().getOrdersItem().remove(ordersItemUP);
            ordersItemUP.setItem(ordersItem.getItem());
            itemRepository.findById(ordersItemUP.getItem().getId()).get().getOrdersItem().add(ordersItemUP);
        }
        if(!Objects.equals(ordersItemUP.getOrder().getId(), ordersItem.getItem().getId())){
            orderRepository.findById(ordersItemUP.getOrder().getId()).get().getOrdersItems().remove(ordersItemUP);
            ordersItemUP.setOrder(ordersItem.getOrder());
            orderRepository.findById(ordersItemUP.getOrder().getId()).get().getOrdersItems().add(ordersItemUP);
        }
        return ordersItemUP;
    }

    @Override
    public OrdersItem delete(Integer id) {
        if(ordersItemRepository.findById(id).isPresent()){
            OrdersItem ordersItem = ordersItemRepository.findById(id).get();
            itemRepository.findById(ordersItemRepository.findById(id).get().getItem().getId())
                    .get().getOrdersItem().remove(ordersItemRepository.findById(id).get());
            orderRepository.findById(ordersItemRepository.findById(id).get().getOrder().getId())
                            .get().getOrdersItems().remove(ordersItemRepository.findById(id).get());
            ordersItemRepository.deleteById(id);
            return ordersItem;
        }
        return null;
    }
}
