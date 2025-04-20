package com.bookmyshow.backend.controller;

import com.bookmyshow.backend.dto.request.BookTicketRequest;
import com.bookmyshow.backend.dto.response.BookTicketResponse;
import com.bookmyshow.backend.exception.BookTicketException;
import com.bookmyshow.backend.model.Booking;
import com.bookmyshow.backend.service.BookTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.bookmyshow.backend.constant.ResponseStatus.FAILURE;
import static com.bookmyshow.backend.constant.ResponseStatus.SUCCESS;

@RestController
public class BookTicketController {
    private BookTicketService bookTicketService;

    @Autowired // best for unit testing and immutability
    public BookTicketController (BookTicketService bookTicketService) {
        this.bookTicketService = bookTicketService;
    }

    @PostMapping("/bookTicket")
    public BookTicketResponse bookTicket(@RequestBody BookTicketRequest requestdto) {
        BookTicketResponse response = new BookTicketResponse();
        try {
            Booking booking = bookTicketService.bookTicket(requestdto.getUserId(), requestdto.getShowId(), requestdto.getShowSeatIds());
            response.setBookingId(booking.getId());
            response.setAmount(booking.getAmount());
            response.setStatus(SUCCESS);
        } catch (Exception e) {
            response.setStatus(FAILURE);
        }
        return response;
    }
}
