package com.bookmyshow.backend.service;

import com.bookmyshow.backend.model.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookTicketService {
    Booking bookTicket(int userId, int showId, List<Integer> showSeatIds);
}
