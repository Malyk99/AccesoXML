import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /*public static void main(String[] args) {


        try{
            File file = new File("xml/personas.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            NodeList nodelist = doc.getElementsByTagName("persona");

            for (int i = 0; i < nodelist.getLength() ; i++) {
                Node node = nodelist.item(i);
                if (node.getNodeType() == node.ELEMENT_NODE) {
                    Element elemento = (Element) node;

                    int id = Integer.parseInt(elemento.getAttribute("id"));
                    //String nombre = elemento.getAttribute();
                    System.out.println(id);
                }

            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }


    }*/
}