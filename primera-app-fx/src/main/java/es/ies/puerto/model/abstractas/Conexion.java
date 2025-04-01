package es.ies.puerto.model.abstractas;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public abstract class Conexion {
    private String pathBD;
    private Connection connection;

    /**
     * Constructor vacio
     */
    public Conexion(){}

    /**
     * Constructor con el path de conexion
     * @param unPathBD ruta de la bbdd
     */
    public Conexion (String unPathBD){
        try {
            if (unPathBD == null || unPathBD.isEmpty()) {
                throw new SQLException("El fichero es nulo o vacio ");
            }
            File file = new File(unPathBD);
            if (!file.exists()) {
                throw new SQLException("No existe la base de datos: " + unPathBD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        pathBD = unPathBD;
    }

    /**
     * get del pathBD
     * @return pathBD
     */
    public String getPathBD(){
        return this.pathBD;
    }

    /**
     * Funcion que abre la conexion a la bbdd
     * @return conexion con la bbdd
     */
    public Connection getconnection(){
        try {
            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:sqlite:" + pathBD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.connection;
    }

    /**
     * Funcion que cierra la conexion de bbdd
     * @throws SQLException
     */
    public void cerrar() {
       try {
            if (connection != null || !connection.isClosed()) {
                connection.close();
                connection = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
