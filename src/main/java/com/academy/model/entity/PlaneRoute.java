package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PlaneRoute {
    private Integer id;
    private Integer planeId;
    private Integer routeId;
}
