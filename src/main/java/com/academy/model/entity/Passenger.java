package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Passenger {
    private Integer id;
    private String name;
    private String surname;
    private String dob;
    private String sex;
    private String passportNumber;
}
