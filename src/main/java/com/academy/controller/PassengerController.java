package com.academy.controller;

import com.academy.model.entity.Passenger;

import java.io.IOException;

public interface PassengerController extends DefaultController<Passenger> {
    void menuPassenger() throws IOException;
}
