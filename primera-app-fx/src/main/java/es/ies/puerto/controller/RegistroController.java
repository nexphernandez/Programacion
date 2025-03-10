package es.ies.puerto.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RegistroController {
    
    @FXML TextField textFieldUsuario;
    @FXML Text textMensaje;
    @FXML Button buttonRegistrar;
    @FXML PasswordField textFieldPassword;
    @FXML PasswordField textFieldPassword2;

    @FXML
    protected void onClickRegistrar() {

        if (textFieldPassword == null || textFieldPassword.getText().isEmpty()|| textFieldPassword2 == null || textFieldPassword2.getText().isEmpty()) {
            textMensaje.setText("¡El password no puede ser nulo o vacio!");
            return;
        }

        if (!textFieldPassword.getText().equals(textFieldPassword2.getText())) {
            textMensaje.setText("¡La password es incorrecta!");
            return;
        }

        textMensaje.setText("¡Usuario registrado!");
    }
}
