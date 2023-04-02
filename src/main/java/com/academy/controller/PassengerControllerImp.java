package com.academy.controller;

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
    private BufferedReader readerTwo = new BufferedReader(new InputStreamReader(System.in));

    public void menuPassenger() throws IOException {
        System.out.println("Welcome! Passenger Menu");
        System.out.println("1. Creating a user");
        System.out.println("2. Changing user data");
        System.out.println("3. Вернуть купленные фильмы/мероприятия (View purchased films of the event)");
        System.out.println("4. Просмотреть  купленные билеты фильмы/мероприятия (View purchased tickets films of the event)");
        System.out.println("0. Выход (Exit)");
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
//            case 3:
//                ticketService.refundMovieTicket(loginInApp);
//                menuPersonController(loginInApp);
//                break;
//            case 4:
//                ticketService.viewPurchasedMovieTickets(loginInApp);
//                menuPersonController(loginInApp);
//                break;
//            case 0:
//                log.info("Пользователь " + loginInApp + "вышел из приложения ");
//                break;
            default:
                System.out.println("Введите номер меню (Enter menu number)");
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
            System.out.println("Enter the gender");
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
        var passengerAll = passengerRepository.findAll();
        System.out.println(passengerAll);
        Passenger passenger = new Passenger();
        try {
            System.out.println("Enter Id");
            passenger.setId(readerTwo.read());
            System.out.println("Enter a name");
            passenger.setFirstName(readerTwo.readLine());
            System.out.println("Enter your last name");
            passenger.setSurName(readerTwo.readLine());
            System.out.println("Enter your birthday");
            passenger.setDob(readerTwo.readLine());
            System.out.println("Enter the gender");
            passenger.setSex(readerTwo.readLine());
            System.out.println("Enter your passport number");
            passenger.setPassportNumber(readerTwo.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passenger;
    }

    @Override
    public Passenger delete() {
        return null;
    }

    @Override
    public void findAll() {

    }
}
