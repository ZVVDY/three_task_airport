package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Plane {
    private Integer id;
    private String model;
    private String manufacturer;
    private Integer numberOfSeats;
  }
