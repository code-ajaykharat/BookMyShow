package com.bookmyshow.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ShowSeatType extends BaseModel{
    @OneToOne
    private Show show;
    @OneToOne
    private SeatType seatType;
    private int price;
}
