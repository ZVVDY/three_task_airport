package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private Integer id;
    private String dateOrder;
    private Plane plane;
    private Route route;
    private Passenger passenger;
    private OrderStatus orderStatus;
    private Ticket ticket;
}