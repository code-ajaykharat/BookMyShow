package com.bookmyshow.backend.model;

import com.bookmyshow.backend.constant.PaymentMode;
import com.bookmyshow.backend.constant.PaymentProvider;
import com.bookmyshow.backend.constant.PaymentStatus;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Payment extends BaseModel{
    private String paymentId;
    private int amount;
    private PaymentMode paymentMode;
    private PaymentProvider paymentProvider;
    private PaymentStatus paymentStatus;
}
