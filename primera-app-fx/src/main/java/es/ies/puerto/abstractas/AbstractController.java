package es.ies.puerto.abstractas;

import es.ies.puerto.config.ConfigManager;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

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

    public void cambiarIdioma() {
        if (!(textUsuario == null)) {
            textUsuario.setText(ConfigManager.ConfigProperties.getProperty("textUsuario"));
            textContrasenia.setText(ConfigManager.ConfigProperties.getProperty("textContrasenia"));
        }
        if (!(textContrasenia2 == null)) {
            textContrasenia2.setText(ConfigManager.ConfigProperties.getProperty("textContrasenia2"));
        }
        if (!(textNombre == null)) {
            textNombre.setText(ConfigManager.ConfigProperties.getProperty("textNombre"));    
        }
        if (!(textEmail == null)) {
            textEmail.setText(ConfigManager.ConfigProperties.getProperty("textEmail"));
        }
        if (!(textEmail2 == null)) {
            textEmail2.setText(ConfigManager.ConfigProperties.getProperty("textEmail2"));
        }
    }
}