package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Crew {
    private Integer id;
    private String name;
    private String surname;
    private String post;
    private Integer planeId;
}
