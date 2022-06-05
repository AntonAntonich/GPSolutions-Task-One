package com.anton.task.parser;

import com.anton.task.model.Hotel;
import org.w3c.dom.Node;

import java.util.List;

public interface HotelParser {
    List<Hotel> parseXmlIntoObjects(Node rootNode);
}
