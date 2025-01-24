package com.bookmyshow.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Seat extends BaseModel{
    private String number;
    private int rowVal;
    private int colVal;
    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;
    @ManyToOne
    private SeatType seatType;
}
