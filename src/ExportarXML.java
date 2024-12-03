import model.entrenamiento;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public class ExportarXML {
    try{
       File file = new File("xml/entrenamientos1.xml");
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.parse(file);

       Element root = doc.getDocumentElement();

       /*Crear un nuevo elemento*/

        Element nuevoEntreno = doc.createElement("model.entrenamiento");
        nuevoEntreno.setAttribute("id", String.valueOf(entrenamiento.getId()));
        Element nombre = doc.createElement("nombre");
        nombre.setTextContent(entrenamiento.getNombre());
        Element duracion = doc.createElement("duracion");
        duracion.setTextContent(String.valueOf(entrenamiento.getDuracion()));
        Element nivel = doc.createElement("nivel");
        nivel.setTextContent(entrenamiento.getNivel());

    }catch (ParserConfigurationException e){
        throw new RuntimeException(e);
    }
}
