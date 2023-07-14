package com.example.travelbookingapplication3.error;

import java.util.UUID;

public class TravelBookingApiException extends RuntimeException {

    private final UUID errorId;

    public TravelBookingApiException(String message) {
        super(message);
        this.errorId = UUID.randomUUID();
    }

    public UUID getErrorId() {
        return errorId;
    }
}
