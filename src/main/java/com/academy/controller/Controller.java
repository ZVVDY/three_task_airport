package com.academy.controller;

import com.academy.model.repository.PassengerRepository;
import com.academy.model.repository.impl.PassengerRepositoryImpl;
import lombok.AllArgsConstructor;
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
        System.out.println("2. Посмотреть фильмы мероприятия в кинотеатре (Watch movies events at the cinema) ");
        System.out.println("3. Вернуть купленные фильмы/мероприятия (View purchased films of the event)");
        System.out.println("4. Просмотреть  купленные билеты фильмы/мероприятия (View purchased tickets films of the event)");
        System.out.println("0. Выход (Exit)");
        int number = Integer.parseInt(bufferedReader.readLine());
        switch (number) {
            case 1:
                passengerController.menuPassenger();
                                break;
//            case 2:
//                filmService.watchMoviesEventsAtTheCinema(loginInApp);
//                menuPersonController(loginInApp);
//                break;
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
}