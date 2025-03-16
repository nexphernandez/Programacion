package es.ies.puerto.controller;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.model.OperacionesFile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistroController {
    
    @FXML TextField textFieldUsuario;
    @FXML Text textMensaje;
    @FXML Button buttonRegistrar;
    @FXML Button atrasButton;
    @FXML PasswordField textFieldPassword;
    @FXML PasswordField textFieldPassword2;
    @FXML TextField textFieldNombre;
    @FXML TextField textFieldEmail;
    @FXML TextField textFieldEmail2;

    OperacionesFile operacionesFile;

    public RegistroController(){
        System.out.println("first");
    }

    @FXML
    public void initialize(){
        operacionesFile = new OperacionesFile();
    }

    @FXML
    protected void onClickRegistrar() {
        if (textFieldUsuario == null || textFieldUsuario.getText().isEmpty()) {
            textMensaje.setText("¡El nombre de usuario no puede ser nulo o vacio!");
            return;
        }

        if (textFieldPassword == null || textFieldPassword.getText().isEmpty()|| textFieldPassword2 == null || textFieldPassword2.getText().isEmpty()) {
            textMensaje.setText("¡El password no puede ser nulo o vacio!");
            return;
        }

        if (textFieldNombre == null || textFieldNombre.getText().isEmpty()) {
            textMensaje.setText("¡El nombre no puede ser nulo o vacio!");
            return;
        }

        if (textFieldEmail == null || textFieldEmail.getText().isEmpty()|| textFieldEmail2 == null || textFieldEmail2.getText().isEmpty()) {
            textMensaje.setText("¡El email no puede ser nulo o vacio!");
            return;
        }

        if (!textFieldPassword.getText().equals(textFieldPassword2.getText())) {
            textMensaje.setText("¡La passwords no son iguales!");
            return;
        }

        boolean registro = operacionesFile.add(textFieldUsuario.getText(), textFieldPassword.getText(), textFieldNombre.getText(), textFieldEmail.getText());
        if (registro == false) {
            textMensaje.setText("Ya hay una cuenta con ese usuario e email");
        } else{
            textMensaje.setText("¡Usuario registrado!");
        }
    }
    @FXML
    protected void volverAtrasClick(){
        try {
            Stage stage = (Stage) atrasButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Pantalla inicio");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
