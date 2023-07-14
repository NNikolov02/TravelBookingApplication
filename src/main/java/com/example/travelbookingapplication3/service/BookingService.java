package com.example.travelbookingapplication3.service;

import com.example.travelbookingapplication3.error.NotFoundObjectException;
import com.example.travelbookingapplication3.model.*;
import com.example.travelbookingapplication3.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
@Service
public class BookingService {

    @Autowired
    private BookingRepository repo;
    @Autowired
    private BookingPagingRepository pagingRepo;


    @Autowired
    private CustomerRepository userRepo;

    @Autowired
    private HotelRepository hotelRepo;

    @Autowired
    private FlightRepository flightRepo;


    @Autowired
    private RentalCarRepository rentalCarRepo;




    public Booking create(Booking booking) {
        return repo.save(booking);
    }

    public Page<Booking> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Booking findById(String bookingId) {
        return repo.findById(UUID.fromString(bookingId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Booking Not Found", Flight.class.getName(), bookingId );
        });
    }

    public void deleteById(String bookingId){
        repo.deleteById(UUID.fromString(bookingId));
    }

    public Set<UUID> setBookingCustomer(String bookingId, Set<UUID> bookingCustomerIds) {
        Booking booking = repo.findById(UUID.fromString(bookingId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Booking Not Found", Booking.class.getName(), bookingId);
        });

        List<Customer> allBookingCustomers =
                (List<Customer>) userRepo.findAllById(bookingCustomerIds);

       booking.setCustomers(new HashSet<>(allBookingCustomers));
       Booking savedBooking = repo.save(booking);

        Set<UUID> allBookingCustomerIds = new HashSet<>();
        for (Customer customer : savedBooking.getCustomers()) {
            allBookingCustomerIds.add(customer.getId());
        }

        return allBookingCustomerIds;
    }

    public Set<UUID> setBookingHotel(String bookingId, Set<UUID> bookingHotelIds) {
        Booking booking = repo.findById(UUID.fromString(bookingId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Booking Not Found", Booking.class.getName(), bookingId);
        });

        List<Hotel> allBookingHotel =
                (List<Hotel>) hotelRepo.findAllById(bookingHotelIds);

        booking.setHotels(new HashSet<>(allBookingHotel));
        Booking savedBooking = repo.save(booking);

        Set<UUID> allBookingHotelIds = new HashSet<>();
        for (Hotel hotel : savedBooking.getHotels()) {
            allBookingHotelIds.add(hotel.getId());
        }

        return allBookingHotelIds;
    }

    public Set<UUID> setBookingFlight(String bookingId, Set<UUID> bookingFlightIds) {
        Booking booking = repo.findById(UUID.fromString(bookingId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Booking Not Found", Booking.class.getName(), bookingId);
        });

        List<Flight> allBookingFlight =
                (List<Flight>) flightRepo.findAllById(bookingFlightIds);

        booking.setFlights(new HashSet<>(allBookingFlight));
        Booking savedBooking = repo.save(booking);

        Set<UUID> allBookingFlightIds = new HashSet<>();
        for (Flight flight : savedBooking.getFlights()) {
            allBookingFlightIds.add(flight.getId());
        }

        return allBookingFlightIds;
    }


    public Set<UUID> setBookingRentalCar(String bookingId, Set<UUID> bookingRentalCarIds) {
        Booking booking = repo.findById(UUID.fromString(bookingId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Booking Not Found", Booking.class.getName(), bookingId);
        });

        List<RentalCar> allBookingRentalCar =
                (List<RentalCar>) rentalCarRepo.findAllById(bookingRentalCarIds);

        booking.setRentalCars(new HashSet<>(allBookingRentalCar));
        Booking savedBooking = repo.save(booking);

        Set<UUID> allBookingRentalCarIds = new HashSet<>();
        for (RentalCar rentalCar : savedBooking.getRentalCars()) {
            allBookingRentalCarIds.add(rentalCar.getId());
        }

        return allBookingRentalCarIds;
    }

}
