package com.anton.task.service;

import com.anton.task.model.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> filterHotelsByNameAndAddress(List<String> addresses, String name, List<Hotel> hotels);
}
