package com.NMN.foodorder.services;


import java.util.List;

import org.springframework.stereotype.Component;

import com.NMN.foodorder.entities.Orders;
import com.NMN.foodorder.entities.User;
import com.NMN.foodorder.repositories.OrderRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderServices {

    private final OrderRepository orderRepository;

    public List<Orders> getOrders() {
        return orderRepository.findAll();
    }

    public void saveOrder(Orders order) {
        orderRepository.save(order);
    }

    public void updateOrder(int id, Orders order) {
        order.setoId(id);
        orderRepository.save(order);
    }

    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    public List<Orders> getOrdersForUser(User user) {
        return orderRepository.findOrdersByUser(user);
    }
}

