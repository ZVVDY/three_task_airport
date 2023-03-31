package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AirCrew {
    private Integer id;
    private Integer planeId;
    private Integer crewId;
}
