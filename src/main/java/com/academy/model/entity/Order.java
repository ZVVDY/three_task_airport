package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Order {
    private Integer id;
    private String dateOrder;
    private Plane plane;
    private Route route;
    private Passenger passenger;
    private OrderStatus orderStatus;
  }
