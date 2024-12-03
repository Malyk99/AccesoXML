package controller;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LeerEntrenamiento {
    public static void main(String[] args) {



        try{

            File file = new File("xml/entrenamientos.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            NodeList nodelist = doc.getElementsByTagName("model.entrenamiento");

            for (int i = 0; i < nodelist.getLength() ; i++) {
                Node node = nodelist.item(i);
                if (node.getNodeType() == node.ELEMENT_NODE) {
                    Element elemento = (Element) node;

                    int id = Integer.parseInt(elemento.getAttribute("id"));
                    String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                    int duracion = Integer.parseInt(elemento.getElementsByTagName("duracion").item(0).getTextContent());
                    String nivel = elemento.getElementsByTagName("nivel").item(0).getTextContent();
                    entrenamiento= new entrenamiento(id,nombre,duracion);
                    System.out.println(id);
                    System.out.println(nombre);
                    System.out.println(duracion+" minutos");
                    System.out.println(nivel);

                }

            }
            File file = new File("xml/entrenamientos.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            Element root = doc.getDocumentElement();

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
