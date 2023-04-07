package com.academy;

import com.academy.controller.Controller;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;

@Data
@AllArgsConstructor
public class Runner {

    public static void main(String[] args) throws IOException {

        Controller controller = new Controller();
        controller.menuController();
    }
}
