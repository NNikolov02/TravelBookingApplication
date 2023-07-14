package com.example.travelbookingapplication3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @JsonProperty("id")
    private UUID id;

    private String passengerDetails;

    private String paymentDetails;

    private String bookingDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id_customer") // Specify a unique name for the join column
    @JsonIgnoreProperties("booking")
    private Set<Customer> customers;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id_flight") // Specify a unique name for the join column
    @JsonIgnoreProperties("booking")
    private Set<Flight> flights;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id_hotel") // Specify a unique name for the join column
    @JsonIgnoreProperties("booking")
    private Set<Hotel> hotels;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id_rental_car") // Specify a unique name for the join column
    @JsonIgnoreProperties("booking")
    private Set<RentalCar> rentalCars;
}
