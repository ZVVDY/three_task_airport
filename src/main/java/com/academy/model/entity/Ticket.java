package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket {
    private Integer id;
    private Integer numberPlace;
    private Double costPlace;
    private Integer orderId;
   }
