package com.bookmyshow.backend.model;

import com.bookmyshow.backend.constant.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
public class Booking extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private int amount;
    private LocalDateTime bookingTime;
    @ManyToMany
    private List<ShowSeat> showSeats;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Payment> payments;
}
