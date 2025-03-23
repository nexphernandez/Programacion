package es.ies.puerto.controller;


import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.abstractas.AbstractController;
import es.ies.puerto.model.OperacionesFile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * @author nexphernandez
 * @version 1.0.0
 */

public class RecuperarContraseniaController  extends AbstractController{
    
    @FXML 
    private TextField textFieldEmailRecover;
    
    @FXML 
    private Text textFieldMensajeRecover;
    
    @FXML 
    private Button buttonRegistrarEmail;
    
    @FXML 
    private Button atrasButton2;

    OperacionesFile operacionesFile;

    public RecuperarContraseniaController(){
        operacionesFile = new OperacionesFile();
    }

    @FXML
    protected void onRecoverButtonClick(){
        if (textFieldEmailRecover == null || textFieldEmailRecover.getText().isEmpty()) {
            textFieldMensajeRecover.setText("¡El Email no puede ser nulo o vacio!");
            return;
        }

        if (!operacionesFile.verificarEmail(textFieldEmailRecover.getText())) {
            textFieldMensajeRecover.setText("El correo electrónico no es válido o no esta registrado.");
            return;
        }
        textFieldMensajeRecover.setText("¡Mensaje enviado!, revisa el email");
    }

    @FXML
    protected void atrasClick(){
        try {
            Stage stage = (Stage) atrasButton2.getScene().getWindow();
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
