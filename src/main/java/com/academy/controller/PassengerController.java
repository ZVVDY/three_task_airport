package com.academy.controller;

import com.academy.model.repository.PassengerRepository;
import com.academy.model.repository.impl.PassengerRepositoryImpl;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Array;

@Data
@AllArgsConstructor
public class PassengerController {
    private PassengerRepository passengerRepository;

    public PassengerController() {

    }

    public void menuPassenger() {
        passengerRepository = new PassengerRepositoryImpl();
        var passengerAll = passengerRepository.findAll();
        System.out.println(passengerAll);

    }
}
