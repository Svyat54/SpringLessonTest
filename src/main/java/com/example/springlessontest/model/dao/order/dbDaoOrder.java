package com.example.springlessontest.model.dao.order;

import com.example.springlessontest.model.dao.repository.ClientRepository;
import com.example.springlessontest.model.dao.repository.OrderRepository;
import com.example.springlessontest.model.entity.Order;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class dbDaoOrder implements IDaoOrder{
    @Autowired
    private OrderRepository orderRepository;
    private ClientRepository clientRepository;
    @Override
    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    @Override
    public Order update(Order order) {
        if(orderRepository.findById(order.getId()).isPresent())
            return updateOrder(order);
        return null;
    }

    private Order updateOrder(Order order){
        Order orderUp = orderRepository.findById(order.getId()).orElse(null);
        assert orderUp != null;
        orderUp.setDescription(order.getDescription());
        if(!Objects.equals(orderUp.getClient().getId(), order.getClient().getId())){
            clientRepository.findById(orderUp.getClient().getId()).get().getOrders().remove(orderUp);
            orderUp.setClient(order.getClient());
            clientRepository.findById(order.getClient().getId()).get().getOrders().add(orderUp);
        }
        return orderUp;
    }

    @Override
    public Order delete(Integer id) {
        if(orderRepository.findById(id).isPresent()){
            Order order = orderRepository.findById(id).get();
            clientRepository.findById(orderRepository.findById(id).get().getClient().getId())
                    .get().getOrders().remove(orderRepository.findById(id).get());
            orderRepository.deleteById(id);
            return order;
        }
        return null;
    }
}
