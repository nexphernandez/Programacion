package es.ies.puerto.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public UsuarioServiceModel(String unPathBD) {
        super(unPathBD);
    }

    public ArrayList<UsuarioEntity> obtenerUsuario(String sql){
        ArrayList<UsuarioEntity> usuarios = new ArrayList<UsuarioEntity>();
        try {
            PreparedStatement sentencia = getconnection().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
    
            while (resultado.next()){
                String nombreUsuarioStr = resultado.getString("nombreUsuario");
                String contraseniaStr = resultado.getString("contrasenia");
                String nombreStr = resultado.getString("nombre");
                String emailStr = resultado.getString("email");
                UsuarioEntity usuario = new UsuarioEntity(nombreStr,contraseniaStr,nombreStr,emailStr);
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            cerrar();
        }
        return usuarios;
    }


    public UsuarioEntity obtenerUsuarioPorEmail(String email){
        String sql = "Select email from Usuario " + "where email='" + email + "'";
        
        
        
        
        return null;
    }
}
