package es.ies.puerto.model;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * @author nexphernandez
 */
public class UsuarioModel {

    @JsonProperty("nombreUsuario")
    private String nombreUsuario;
    @JsonProperty("password")
    private String password;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("email")
    private String email;

    /**
     * Constructor vacio
     */
    public UsuarioModel(){}

    /**
     * Constructor con el atributo principal de la clase
     * @param email de usuario
     */
    public UsuarioModel(String email){
        this.email = email;
    }

    /**
     * Constructor de los atributos de la clase
     * @param nombreUsuario nombre de usuario
     * @param password contrasenia del usuario
     * @param nombre nombre del usuario
     * @param email email del usuario
     */
    public UsuarioModel(String nombreUsuario, String password,String nombre,String email ){
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Funcion equals de la clase
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UsuarioModel)) {
            return false;
        }
        UsuarioModel ususarioModel = (UsuarioModel) o;
        return Objects.equals(email, ususarioModel.email) && Objects.equals(nombreUsuario, ususarioModel.nombreUsuario);
    }

    /**
     * Funcion hascode de la clase
     */
    @Override
    public int hashCode() {
        return Objects.hash(email, nombreUsuario);
    }

    /**
     * Funcion toString de la clase
     */
    @Override
    public String toString() {
        return getNombreUsuario() + "," +
            getPassword() + "," +
            getNombre() + "," +
            getEmail();
    }

}
