package com.academy.controller;

import com.academy.controller.impl.OrderControllerImpl;
import com.academy.controller.impl.PassengerControllerImp;
import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Data
public class Controller {
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private PassengerController passengerController = new PassengerControllerImp();

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
                passengerController.menu();
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
                orderController.menu();
                menuController();
                break;
            case 7:
                menuController();
                break;
            case 0:
                break;
            default:
                System.out.println("Enter menu number");
                break;
        }
    }
}