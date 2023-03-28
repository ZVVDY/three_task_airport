package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private Integer id;
    private Integer numberOrder;
    private String dateOrder;
    private Integer routeId;
    private Integer planeId;
    private Integer passengerId;
    private Integer statusOrderId;
  }
