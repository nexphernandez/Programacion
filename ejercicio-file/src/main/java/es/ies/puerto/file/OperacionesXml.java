package es.ies.puerto.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

import es.ies.puerto.file.uno.Criatura;

public abstract class OperacionesXml {

    private String path = "src/main/resources/";
    private String nombreFichero = "uno.xml";
    File file = new File(path + nombreFichero);
    
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

    public boolean escribirEnXml(List<Criatura> criaturas){
        
    }
}
