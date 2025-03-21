package es.ies.puerto.controller;

import java.io.ObjectInputFilter.Config;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.config.ConfigManager;
import es.ies.puerto.controller.abstractas.AbstractController;
import es.ies.puerto.model.OperacionesFile;
import es.ies.puerto.model.UsuarioModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class LoginController extends AbstractController{
    
    @FXML
    private Text textUsuario;

    @FXML
    private Text textContrasenia;

    @FXML
    private ComboBox comboIdioma;

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
        List <String> listaIdiomas = new ArrayList<>();
        listaIdiomas.add("es");
        listaIdiomas.add("en");
        listaIdiomas.add("fr");
        comboIdioma.getItems().addAll(listaIdiomas);
        
    }

    @FXML
    protected void cambiarIdioma(){
        //setPropertiesIdiomas(loadIdioma("idioma", comboIdioma.getValue().toString()));
        //textUsuario.setText(getPropertiesIdiomas().getProperty("textUsuario"));
        String textUsuarioStr = ConfigManager.ConfigProperties.getProperty("textUsuario");
        textUsuario.setText(textUsuarioStr);
        textContrasenia.setText(getPropertiesIdiomas().getProperty("textContrasenia"));
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
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("perfil.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            
            PerfilUsuarioController perfilController = fxmlLoader.getController();
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
        try {
            
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("registro.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);

            RegistroController registroController = fxmlLoader.getController();
            //registroController.setPropertiesIdiomas(this.getPropertiesIdiomas());
            //registroController.postConstructor();

            Stage stage = (Stage) buttonResgistrar.getScene().getWindow();
            stage.setTitle("Pantalla Registro");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onRecoverButtonClick() {
        try {
            Stage stage = (Stage) buttonResgistrar.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("recuperarConstrasenia.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Pantalla Recuperar Contraseña");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}