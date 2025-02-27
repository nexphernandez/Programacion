package es.file.json.uno;
import com.fasterxml.jackson.annotation.*;
import java.util.Objects;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Caballero {
    private int id;
    private String nombre;
    private String constelacion;
    private int nivel;
    private String fechaIngreso;

    /**
     * Constructor con los atributos de la clae
     * @param id del caballero
     * @param nombre del caballero
     * @param constelacion del caballero
     * @param nivel del caballero
     * @param fechaIngreso del caballero
     */
    @JsonCreator
    public Caballero(@JsonProperty("id") int id,
                     @JsonProperty("nombre") String nombre,
                     @JsonProperty("constelacion") String constelacion,
                     @JsonProperty("nivel") int nivel,
                     @JsonProperty("fechaIngreso") String fechaIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.constelacion = constelacion;
        this.nivel = nivel;
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Constructor con el atributo principal de la clase
     * @param id del caballero
     */
    public Caballero(@JsonProperty("id") int id) {
        this.id = id;
    }
    

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getConstelacion() {
        return this.constelacion;
    }

    public int getNivel() {
        return this.nivel;
    }

    public String getFechaIngreso() {
        return this.fechaIngreso;
    }

    /**
     * Funcion equals de la clase
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Caballero)) {
            return false;
        }
        Caballero caballero = (Caballero) o;
        return Objects.equals(id, caballero.id);
    }

    /**
     * Funcion hashCode de la clase
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
   
}
