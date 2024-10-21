package com.bookmyshow.backend.model;

import com.bookmyshow.backend.constant.Feature;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Screen extends BaseModel{
    private String name;
    private int capacity;
    private List<Seat> seats;
    private List<Feature> features;
    private Theatre theatre;
}
