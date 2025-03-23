package es.ies.puerto.abstractas;

import es.ies.puerto.config.ConfigManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class AbstractController {

    @FXML
    public Text textUsuario;

    @FXML
    public Text textContrasenia;

    @FXML
    public Text textContrasenia2;
    @FXML
    public Text textNombre;
    @FXML
    public Text textEmail;
    @FXML
    public Text textEmail2;

    /**
     * Funcion para cambiar de idioma
     */
    public void cambiarIdioma() {
        Platform.runLater(()->{

            textUsuario.setText(ConfigManager.ConfigProperties.getProperty("textUsuario"));
            textContrasenia.setText(ConfigManager.ConfigProperties.getProperty("textContrasenia"));
        
        
            textContrasenia2.setText(ConfigManager.ConfigProperties.getProperty("textContrasenia2"));
        
            textNombre.setText(ConfigManager.ConfigProperties.getProperty("textNombre"));    
        
            textEmail.setText(ConfigManager.ConfigProperties.getProperty("textEmail"));
       
            textEmail2.setText(ConfigManager.ConfigProperties.getProperty("textEmail2"));
        });
        
    }
}