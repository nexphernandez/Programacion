package es.ies.puerto.controller;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.model.OperacionesFile;
import es.ies.puerto.model.UsuarioModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {
    

    @FXML
    private TextField textFieldUsuario;
    
    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private Button ButtonAceptar;

    @FXML
    private Button RecoverPassWordButton;

    @FXML
    private Text textFieldMensaje;

    @FXML
    private Button buttonResgistrar;

    private OperacionesFile operacionesFile;

    private UsuarioModel user;

    public void setUsuario(UsuarioModel usuario){
        this.user = usuario;
    }

    public UsuarioModel getUsuario(){
        return user;
    }

    @FXML
    void initialize(){
        operacionesFile = new OperacionesFile();
    }

    @FXML
    protected void onLoginButtonClick() {

        if (textFieldUsuario== null || textFieldUsuario.getText().isEmpty() || 
            textFieldPassword == null || textFieldPassword.getText().isEmpty() ) {
                textFieldMensaje.setText("Credenciales null o vacias");
                return;
        }
        
        user = operacionesFile.findUsuario(textFieldUsuario.getText(), textFieldPassword.getText());

        if (user == null) {
            textFieldMensaje.setText("Credenciales invalidas");
            return;
        } 

        
        try {
            FXMLLoader loader = new FXMLLoader(PrincipalApplication.class.getResource("perfil.fxml"));
            Scene scene = new Scene(loader.load(), 820, 640);
    
            // Obtener el controlador de la nueva escena
            PerfilUsuarioController perfilController = loader.getController();
            perfilController.setUsuario(user);
    
            Stage stage = (Stage) ButtonAceptar.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void openRegistrarClick() {
        cambiarDeEscena("registro.fxml", "Pantalla Registro");
    }

    @FXML
    protected void onRecoverButtonClick() {
        cambiarDeEscena("recuperarConstrasenia.fxml", "Pantalla Recuperar Contraseña");
    }

    private void cambiarDeEscena(String fxml, String titulo) {
        try {
            Stage stage = (Stage) buttonResgistrar.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle(titulo);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}