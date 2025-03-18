package es.ies.puerto.controller;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.controller.abstractas.AbstractController;
import es.ies.puerto.model.UsuarioModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class PerfilUsuarioController extends AbstractController{
    @FXML 
    private TextField textFieldUser;

    @FXML 
    private TextField textFieldPasswordUser;

    @FXML 
    private TextField textFieldNombre2;
    
    @FXML 
    private TextField textFieldEmail3;
    
    @FXML 
    private Button buttonVolverAtras;

    UsuarioModel usuarioModel;

   
    public PerfilUsuarioController(){
        System.out.println("Second");
    }

    public void setUsuario(UsuarioModel usuario){
        this.usuarioModel = usuario;
        cargarDatos();
    }

    private void cargarDatos(){
        if (usuarioModel != null ) {
            textFieldUser.setText(usuarioModel.getNombreUsuario());
            textFieldPasswordUser.setText(usuarioModel.getPassword());
            textFieldNombre2.setText(usuarioModel.getNombre());
            textFieldEmail3.setText(usuarioModel.getEmail());
        }
    }

    @FXML
    protected void onClickVolver(){
        try {
            Stage stage = (Stage) buttonVolverAtras.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Pantalla Usuario");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
