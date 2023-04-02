package com.academy;

import com.academy.controller.Controller;
import com.academy.controller.PassengerControllerImp;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;

@Data
@AllArgsConstructor
public class Runner {

    public static void main(String[] args) throws IOException {
//        PassengerControllerImp passengerController = new PassengerControllerImp();
//        passengerController.menuPassenger();
        Controller controller = new Controller();
        controller.menuController();
    }
}
