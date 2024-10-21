package com.bookmyshow.backend.model;

import com.bookmyshow.backend.constant.ShowSeatStatus;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ShowSeat extends BaseModel{
    private Show show;
    private Seat seat;
    private ShowSeatStatus showSeatStatus;
}
