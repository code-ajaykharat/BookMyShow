package com.bookmyshow.backend.service.impl;

import com.bookmyshow.backend.constant.BookingStatus;
import com.bookmyshow.backend.constant.ShowSeatStatus;
import com.bookmyshow.backend.exception.ShowNotFoundException;
import com.bookmyshow.backend.exception.ShowSeatNotFoundException;
import com.bookmyshow.backend.exception.UserNotFoundException;
import com.bookmyshow.backend.model.Booking;
import com.bookmyshow.backend.model.Show;
import com.bookmyshow.backend.model.ShowSeat;
import com.bookmyshow.backend.model.User;
import com.bookmyshow.backend.repository.BookingRepository;
import com.bookmyshow.backend.repository.ShowRepository;
import com.bookmyshow.backend.repository.ShowSeatRepository;
import com.bookmyshow.backend.repository.UserRepository;
import com.bookmyshow.backend.service.BookTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookTicketServiceImpl implements BookTicketService {

    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingRepository bookingRepository;
    private UserRepository userRepository;

    @Autowired
    public BookTicketServiceImpl(ShowRepository showRepository, ShowSeatRepository showSeatRepository, BookingRepository bookingRepository, UserRepository userRepository) {
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }

    @Override
    //@Transactional(isolation = Isolation.SERIALIZABLE)
    @Transactional
    public Booking bookTicket(int userId, int showId, List<Integer> showSeatIds) {
        //get the user
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new UserNotFoundException("User not found");
        }
        //get the show
        Optional<Show> show = showRepository.findById(showId);
        if (!show.isPresent()) {
            throw new ShowNotFoundException("Show not found");
        }
        //get the show seats
        List<ShowSeat> showSeats = showSeatRepository.findAllByIdWithLock(showSeatIds);
        if (showSeats.size() != showSeatIds.size()) {
            throw new ShowSeatNotFoundException("Show seat not found");
        }
        //check if the seats are available
        for(ShowSeat showSeat : showSeats) {
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new ShowSeatNotFoundException("Show seat not available");
            }
        }
        //mark the seats as blocked - soft locking
        List<ShowSeat> savedShowSeats = new ArrayList<>();
        for(ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeat.setBlockedAt(LocalDateTime.now());
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }

        //create booking object
        Booking booking = new Booking();
        booking.setUser(user.get());
        booking.setShowSeats(savedShowSeats);
        booking.setAmount(100);//you can calculate the amount based on the show and seatype
        booking.setBookingTime(LocalDateTime.now());
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setPayments(new ArrayList<>());
        return bookingRepository.save(booking);
    }

    @Scheduled(fixedRate = 60000) // Every 1 minute
    @Transactional
    //This will be used to release the expired blocked after 15 minutes and save it to DB
    public void releaseExpiredBlockedSeats() {
        LocalDateTime cutoff = LocalDateTime.now().minusMinutes(15);

        // 1. Fetch all seats from DB
        List<ShowSeat> allSeats = showSeatRepository.findAll();

        // 2. Filter manually: only BLOCKED and expired
        List<ShowSeat> expiredBlockedSeats = new ArrayList<>();
        for (ShowSeat seat : allSeats) {
            if (seat.getShowSeatStatus() == ShowSeatStatus.BLOCKED) {
                if (seat.getBlockedAt() != null && seat.getBlockedAt().isBefore(cutoff)) {
                    expiredBlockedSeats.add(seat);
                }
            }
        }

        // 3. Unblock the expired seats
        for (ShowSeat seat : expiredBlockedSeats) {
            seat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
            seat.setBlockedAt(null);
        }

        // 4. Save updated seats back to DB
        showSeatRepository.saveAll(expiredBlockedSeats);

        if (!expiredBlockedSeats.isEmpty()) {
            System.out.println("Unblocked " + expiredBlockedSeats.size() + " expired seats");
        }
    }

}
