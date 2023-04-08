package com.academy.model.service.impl;

import com.academy.model.entity.Order;
import com.academy.model.repository.OrderRepository;
import com.academy.model.repository.impl.OrderRepositoryImpl;
import com.academy.model.service.OrderService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository = new OrderRepositoryImpl();

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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

    @Override
    public void findById() throws IOException {
        System.out.println("Enter ID order");
        Integer id = Integer.parseInt(reader.readLine());
        var order = orderRepository.findById(id);
        System.out.println(order);
    }

}
