package com.example.travelbookingapplication3.service;

import com.example.travelbookingapplication3.error.NotFoundObjectException;
import com.example.travelbookingapplication3.model.Hotel;
import com.example.travelbookingapplication3.repository.HotelPagingRepository;
import com.example.travelbookingapplication3.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
@Service
public class HotelService {

    @Autowired
    private HotelRepository repo;

    @Autowired
    private HotelPagingRepository pagingRepo;


    public Page<Hotel> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Hotel book(Hotel hotel){
        return repo.save(hotel);

    }

    public void deleteById(String hotelId){
        repo.deleteById(UUID.fromString(hotelId));
    }
    public Hotel findById(String hotelId) {
        return repo.findById(UUID.fromString(hotelId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Hotel Not Found", Hotel.class.getName(), hotelId );
        });
    }
}
