package com.anton.task.repository;

import com.anton.task.model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelRepositoryImpl implements HotelRepository{
    private static HotelRepositoryImpl repository;
    private static List<Hotel> hotels;

    public static HotelRepositoryImpl getInstance() {
        if (repository == null) {
            repository = new HotelRepositoryImpl();
        }
        return repository;
    }

    public List<Hotel> getHotels() {
        if (hotels == null) {
            hotels = new ArrayList<>();
        }
        return hotels;
    }
}
