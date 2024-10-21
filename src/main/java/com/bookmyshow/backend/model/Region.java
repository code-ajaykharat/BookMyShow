package com.bookmyshow.backend.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Region extends BaseModel {
    private String name;
    private List<Movie> movies;
    private List<Theatre> theatres;
}
