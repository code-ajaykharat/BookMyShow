package com.bookmyshow.backend.service;

import com.bookmyshow.backend.model.Booking;

import java.util.List;

public interface BookTicketService {
    Booking bookTicket(int userId, int showId, List<Integer> showSeatIds);
}
