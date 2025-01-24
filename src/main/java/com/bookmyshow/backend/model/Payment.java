package com.bookmyshow.backend.model;

import com.bookmyshow.backend.constant.PaymentMode;
import com.bookmyshow.backend.constant.PaymentProvider;
import com.bookmyshow.backend.constant.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Payment extends BaseModel{
    private String paymentId;
    private int amount;
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
    @Enumerated(EnumType.STRING)
    private PaymentProvider paymentProvider;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}
