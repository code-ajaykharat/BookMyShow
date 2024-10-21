package com.bookmyshow.backend.model;

import com.bookmyshow.backend.constant.Feature;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
public class Show extends BaseModel{
    private Movie movie;
    private LocalDateTime startTime;
    private Screen screen;
    private int duration;
    private List<Feature> features;
}
