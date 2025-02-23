package es.ies.puerto.file.dos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Clase para manejar operaciones XML relacionadas con Pokémon.
 * @author alexfdb
 * @version 1.1.0
 */
public abstract class XmlOperationsPok {

    static String path = "src/main/resources/dos.xml";

    /**
     * Lee los datos de un archivo XML y los convierte en un Set de objetos Pokémon.
     * @return el Set de Pokémon extraído del archivo XML.
     */
    protected List<Pokemon> xmlPokRead() {
        List<Pokemon> pokemons = new ArrayList<>();
        try {
            Document document = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(new File(path));

            NodeList nodeList = document.getElementsByTagName("pokemon");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);

                String id = element.getElementsByTagName("id").item(0).getTextContent();
                String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();

                NodeList tipoNodes = element.getElementsByTagName("tipo");
                List<String> tipos = new ArrayList<>();
                for (int j = 0; j < tipoNodes.getLength(); j++) {
                    tipos.add(tipoNodes.item(j).getTextContent());
                }

                String descripcion = element.getElementsByTagName("descripcion").item(0).getTextContent();

                pokemons.add(new Pokemon(id, nombre, tipos, descripcion));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pokemons;
    }

    /**
     * Escribe un Set de Pokémon en un archivo XML.
     * @param pokemons el Set de Pokémon que se escribirá en el archivo XML.
     */
    protected void xmlPokWrite(List<Pokemon> pokemons) {
        try {
            Document document = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .newDocument();

            Element root = document.createElement("pokedex");
            document.appendChild(root);

            for (Pokemon pokemon : pokemons) {
                Element pokemonElement = document.createElement("pokemon");

                Element id = document.createElement("id");
                id.appendChild(document.createTextNode(pokemon.getId()));
                pokemonElement.appendChild(id);

                Element nombre = document.createElement("nombre");
                nombre.appendChild(document.createTextNode(pokemon.getNombre()));
                pokemonElement.appendChild(nombre);

                Element tipos = document.createElement("tipos");
                for (String tipo : pokemon.getTipos()) {
                    Element tipoElement = document.createElement("tipo");
                    tipoElement.appendChild(document.createTextNode(tipo));
                    tipos.appendChild(tipoElement);
                }
                pokemonElement.appendChild(tipos);

                Element descripcion = document.createElement("descripcion");
                descripcion.appendChild(document.createTextNode(pokemon.getDescripcion()));
                pokemonElement.appendChild(descripcion);

                root.appendChild(pokemonElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newDefaultInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            File outputFile = new File(path);
            transformer.transform(new DOMSource(document), new StreamResult(outputFile));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}