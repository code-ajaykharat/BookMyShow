package com.bookmyshow.backend.model;

import com.bookmyshow.backend.constant.Feature;
import com.bookmyshow.backend.constant.Language;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Movie extends BaseModel{
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Feature> features;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Language> languages;
}
