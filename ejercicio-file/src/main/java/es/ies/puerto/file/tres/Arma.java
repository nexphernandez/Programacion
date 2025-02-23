package es.ies.puerto.file.tres;
import java.util.Objects;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Arma {
    private String id;
    private String nombre;
    private String descripcion;
    private String origen;
    private int fuerza;

    /**
     * Constructor vacio por defecto
     */
    public Arma(){}
    
    /**
     * Constructor del atributo clave de la clase
     * @param id ide de la criatura
     */
    public Arma(String id){
        this.id = id;
    }

    /**
     * Contructor de los atributos de la clase
     * @param id id de la criatura
     * @param nombre nombre de la criatura
     * @param descripcion descripcion de la criatura
     * @param origen origen de la criatura
     * @param fuerza fuerza de la criatura
     */
    public Arma(String id, String nombre,String descripcion, String origen, int fuerza){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.origen = origen;
        this.fuerza = fuerza;
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

    public void setDescripcion(String descripion) {
        this.descripcion = descripion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    /**
     * Funcion equals de la clase
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Arma)) {
            return false;
        }
        Arma arma = (Arma) o;
        return Objects.equals(id, arma.id);
    }

    /**
     * Funcion hashCode de la clase
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Funcion toString de la clase
     */
    @Override
    public String toString() {
        return getId() + "," + getNombre() + "," + getDescripcion() + "," + getOrigen() + "," + getFuerza();
    }

}
