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
    public void create(Passenger passenger) {
        var connection = DataSourceManager.getInstance().getConnection();

        var sql = "INSERT INTO passenger (first_name, sur_name, dob, sex, passport_number) VALUES (?, ?, ?, ?, ?)";

        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, passenger.getFirstName());
            preparedStatement.setString(2, passenger.getSurName());
            preparedStatement.setString(3, passenger.getDob());
            preparedStatement.setString(4, passenger.getSex());
            preparedStatement.setString(5, passenger.getPassportNumber());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Passenger passenger) {
        var connection = DataSourceManager.getInstance().getConnection();

        var sql = "UPDATE passenger SET first_name = ?, sur_name = ?, dob = ?, sex = ?,passport_number=?  WHERE id = ?";

        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, passenger.getFirstName());
            preparedStatement.setString(2, passenger.getSurName());
            preparedStatement.setString(3, passenger.getDob());
            preparedStatement.setString(4, passenger.getSex());
            preparedStatement.setString(5, passenger.getPassportNumber());
            /***
             *
             */
            preparedStatement.setInt(6, passenger.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Passenger passenger) {
        var connection = DataSourceManager.getInstance().getConnection();

        var sql = "DELETE FROM passenger WHERE id = ?";

        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, passenger.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    public Passenger findById(Integer id) {
        var passenger = Passenger.builder();

        var connection = DataSourceManager.getInstance().getConnection();

        var sql = "SELECT * FROM passenger WHERE id = ?";

        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            var resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                passenger
                        .id(resultSet.getInt("id"))
                        .firstName(resultSet.getString("first_name"))
                        .surName(resultSet.getString("sur_name"))
                        .dob(resultSet.getString("dob"))
                        .sex(resultSet.getString("sex"))
                        .passportNumber(resultSet.getString("passport_number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passenger.build();
    }
}
