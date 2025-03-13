package es.ies.puerto.controller;

import es.ies.puerto.PrincipalApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {
    
    private final String usuario = "pokemon";
    private final String password = "pokemon";

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

    

    @FXML
    protected void onLoginButtonClick() {

        if (textFieldUsuario== null || textFieldUsuario.getText().isEmpty() || 
            textFieldPassword == null || textFieldPassword.getText().isEmpty() ) {
                textFieldMensaje.setText("Credenciales null o vacias");
                return;
        }

        if (!textFieldUsuario.getText().equals(usuario) || !textFieldPassword.getText().equals(password)) {
            textFieldMensaje.setText("Credenciales invalidas");
            return;
        } 

        textFieldMensaje.setText("Usuario validado correctamente");
    }

    @FXML
    protected void openRegistrarClick(){
        try {
            Stage stage = (Stage) buttonResgistrar.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("registro.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Pantalla Registro");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onRecoverButtonClick(){
        try {
            Stage stage = (Stage) RecoverPassWordButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("recuperarConstrasenia.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Pantalla Recover");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}