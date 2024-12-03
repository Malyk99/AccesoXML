import model.entrenamiento;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class CrearXML {
    public void agregar(entrenamiento entrenamiento) {
        try {
            File file = new File("xml/entrenamientos.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);

            Element root = doc.getDocumentElement();

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
}
