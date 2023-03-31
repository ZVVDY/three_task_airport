package com.academy.model.repository.impl;

import com.academy.model.DataSourceManager;
import com.academy.model.entity.Passenger;
import com.academy.model.repository.PassengerRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Builder
@AllArgsConstructor
public class PassengerRepositoryImpl implements PassengerRepository {
    @Override
    public void create(Passenger entity) {

    }

    @Override
    public void update(Passenger entity) {

    }

    @Override
    public void delete(Passenger entity) {

    }

    @Override
    public List<Passenger> findAll() {
        var passengers = new ArrayList<Passenger>();

        var connection = DataSourceManager.getInstance().getConnection();

        var sql = "SELECT * FROM passenger";

        try (var preparedStatement = connection.prepareStatement(sql)) {

                        var resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                var passenger = Passenger.builder()
                        .id(resultSet.getInt("id"))
                        .firstName(resultSet.getString("first_name"))
                        .surName(resultSet.getString("sur_name"))
                        .dob(resultSet.getString("dob"))
                        .sex(resultSet.getString("sex"))
                        .passportNumber(resultSet.getString("passport_number"))
                        .build();

                passengers.add(passenger);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return passengers;
    }

    @Override
    public Passenger findById(Integer ID) {
        return null;
    }
}
