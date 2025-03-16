package es.ies.puerto.model;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author nexphernandez
 * @version 1.0.0
 */

public class OperacionesFile {
    final String pathCsv = "src/main/resources/usuarios.csv";
    final String pathXml = "src/main/resources/usuarios.xml";
    final String pathJson = "src/main/resources/usuarios.json";
    Set<UsuarioModel> usuarioModels;
    File csvFile;
    File xmlFile;
    File jsonFile;
    ObjectMapper objectMapper;

    /**
     * Cosntructor vacio
     */
    public OperacionesFile() {
        try {
            csvFile = new File(pathCsv);
            xmlFile = new File(pathXml);
            jsonFile = new File(pathJson);
            if (!csvFile.exists()) {
                csvFile.createNewFile();
            }
            if (!xmlFile.exists()) {
                xmlFile.createNewFile();
            }
            if (!jsonFile.exists()) {
                jsonFile.createNewFile();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        usuarioModels = new HashSet<>(csvToSet());
        objectMapper = new ObjectMapper();
    }


    public boolean add(String nombreUsuario, String password,String nombre,String email) {
        UsuarioModel usuario = new UsuarioModel(nombreUsuario, password, nombre, email);
        if (usuarioModels.contains(usuario)) {
            return false;
        }
        if (!usuarioModels.add(usuario)) {
            return false;
        }
        setToCsv();
        setToXml(usuarioModels);
        setToJson();
        return true;
    }
    /**
     * Funcion que pasa los datos de un archivo json a set
     * @return set con la informacion del archivo/ set vacio
     */
    public Set<UsuarioModel> jsonToSet() {
        try {
            return objectMapper.readValue(jsonFile, new TypeReference<Set<UsuarioModel>>() {
            });
        } catch (Exception e) {
            return new HashSet<>();
        }
    }

    /**
     * Funcion que agrega una lista de usuarios en un fichero json
     * @return true/false
     */
    public boolean setToJson() {
        try {
            objectMapper.writeValue(jsonFile, usuarioModels);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
    /**
     * Funcion que pasa la informacion de un archivo xml a un Set
     * @return set con la informacion
     */
    public Set<UsuarioModel> xmlToSet() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            NodeList lista = doc.getElementsByTagName("usuario");
            for (int i = 0; i < lista.getLength(); i++) {
                Node nodo = lista.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String nombreUsuario = elemento.getElementsByTagName("nombreUsuario").item(0).getTextContent();
                    String password = elemento.getElementsByTagName("password").item(0).getTextContent();
                    String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                    String email = elemento.getElementsByTagName("email").item(0)
                            .getTextContent();
                    UsuarioModel usuarioModel = new UsuarioModel(nombreUsuario,password,nombre,email);
                    usuarioModels.add(usuarioModel);
                }
            }
        } catch (Exception e) {
            return new HashSet<>();
        }
        return usuarioModels;
    }

    /**
     * Funcion que escribe la informacion del set en unfichero xml
     * @param usuarios set a aniadir
     * @return true/false
     */
    public boolean setToXml(Set<UsuarioModel> usarios) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("usuarios");
            doc.appendChild(root);

            for (UsuarioModel usuarioModel : usarios) {
                Element usuario = doc.createElement("usuario");
                root.appendChild(usuario);
                
                Element nombreUsuario = doc.createElement("nombreUsuario");
                nombreUsuario.appendChild(doc.createTextNode(usuarioModel.getNombreUsuario()));
                usuario.appendChild(nombreUsuario);

                Element passwordBuscar = doc.createElement("password");
                passwordBuscar.appendChild(doc.createTextNode(usuarioModel.getPassword()));
                usuario.appendChild(passwordBuscar);

                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode(usuarioModel.getNombre()));
                usuario.appendChild(nombre);


                Element email = doc.createElement("email");
                email.appendChild(doc.createTextNode(usuarioModel.getEmail()));
                usuario.appendChild(email);
            }
            

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Funcion que pasa la informacion del csv a un Set
     * @return Set con la informacion
     */
    public Set<UsuarioModel> csvToSet() {
        Set<UsuarioModel> lista = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] array = line.split(",");
                UsuarioModel ususario = new UsuarioModel((array[0]), array[1], array[2], array[3]);
                lista.add(ususario);
            }
        } catch (IOException e) {
            return new HashSet<>();
        }
        return lista;
    }

    /**
     * Funcion que pasa la informacion del set a un csv
     * @return true/false
     */
    public boolean setToCsv(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathCsv))) {
            for (UsuarioModel usuarioBuscar : usuarioModels) {
                writer.write(usuarioBuscar.toString());
                writer.newLine();                
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Funcion que busca un usuaruio por su nombre de usuario y contrasenia
     * @param nombreUsuario a buscar
     * @return usuario bucado/null
     */
    public UsuarioModel findUsuario(String nombreUsuario, String contrasenia){
        for (UsuarioModel usuarioModelBuscar : usuarioModels) {
            if (usuarioModelBuscar.getNombre().equals(nombreUsuario) && usuarioModelBuscar.getPassword().equals(contrasenia)) {
                return usuarioModelBuscar;
            }
        }
        return null;
    }
}
