package es.ies.puerto.file.dos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Pokemon {

    private String id;
    private String nombre;
    private List<String> tipos;
    private String descripcion;

    /**
     * Constructor vacio
     */
    public Pokemon(){
        this.tipos = new ArrayList<>();
    }

    /**
     * Cosntructor del atributo clave de la clase
     * @param id id del pokemon
     */
    public Pokemon(String id){
        this.id = id;
    }

    /**
     * Constructor de los atributos de la clase
     * @param id id del pokemon
     * @param nombre nombre del pokemon
     * @param tipos tipos de pokemon
     * @param descripcion descripcion del pokemon
     */
    public Pokemon(String id, String nombre, List<String> tipos, String descripcion){
        this.id = id;
        this.nombre = nombre;
        this.tipos = new ArrayList<>();
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipos() {
        return tipos.toString();
    }

    public void setTipos(List<String> tipos) {
        this.tipos = tipos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Funcion toString de la clase pokemon
     */
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", tipos='" + getTipos() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            "}";
    }

    /**
     * Funcion equals de la clase pokemon
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pokemon)) {
            return false;
        }
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(id, pokemon.id);
    }

    /**
     * Funcion hashCode de la clase pokemon
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
