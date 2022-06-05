package com.anton.task;

import com.anton.task.model.Hotel;
import com.anton.task.parser.HotelParserImpl;
import com.anton.task.reader.MyXmlReader;
import com.anton.task.service.HotelServiceImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import unmarshaller.MyXmlBuilder;

import java.util.List;

import static com.anton.task.TaskConstants.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Document document = MyXmlReader.readXml(TaskConstants.FILE_NAME);
        Element rootElement = document.getDocumentElement();
        List<Hotel> hotels = new HotelParserImpl().parseXmlIntoObjects(rootElement);
        HotelServiceImpl hotelService = new HotelServiceImpl();
        List<Hotel> targetHotels = hotelService.filterHotelsByNameAndAddress(List.of(NEW_YORK, NY), HILTON, hotels);
        MyXmlBuilder.buildXml(targetHotels, FILE_RESULT);
    }
}
