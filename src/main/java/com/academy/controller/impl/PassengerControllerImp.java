package com.academy.controller.impl;

import com.academy.controller.Controller;
import com.academy.controller.PassengerController;
import com.academy.model.repository.PassengerRepository;
import com.academy.model.repository.impl.PassengerRepositoryImpl;
import com.academy.model.service.PassengerService;
import com.academy.model.service.impl.PassengerServiceImp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerControllerImp implements PassengerController {
    private PassengerService passengerService = new PassengerServiceImp();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void menu() throws IOException {
        System.out.println("Welcome! Passenger Menu");
        System.out.println("1. Creating a user");
        System.out.println("2. Changing user data");
        System.out.println("3. Delete user");
        System.out.println("4. View all passengers");
        System.out.println("5. Search ID passengers");
        System.out.println("0. Exit");
        int number = Integer.parseInt(reader.readLine());
        PassengerRepository passengerRepository = new PassengerRepositoryImpl();
        switch (number) {
            case 1:
                passengerRepository.create(passengerService.create());
                menu();
                break;
            case 2:
                passengerRepository.update(passengerService.update());
                menu();
                break;
            case 3:
                passengerRepository.delete(passengerService.delete());
                menu();
                break;
            case 4:
                passengerService.findAll();
                menu();
                break;
            case 5:
                passengerService.findById();
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
