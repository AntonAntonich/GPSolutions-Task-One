package com.anton.task.parser;

import com.anton.task.model.Address;
import com.anton.task.model.Hotel;
import com.anton.task.repository.HotelRepositoryImpl;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.List;

import static com.anton.task.TaskConstants.ADDRESS_LINE;
import static com.anton.task.TaskConstants.CITY;
import static com.anton.task.TaskConstants.COUNTRY;
import static com.anton.task.TaskConstants.HOTEL_NAME;
import static com.anton.task.TaskConstants.PRICE;


public class HotelParserImpl implements HotelParser {
    private final HotelRepositoryImpl hotels = HotelRepositoryImpl.getInstance();

    public List<Hotel> parseXmlIntoObjects(Node rootNode) {
        Hotel hotel;
        for (int i = 0; i < rootNode.getChildNodes().getLength(); i++) {
            if (rootNode.getChildNodes().item(i) instanceof Element) {
                Node hotelNode = rootNode.getChildNodes().item(i);
                hotel = new Hotel();
                String price = hotelNode.getAttributes().getNamedItem(PRICE).getTextContent();
                hotel.setPrice(price);
                extractValuesFromHotel(hotelNode, hotel);
                hotels.getHotels().add(hotel);
            }
        }
        return hotels.getHotels();
    }

    private static void extractValuesFromHotel(Node hotelNode, Hotel hotel) {
        for (int i = 0; i < hotelNode.getChildNodes().getLength(); i++) {
            if (hotelNode.getChildNodes().item(i) instanceof Element) {
                Node currentNode = hotelNode.getChildNodes().item(i);
                if (currentNode.getNodeName().equals(HOTEL_NAME)) {
                    hotel.setName(currentNode.getTextContent());
                } else {
                    extractAddress(currentNode, hotel);
                }
            }
        }
    }

    private static void extractAddress(Node currentNode, Hotel hotel) {
        Address address = new Address();
        for (int i = 0; i < currentNode.getChildNodes().getLength(); i++) {
            Node addressItem = currentNode.getChildNodes().item(i);
            if (addressItem instanceof Element) {
                if (addressItem.getNodeName().equals(ADDRESS_LINE)) {
                    address.setAddressLine(addressItem.getTextContent());
                } else if (addressItem.getNodeName().equals(CITY)) {
                    address.setCity(addressItem.getTextContent());
                } else if (addressItem.getNodeName().equals(COUNTRY)) {
                    address.setCountry(addressItem.getTextContent());
                } else {
                    address.setState(addressItem.getTextContent());
                }
            }
        }
        hotel.setAddress(address);
    }
}
