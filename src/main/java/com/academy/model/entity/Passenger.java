package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Passenger {
    private Integer id;
    private String firstName;
    private String surName;
    private String dob;
    private String sex;
    private String passportNumber;

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", dob='" + dob + '\'' +
                ", sex='" + sex + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                '}'+'\n';
    }
}
