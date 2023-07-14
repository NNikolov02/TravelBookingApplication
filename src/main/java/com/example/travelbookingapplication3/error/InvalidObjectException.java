package com.example.travelbookingapplication3.error;

import java.util.Map;

public class InvalidObjectException extends TravelBookingApiException{

    private final Map<String, String> errors;

    public InvalidObjectException(String message, Map<String, String> errors) {
        super(message);
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

}
