package com.academy.controller;

import com.academy.controller.impl.OrderControllerImpl;
import com.academy.controller.impl.PassengerControllerImp;
import com.academy.model.repository.PassengerRepository;
import com.academy.model.repository.impl.PassengerRepositoryImpl;
import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Data
public class Controller {
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private PassengerController passengerController = new PassengerControllerImp();
    private PassengerRepository passengerRepository = new PassengerRepositoryImpl();

    public void menuController() throws IOException {
        System.out.println("Welcome! Airport application");
        System.out.println("1. Passenger Menu");
        System.out.println("2. City menu");
        System.out.println("3. Crew menu");
        System.out.println("4. Plane menu");
        System.out.println("5. Route menu");
        System.out.println("6. Order menu");
        System.out.println("7. Ticket menu");
        System.out.println("0. Exit");
        int number = Integer.parseInt(bufferedReader.readLine());
        switch (number) {
            case 1:
                passengerController.menuPassenger();
                break;
            case 2:
                menuController();
                break;
            case 3:
                menuController();
                break;
            case 4:
                menuController();
                break;
            case 5:
                menuController();
                break;
            case 6:
                OrderController orderController = new OrderControllerImpl();
                orderController.findAll();
                menuController();
                break;
            case 7:
                menuController();
                break;
            case 0:
                break;
            default:
                System.out.println("Введите номер меню (Enter menu number)");
                break;
        }
    }
}