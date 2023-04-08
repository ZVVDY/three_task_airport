package com.academy.model.repository.impl;

import com.academy.model.DataSourceManager;
import com.academy.model.entity.*;
import com.academy.model.repository.OrderRepository;
import lombok.Data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public void create(Order order) {
        var connection = DataSourceManager.getInstance().getConnection();

        var query = "INSERT INTO orders (number_order, date_order, route_id, plane_id, passenger_id, status_order_id) VALUES (?, ?, ?, ?,?,?)";

        try (var preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, order.getDateOrder());
            preparedStatement.setInt(2, order.getRoute().getId());
            preparedStatement.setInt(3, order.getPlane().getId());
            preparedStatement.setInt(4, order.getPassenger().getId());
            preparedStatement.setInt(5, order.getOrderStatus().getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Order order) {
        var connection = DataSourceManager.getInstance().getConnection();

        var sql = "UPDATE orders SET number_order = ?, date_order = ?, route_id = ?, plane_id = ?, passenger_id = ?, status_order_id=?  WHERE id = ?";

        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, order.getDateOrder());
            preparedStatement.setInt(2, order.getRoute().getId());
            preparedStatement.setInt(3, order.getPlane().getId());
            preparedStatement.setInt(4, order.getPassenger().getId());
            preparedStatement.setInt(5, order.getOrderStatus().getId());
            preparedStatement.setInt(6, order.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Order order) {
        var connection = DataSourceManager.getInstance().getConnection();
        var sql = "DELETE FROM orders WHERE id = ?";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, order.getId());
            preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Order> findAll() {
        var orders = new ArrayList<Order>();

        var connection = DataSourceManager.getInstance().getConnection();

        String sql = "SELECT \n" +
                "passenger.id AS passenger_id,passenger.first_name as first_name,passenger.sur_name as sur_name, \n" +
                "passenger.dob as dob,passenger.sex as sex, passenger.passport_number as passport_number,\n" +
                "orders.id AS order_number, orders.date_order as date_order,orders.order_status_id as order_status_id,\n" +
                "route.duration as duration, route.arrival_date_time as arrival_date_time,route.arrival_city_id as arrival_city_id,\n" +
                "route.departure_city_id as departure_city_id,\n" +
                "order_status.id as order_status_id,order_status.status_order as status_order,\n" +
                "plane.model as model,plane.manufacturer as manufacturer,plane.number_of_seats as number_of_seats,\n" +
                "ticket.id as ticket_number, ticket.cost_place as cost_place, ticket.number_place as number_place\n" +
                "                FROM orders  \n" +
                "                JOIN order_status ON  order_status.id=orders.order_status_id\n" +
                "                JOIN   passenger  ON passenger.id = orders.id \n" +
                "                JOIN  plane  ON plane.id = orders.id \n" +
                "                JOIN route  ON route.id=orders.id\n" +
                "                JOIN ticket  ON ticket.id = orders.id";

        try (var preparedStatement = connection.prepareStatement(sql)) {

            var resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                var passenger = Passenger.builder()
                        .id(resultSet.getInt("passenger_id"))
                        .firstName(resultSet.getString("first_name"))
                        .surName(resultSet.getString("sur_name"))
                        .dob(resultSet.getString("dob"))
                        .sex(resultSet.getString("sex"))
                        .passportNumber(resultSet.getString("passport_number"))
                        .build();

                var plane = Plane.builder()
                        .model(resultSet.getString("model"))
                        .numberOfSeats(resultSet.getInt("number_of_seats"))
                        .manufacturer(resultSet.getString("manufacturer"))
                        .build();

                var orderStatus = OrderStatus.builder()
                        .id(resultSet.getInt("order_status_id"))
                        .statusOrder(resultSet.getString("status_order"))
                        .build();

                var departureCity = City.builder()
                        .title(resultSet.getString("departure_city_id"))
                        .build();

                var arrivalCity = City.builder()
                        .title(resultSet.getString("arrival_city_id"))
                        .build();

                var route = Route.builder()
                        .duration(resultSet.getDouble("duration"))
                        .arrivalDateTime(resultSet.getString("arrival_date_time"))
                        .departureCity(departureCity)
                        .arrivalCity(arrivalCity)
                        .build();

                var ticket = Ticket.builder()
                        .id(resultSet.getInt("ticket_number"))
                        .costPlace(resultSet.getDouble("cost_place"))
                        .numberPlace(resultSet.getInt("number_place"))
                        .build();

                var order = Order.builder()
                        .id(resultSet.getInt("order_number"))
                        .dateOrder(resultSet.getString("date_order"))
                        .passenger(passenger)
                        .orderStatus(orderStatus)
                        .plane(plane)
                        .route(route)
                        .ticket(ticket)
                        .build();


                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    @Override
    public Order findById(Integer id) {
        var order = new Order();

        var connection = DataSourceManager.getInstance().getConnection();

        String sql = "SELECT \n" +
                "passenger.id AS passenger_id,passenger.first_name as first_name,passenger.sur_name as sur_name, \n" +
                "passenger.dob as dob,passenger.sex as sex, passenger.passport_number as passport_number,\n" +
                "orders.id AS order_id, orders.date_order as date_order,orders.order_status_id as order_status_id,\n" +
                "route.duration as duration, route.arrival_date_time as arrival_date_time,route.arrival_city_id as arrival_city_id,\n" +
                "route.departure_city_id as departure_city_id,\n" +
                "order_status.id as order_status_id,order_status.status_order as status_order,\n" +
                "plane.model as model,plane.manufacturer as manufacturer,plane.number_of_seats as number_of_seats,\n" +
                "ticket.id as ticket_number, ticket.cost_place as cost_place, ticket.number_place as number_place\n" +
                "                FROM orders  \n" +
                "                JOIN order_status ON  order_status.id=orders.order_status_id\n" +
                "                JOIN   passenger  ON passenger.id = orders.id \n" +
                "                JOIN  plane  ON plane.id = orders.id \n" +
                "                JOIN route  ON route.id=orders.id\n" +
                "                JOIN ticket  ON ticket.id = orders.id\n" +
                "where orders.id = ?";

        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            var resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                var passenger = Passenger.builder()
                        .id(resultSet.getInt("passenger_id"))
                        .firstName(resultSet.getString("first_name"))
                        .surName(resultSet.getString("sur_name"))
                        .dob(resultSet.getString("dob"))
                        .sex(resultSet.getString("sex"))
                        .passportNumber(resultSet.getString("passport_number"))
                        .build();

                var plane = Plane.builder()
                        .model(resultSet.getString("model"))
                        .numberOfSeats(resultSet.getInt("number_of_seats"))
                        .manufacturer(resultSet.getString("manufacturer"))
                        .build();

                var orderStatus = OrderStatus.builder()
                        .id(resultSet.getInt("order_status_id"))
                        .statusOrder(resultSet.getString("status_order"))
                        .build();

                var departureCity = City.builder()
                        .title(resultSet.getString("departure_city_id"))
                        .build();

                var arrivalCity = City.builder()
                        .title(resultSet.getString("arrival_city_id"))
                        .build();

                var route = Route.builder()
                        .duration(resultSet.getDouble("duration"))
                        .arrivalDateTime(resultSet.getString("arrival_date_time"))
                        .departureCity(departureCity)
                        .arrivalCity(arrivalCity)
                        .build();

                var ticket = Ticket.builder()
                        .id(resultSet.getInt("ticket_number"))
                        .costPlace(resultSet.getDouble("cost_place"))
                        .numberPlace(resultSet.getInt("number_place"))
                        .build();

                order.setId(resultSet.getInt("order_id"));
                order.setDateOrder(resultSet.getString("date_order"));
                order.setPassenger(passenger);
                order.setPlane(plane);
                order.setOrderStatus(orderStatus);
                order.setRoute(route);
                order.setTicket(ticket);

            } else {
                System.out.println(" No search ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }
}
