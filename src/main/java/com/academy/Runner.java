package com.academy;

import com.academy.controller.PassengerController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Runner {

    public static void main(String[] args) {
        PassengerController passengerController = new PassengerController();
        passengerController.menuPassenger();

    }
}
