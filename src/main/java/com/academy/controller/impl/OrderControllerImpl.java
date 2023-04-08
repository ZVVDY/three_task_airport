package com.academy.controller.impl;

import com.academy.controller.Controller;
import com.academy.controller.OrderController;
import com.academy.model.service.OrderService;
import com.academy.model.service.impl.OrderServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderControllerImpl implements OrderController {
    private OrderService orderService = new OrderServiceImpl();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void menu() throws IOException {
        System.out.println("Welcome! Order Menu");
        System.out.println("1. Creating a order");
        System.out.println("2. Changing order data");
        System.out.println("3. Delete order");
        System.out.println("4. View all orders");
        System.out.println("5. Search ID order");
        System.out.println("0. Exit");
        int number = Integer.parseInt(reader.readLine());
        switch (number) {
            case 1:
                //passengerRepository.create(passengerController.create());
                menu();
                break;
            case 2:
                //passengerRepository.update(passengerController.update());
                menu();
                break;
            case 3:
                //passengerRepository.delete(passengerController.delete());
                menu();
                break;
            case 4:
                orderService.findAll();
                menu();
                break;
            case 5:
                orderService.findById();
                menu();
                break;
            case 0:
                Controller controller = new Controller();
                controller.menuController();
                break;
            default:
                System.out.println("Enter menu number");
                break;
        }
    }
}
