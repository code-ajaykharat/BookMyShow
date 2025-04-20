package com.bookmyshow.backend.model;

import com.bookmyshow.backend.constant.Language;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity(name = "Shows")
public class Show extends BaseModel {
    @ManyToOne
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;
    private LocalDateTime startTime;
    @ManyToOne
    private Screen screen;
    private int duration;
    private Language language;
}
