package es.ies.puerto.model;

import java.sql.SQLException;

import es.ies.puerto.model.abstractas.Conexion;

public class UsuarioServiceModel extends Conexion{
    
    /**
     * Constructor vacio
     */
    public UsuarioServiceModel(){}

    /**
     * Constructor con el path de la base de datos
     * @param unPathBD path de la bbdd
     * @throws SQLException error controlado
     */
    public UsuarioServiceModel(String unPathBD) throws SQLException{
        super(unPathBD);
    }

    
}
