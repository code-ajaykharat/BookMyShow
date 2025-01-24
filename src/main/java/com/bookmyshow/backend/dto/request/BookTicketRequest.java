package com.bookmyshow.backend.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequest {
    private int userId;
    private int showId;
    private List<Integer> showSeatIds;
}
