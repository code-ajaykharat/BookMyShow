package com.bookmyshow.backend.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ShowSeatType extends BaseModel{
    private Show show;
    private SeatType seatType;
    private int price;
}
