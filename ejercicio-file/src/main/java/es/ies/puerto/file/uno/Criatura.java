package es.ies.puerto.file.uno;

import java.util.Objects;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Criatura {
    private String id;
    private String nombre;
    private String descripcion;
    private String categoria;

    /**
     * Constructor vacío por defecto
     */
    public Criatura(){}

    /**
     * Constructor del atributo clave de la clase
     * @param id id de la criatura
     */
    public Criatura(String id){
        this.id = id;
    }

    /**
     * Constructor con los atributos de la clase
     * @param id id de la criatura
     * @param nombre nombre de la criatura
     * @param descripcion descripcion de la criatura
     * @param categoria categoria de la criatura
     */
    public Criatura(String id, String nombre, String descripcion, String categoria){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Funcion to string de la clase
     */
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", categoria='" + getCategoria() + "'" +
            "}";
    }

    /**
     * Funcion equals de la clase
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Criatura)) {
            return false;
        }
        Criatura criatura = (Criatura) o;
        return Objects.equals(id, criatura.id);
    }

    /**
     * Funcion hashCode de la clase
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
