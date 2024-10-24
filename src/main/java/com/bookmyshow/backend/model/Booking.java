package com.bookmyshow.backend.model;

import com.bookmyshow.backend.constant.BookingStatus;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
public class Booking extends BaseModel{
    private User user;
    private int amount;
    private LocalDateTime bookingTime;
    private List<ShowSeat> showSeats;
    private BookingStatus bookingStatus;
    private List<Payment> payments;
}
