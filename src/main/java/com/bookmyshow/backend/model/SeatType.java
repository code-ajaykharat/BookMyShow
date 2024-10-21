package com.bookmyshow.backend.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class SeatType extends BaseModel{
    private String value;
}
