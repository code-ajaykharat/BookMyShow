package com.bookmyshow.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Show extends BaseModel {
    @ManyToOne
    private Movie movie;
    private LocalDateTime startTime;
    @ManyToOne
    private Screen screen;
    private int duration;
}
