package com.academy.controller.impl;

import com.academy.controller.OrderController;
import com.academy.model.entity.Order;
import com.academy.model.repository.OrderRepository;
import com.academy.model.repository.impl.OrderRepositoryImpl;

import java.io.IOException;

public class OrderControllerImpl implements OrderController {
    private OrderRepository orderRepository = new OrderRepositoryImpl();

    @Override
    public Order create() throws IOException {
        return null;
    }

    @Override
    public Order update() {
        return null;
    }

    @Override
    public Order delete() {
        return null;
    }

    @Override
    public void findAll() {
        var ordersAll = orderRepository.findAll();
        for (Order order :
                ordersAll) {
            System.out.println(order);
        }

    }
}
