package com.example.travelbookingapplication3.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class SetRentCarRequest {

    @NotNull
    Set<UUID> setRentalCars;
}
