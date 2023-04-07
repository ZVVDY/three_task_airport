package com.academy.controller.impl;

import com.academy.controller.Controller;
import com.academy.controller.PassengerController;
import com.academy.model.entity.Passenger;
import com.academy.model.repository.PassengerRepository;
import com.academy.model.repository.impl.PassengerRepositoryImpl;
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
    private PassengerRepository passengerRepository = new PassengerRepositoryImpl();
    private PassengerController passengerController;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void menuPassenger() throws IOException {
        System.out.println("Welcome! Passenger Menu");
        System.out.println("1. Creating a user");
        System.out.println("2. Changing user data");
        System.out.println("3. Delete user");
        System.out.println("4. View all passengers");
        System.out.println("0. Exit");
        int number = Integer.parseInt(reader.readLine());
        passengerController = new PassengerControllerImp();
        switch (number) {
            case 1:
                passengerRepository.create(passengerController.create());
                menuPassenger();
                break;
            case 2:
                passengerRepository.update(passengerController.update());
                menuPassenger();
                break;
            case 3:
                passengerRepository.delete(passengerController.delete());
                menuPassenger();
                break;
            case 4:
                passengerController.findAll();
                menuPassenger();
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

    @Override
    public Passenger create() throws IOException {
        Passenger passenger = new Passenger();
        try {
            System.out.println("Enter a name");
            passenger.setFirstName(reader.readLine());
            System.out.println("Enter your last name");
            passenger.setSurName(reader.readLine());
            System.out.println("Enter your birthday");
            passenger.setDob(reader.readLine());
            System.out.println("Enter the gender(male/female)");
            passenger.setSex(reader.readLine());
            System.out.println("Enter your passport number");
            passenger.setPassportNumber(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passenger;
    }

    @Override
    public Passenger update() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        var passengerAll = passengerRepository.findAll();
        System.out.println(passengerAll);
        Passenger passenger = new Passenger();
        try {
            System.out.println("Enter Id");
            Integer scanId = Integer.parseInt(reader.readLine());
            passenger.setId(scanId);
            System.out.println("Enter a name");
            passenger.setFirstName(reader.readLine());
            System.out.println("Enter your last name");
            passenger.setSurName(reader.readLine());
            System.out.println("Enter your birthday");
            passenger.setDob(reader.readLine());
            System.out.println("Enter the gender(male/female)");
            passenger.setSex(reader.readLine());
            System.out.println("Enter your passport number");
            passenger.setPassportNumber(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passenger;
    }

    @Override
    public Passenger delete() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        var passengerAll = passengerRepository.findAll();
        System.out.println(passengerAll);
        Passenger passenger = new Passenger();
        try {
            System.out.println("Select the user to delete");
            Integer scanId = Integer.parseInt(reader.readLine());
            passenger.setId(scanId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passenger;
    }

    @Override
    public void findAll() {
        var passengerAll = passengerRepository.findAll();
        System.out.println(passengerAll);
    }
}
