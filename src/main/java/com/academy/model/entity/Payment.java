package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Payment {
    private Integer id;
    private Integer statusPaymentId;
    private Integer orderId;
}
