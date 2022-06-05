package com.anton.task.service;

import com.anton.task.model.Hotel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HotelServiceImpl implements HotelService {
    @Override
    public List<Hotel> filterHotelsByNameAndAddress(List<String> addresses, String name, List<Hotel> hotels) {
        Set<Hotel> hotelSet = new HashSet<>();
        for (Hotel hotel : hotels) {
            for (String address : addresses) {
                if (hotel.getAddress().getAddressLine().contains(address)
                        && hotel.getName().contains(name)) {
                    hotelSet.add(hotel);
                }
            }
        }
        return new ArrayList<>(hotelSet);
    }
}
