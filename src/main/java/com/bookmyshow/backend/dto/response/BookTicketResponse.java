package com.bookmyshow.backend.dto.response;

import com.bookmyshow.backend.constant.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponse {
    private int bookingId;
    private int amount;
    private ResponseStatus status;
}
