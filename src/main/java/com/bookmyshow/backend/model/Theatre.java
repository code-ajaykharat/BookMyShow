package com.bookmyshow.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Theatre extends BaseModel{
    private String name;
    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Show> shows;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
