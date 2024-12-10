package CapaDatos;


import CapaLogica.Entrenos;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EntrenosDAO { //DAO Data Access Object de el objeto entreno

    private final String rutaXMl;

    public static EntrenosDAO(String rutaXMl){
        this.rutaXMl= rutaXMl;
    }


    //Zona métodos

    private Document connectDoc(String filePath) throws ParserConfigurationException, IOException, SAXException {
        File file = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        return doc;
    }




    // Método para leer todos los entrenamientos del XML
    public List<Entrenos> leerTodos() {

        //Zona declarativa (atributos)
        List<Entrenos> entrenos = new ArrayList<>();
        Document doc;
        NodeList nodeList;
        Element elemento;
        int id = 0;
        String nombre;
        int duracion = 0;
        String nivel;

        
        try {

            nodeList = connectDoc("xml/entrenos.xml").getElementsByTagName("entreno");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    elemento = (Element) node;
                    id = Integer.parseInt(elemento.getAttribute("id"));
                    nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                    duracion = Integer.parseInt(elemento.getElementsByTagName("duracion").item(0).getTextContent());
                    nivel = elemento.getElementsByTagName("nivel").item(0).getTextContent();
                    entrenos.add(new Entrenos(id, nombre, duracion, nivel));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entrenos;
    }

    // Método para agregar un nuevo model.entrenamiento al XML
    public void agregar(Entrenos entrenos) {
        try {


            Element root = connectDoc("xml/entrenos.xml").getDocumentElement();

            // Crear un nuevo elemento "model.entrenamiento"
            Element nuevoEntrenamiento = doc.createElement("model.entrenamiento");
            nuevoEntrenamiento.setAttribute("id", String.valueOf(entrenamiento.getId()));

            Element nombre = doc.createElement("nombre");
            nombre.setTextContent(entrenamiento.getNombre());

            Element duracion = doc.createElement("duracion");
            duracion.setTextContent(String.valueOf(entrenamiento.getDuracion()));

            Element nivel = doc.createElement("nivel");
            nivel.setTextContent(entrenamiento.getNivel());

            nuevoEntrenamiento.appendChild(nombre);
            nuevoEntrenamiento.appendChild(duracion);
            nuevoEntrenamiento.appendChild(nivel);

            root.appendChild(nuevoEntrenamiento);

            // Guardar los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un model.entrenamiento existente
    public void actualizar(int id, Entrenamiento nuevoEntrenamiento) {
        try {
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);

            NodeList nodeList = doc.getElementsByTagName("model.entrenamiento");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) node;

                    if (Integer.parseInt(elemento.getAttribute("id")) == id) {
                        elemento.getElementsByTagName("nombre").item(0).setTextContent(nuevoEntrenamiento.getNombre());
                        elemento.getElementsByTagName("duracion").item(0).setTextContent(String.valueOf(nuevoEntrenamiento.getDuracion()));
                        elemento.getElementsByTagName("nivel").item(0).setTextContent(nuevoEntrenamiento.getNivel());
                    }
                }
            }

        // Guardar los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un model.entrenamiento por ID
    public void eliminar(int id) {
        try {
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);

            NodeList nodeList = doc.getElementsByTagName("model.entrenamiento");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) node;

                    if (Integer.parseInt(elemento.getAttribute("id")) == id) {
                        elemento.getParentNode().removeChild(elemento);
                        break;
                    }
                }
            }

        // Guardar los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
