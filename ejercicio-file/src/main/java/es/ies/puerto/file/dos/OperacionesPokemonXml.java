package es.ies.puerto.file.dos;

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
public abstract class OperacionesPokemonXml {

    private String path = "src/main/resources/";
    private String nombreFichero = "dos.xml";
    File file = new File(path + nombreFichero);
    
    /**
     * Funcion que lee los Pokemon del fichero
     * @return devuleve una lista de los Pokemons
     */
    public List<Pokemon> leerFicheroCriaturas(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            List<Pokemon> pokemons = new ArrayList<>();
            NodeList lista = doc.getElementsByTagName("pokemon");
            for (int i = 0; i < lista.getLength(); i++) {
                Node nodo = lista.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String id = elemento.getElementsByTagName("id").item(0).getTextContent();
                    String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                    List<String> tipos = new ArrayList<>();
                    NodeList listaTipos = doc.getElementsByTagName("tipos");
                    for (int j = 0; j < listaTipos.getLength(); j++) {
                        Node nodoTipos = lista.item(i);
                        if (nodoTipos.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoTipo = (Element) nodoTipos;
                            String tipo = elementoTipo.getElementsByTagName("tipo").item(0).getTextContent();
                            tipos.add(tipo);
                        }
                    }
                    String descripcion = elemento.getElementsByTagName("categoria").item(0).getTextContent();
                    Pokemon pokemonAniadir = new Pokemon(id, nombre, tipos, descripcion);
                    pokemons.add(pokemonAniadir);
                }
            }
            return pokemons;  
        } catch (Exception e) {
            throw new IllegalArgumentException("Error");
        }  
    }

    /**
     * Funcion que escribe una lista de pokemons en el Xml
     * @param pokemons a escribir
     * @return true/false
     */
    public boolean escribirEnXml(List<Pokemon> pokemons){
        if (pokemons.isEmpty()) {
            return false;
        }
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            
            Element root = doc.createElement("pokedex");
            doc.appendChild(root);
            
            for (Pokemon pokemonAniadir : pokemons) {
                
                Element pokemon = doc.createElement("pokemon");
                root.appendChild(pokemon);

                Element id = doc.createElement("id");
                id.appendChild(doc.createTextNode(pokemonAniadir.getId()));
                pokemon.appendChild(id);
                
                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode(pokemonAniadir.getNombre()));
                pokemon.appendChild(nombre);

                Element tipos = doc.createElement("tipos");
                tipos.appendChild(doc.createTextNode(pokemonAniadir.getTipos()));
                pokemon.appendChild(tipos);
                
                Element descripcion = doc.createElement("descripcion");
                descripcion.appendChild(doc.createTextNode(pokemonAniadir.getDescripcion()));
                pokemon.appendChild(descripcion);
                
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/dos.xml"));
            transformer.transform(source, result);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
