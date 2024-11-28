package com.bookmyshow.backend.model;

import com.bookmyshow.backend.constant.BookingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
public class Booking extends BaseModel{
    @ManyToOne
    private User user;
    private int amount;
    private LocalDateTime bookingTime;
    @OneToMany
    private List<ShowSeat> showSeats;
    private BookingStatus bookingStatus;
    @OneToMany
    private List<Payment> payments;
}
