package com.academy.model.service.impl;

import com.academy.model.entity.Passenger;
import com.academy.model.repository.PassengerRepository;
import com.academy.model.repository.impl.PassengerRepositoryImpl;
import com.academy.model.service.PassengerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerServiceImp implements PassengerService {
    private PassengerRepository passengerRepository = new PassengerRepositoryImpl();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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

    @Override
    public void findById() throws IOException {
        System.out.println("Enter ID passenger");
        Integer id = Integer.parseInt(reader.readLine());
        var passenger = passengerRepository.findById(id);
        System.out.println(passenger);
    }
}
