package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Ticket {
    private Integer id;
    private Integer numberPlace;
    private Double costPlace;
    private Order order;
   }
