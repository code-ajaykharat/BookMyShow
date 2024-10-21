package com.bookmyshow.backend.model;

import com.bookmyshow.backend.constant.Feature;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Movie extends BaseModel{
    private String name;
    private String description;
    private List<Feature> features;
}
