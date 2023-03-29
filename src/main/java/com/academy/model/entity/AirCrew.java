package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AirCrew {
    private Integer id;
    private Integer planeId;
    private Integer crewId;
}
