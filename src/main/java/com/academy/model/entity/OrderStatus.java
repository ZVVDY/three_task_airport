package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderStatus {
    private Integer id;
    private String statusOrder;
  }
