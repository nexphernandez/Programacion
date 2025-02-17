package es.ies.puerto.file.uno;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class FileXmlCriatura {

    private String path = "src/main/resources/";
    private String nombreFichero = "uno.xml";
    File file = new File(path + nombreFichero);
    

    /**
     * Constructor que verifica si el archivo existe el fichero
     */
    public FileXmlCriatura(){
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                throw new IllegalArgumentException("No se puede crear el fichero");
            }
        }
    }

    /**
     * Funcion que lee el archivo xml y te devuelve una lista de criaturas
     * @return lista de criaturas
     * @throws ParserConfigurationException 
     * @throws IOException 
     * @throws SAXException 
     * @return lista de criaturas
     */
    public List<Criatura> obtenerCriaturas() throws ParserConfigurationException, SAXException, IOException {
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
    }

    public Criatura obtener(Criatura criatura) throws ParserConfigurationException, SAXException, IOException {
        if (criatura == null) {
            return null;
        }
        List<Criatura> criaturas = obtenerCriaturas();
        for (Criatura criaturaBuscar : criaturas) {
            if (criaturaBuscar.equals(criatura)) {
                return criaturaBuscar;
            }
        }
        return null;
    }
    public void addCriatura(Criatura criatura) {
    }
    public void deleteCriatura(Criatura criatura) {

    }
    public void updateCriatura(Criatura criatura) {

    }
}
