package com.anton.task.reader;

import com.anton.task.TaskConstants;
import com.anton.task.exception.MyCustomReaderException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class MyXmlReader {
    public static Document readXml(String path) throws Exception {
        File file = new File(TaskConstants.FILE_NAME);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document document = null;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(file);
        } catch (ParserConfigurationException e) {
            throw new MyCustomReaderException("something wrong with parsing");
        } catch (SAXException e) {
            throw new MyCustomReaderException("Something wrong with SAX");
        } catch (IOException e) {
            throw new MyCustomReaderException("Something wrong with Reading");
        }
        if (document == null) {
            throw new RuntimeException("Document " + path);
        }
        return document;
    }
}
