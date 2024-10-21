package com.bookmyshow.backend.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class User extends BaseModel{
    private String name;
    private String email;
    private List<Booking> bookings;
}
