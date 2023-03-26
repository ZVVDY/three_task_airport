package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Plane {
    private Integer id;
    private String model;
    private String manufacturer;
    private Integer numberOfSeats;
  }
