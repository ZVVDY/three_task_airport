package com.academy.model.repository.impl;

import com.academy.model.DataSourceManager;
import com.academy.model.entity.Plane;
import com.academy.model.repository.PlaneRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaneRepositoryImpl implements PlaneRepository {
        @Override
    public void create(Plane plane) {
        var connection = DataSourceManager.getInstance().getConnection();

        var sql = "INSERT INTO plane (model,manufacturer, number_of_seats) VALUES (?, ?, ?)";

        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, plane.getModel());
            preparedStatement.setString(2, plane.getManufacturer());
            preparedStatement.setInt(3, plane.getNumberOfSeats());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Plane plane) {
        var connection = DataSourceManager.getInstance().getConnection();

        var sql = "UPDATE plane SET  model= ?,  manufacturer= ?, number_of_seats = ? WHERE id = ?";

        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, plane.getModel());
            preparedStatement.setString(2, plane.getManufacturer());
            preparedStatement.setInt(3, plane.getNumberOfSeats());
            preparedStatement.setInt(4, plane.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Plane plane) {
        var connection = DataSourceManager.getInstance().getConnection();

        var sql = "DELETE FROM plane WHERE id = ?";

        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, plane.getId());

            preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public List<Plane> findAll() {
        var planes = new ArrayList<Plane>();

        var connection = DataSourceManager.getInstance().getConnection();

        var sql = "SELECT * FROM plane";

        try (var preparedStatement = connection.prepareStatement(sql)) {

            var resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                var plane = Plane.builder()
                        .id(resultSet.getInt("id"))
                        .model(resultSet.getString("model"))
                        .manufacturer(resultSet.getString("manufacturer"))
                        .numberOfSeats(resultSet.getInt("number_of_seats"))
                        .build();

                planes.add(plane);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planes;
    }
    @Override
    public Plane findById(Integer id) {
        var plane = Plane.builder();

        var connection = DataSourceManager.getInstance().getConnection();

        var sql = "SELECT * FROM plane WHERE id = ?";

        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            var resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                plane
                        .id(resultSet.getInt("id"))
                        .model(resultSet.getString("model"))
                        .manufacturer(resultSet.getString("manufacturer"))
                        .numberOfSeats(resultSet.getInt("number_of_seats"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return plane.build();
    }
}
