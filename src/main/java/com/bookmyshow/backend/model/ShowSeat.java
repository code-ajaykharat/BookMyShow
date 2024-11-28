package com.bookmyshow.backend.model;

import com.bookmyshow.backend.constant.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ShowSeat extends BaseModel{
    @OneToOne
    private Show show;
    @OneToOne
    private Seat seat;
    private ShowSeatStatus showSeatStatus;
}
