package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Route {
    private Integer id;
    private String title;
    private Double duration;
    private String arrivalDateTime;
    private Integer departureCityId;
    private Integer arrivalCityId;
}
