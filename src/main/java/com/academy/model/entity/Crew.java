package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Crew {
    private Integer id;
    private String name;
    private String surname;
    private String post;
    private Integer planeId;
}
