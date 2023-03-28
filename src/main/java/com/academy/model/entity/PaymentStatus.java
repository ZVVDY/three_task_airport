package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentStatus {
    private Integer id;
    private String statusPayment;
}
