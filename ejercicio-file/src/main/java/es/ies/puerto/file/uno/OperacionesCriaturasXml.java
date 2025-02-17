package es.ies.puerto.file.uno;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public abstract class OperacionesCriaturasXml {

    private String path = "src/main/resources/";
    private String nombreFichero = "uno.xml";
    private File file = new File(path + nombreFichero);
    
    /**
     * Funcion que lee las criaturas del fichero
     * @return devuleve una lista de las criaturas
     */
    public List<Criatura> leerFicheroCriaturas(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            List<Criatura> criaturas = new ArrayList<>();
            NodeList lista = doc.getElementsByTagName("criatura");
            for (int i = 0; i < lista.getLength(); i++) {
                Node nodo = lista.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String id = elemento.getElementsByTagName("id").item(0).getTextContent();
                    String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                    String descripcion = elemento.getElementsByTagName("descripcion").item(0).getTextContent();
                    String categoria = elemento.getElementsByTagName("categoria").item(0).getTextContent();
                    Criatura criaturaAniadir = new Criatura(id, nombre, descripcion, categoria);
                    criaturas.add(criaturaAniadir);
                }
            }
            return criaturas;  
        } catch (Exception e) {
            throw new IllegalArgumentException("Error");
        }  
    }

    /**
     * Funcion que escribe una lista de criaturas en el Xml
     * @param criaturas a escribir
     * @return true/false
     */
    public boolean escribirEnXml(List<Criatura> criaturas){
        if (criaturas.isEmpty()) {
            return false;
        }
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            
            Element root = doc.createElement("criaturas");
            doc.appendChild(root);
            
            for (Criatura criaturaAniadir : criaturas) {
                
                Element criatura = doc.createElement("criatura");
                root.appendChild(criatura);

                Element id = doc.createElement("id");
                id.appendChild(doc.createTextNode(criaturaAniadir.getId()));
                criatura.appendChild(id);
                
                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode(criaturaAniadir.getNombre()));
                criatura.appendChild(nombre);
                
                Element descripcion = doc.createElement("descripcion");
                descripcion.appendChild(doc.createTextNode(criaturaAniadir.getDescripcion()));
                criatura.appendChild(descripcion);
                
                Element categoria = doc.createElement("categoria");
                categoria.appendChild(doc.createTextNode(criaturaAniadir.getCategoria()));
                criatura.appendChild(categoria);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/uno.xml"));
            transformer.transform(source, result);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
