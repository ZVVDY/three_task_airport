package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlaneRoute {
    private Integer id;
    private Integer planeId;
    private Integer routeId;
}
