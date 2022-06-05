package unmarshaller;

import com.anton.task.TaskConstants;
import com.anton.task.model.Hotel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.util.List;

import static com.anton.task.TaskConstants.ADDRESS;
import static com.anton.task.TaskConstants.ADDRESSES;
import static com.anton.task.TaskConstants.LISTS;
import static com.anton.task.TaskConstants.NAME;
import static com.anton.task.TaskConstants.NAMES;
import static com.anton.task.TaskConstants.PRICE;
import static com.anton.task.TaskConstants.PRICES;

public class MyXmlBuilder {

    public static void buildXml(List<Hotel> targetHotels, String fileName) throws Exception {
        Document document1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element lists = document1.createElement(LISTS);
        Element names = document1.createElement(NAMES);
        Element prices = document1.createElement(PRICES);
        Element addresses = document1.createElement(ADDRESSES);
        document1.appendChild(lists);
        lists.appendChild(names);
        lists.appendChild(prices);
        lists.appendChild(addresses);
        for (int i = 0; i < targetHotels.size(); i++) {
            names.appendChild(document1.createElement(NAME)).setTextContent(targetHotels.get(i).getName());
            addresses.appendChild(document1.createElement(ADDRESS)).setTextContent(targetHotels.get(i).getAddress().getAddressLine());
            prices.appendChild(document1.createElement(PRICE)).setTextContent(targetHotels.get(i).getPrice());
        }
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(document1), new StreamResult(new FileOutputStream(fileName)));
    }
}
