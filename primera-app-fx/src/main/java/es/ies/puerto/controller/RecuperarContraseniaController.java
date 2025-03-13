package es.ies.puerto.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RecuperarContraseniaController {
    
    @FXML TextField textFieldEmailRecover;
    
    @FXML Text textFieldMensajeRecover;
    
    @FXML Button buttonRegistrarEmail;

    @FXML
    protected void onRecoverButtonClick(){
        if (textFieldEmailRecover == null || textFieldEmailRecover.getText().isEmpty()) {
            textFieldMensajeRecover.setText("¡El Email no puede ser nulo o vacio!");
            return;
        }
        textFieldMensajeRecover.setText("¡Mensaje enviado!, revisa el email");
    }
}
