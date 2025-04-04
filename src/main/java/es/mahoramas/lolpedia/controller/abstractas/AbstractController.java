package es.mahoramas.lolpedia.controller.abstractas;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import es.mahoramas.lolpedia.config.ConfigManager;
import es.mahoramas.lolpedia.model.UsuarioServiceModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public abstract class AbstractController {

    private UsuarioServiceModel usuarioServiceModel;

    private Properties propertiesIdioma;

    @FXML
    protected Text textUsuario;

    @FXML
    protected TextField textFieldUsuario;

    @FXML
    protected Text textContrasenia;

    @FXML
    protected PasswordField textFieldPassword;

    @FXML
    protected Text textContrasenia2;

    @FXML
    protected PasswordField textFieldPassword2;

    @FXML
    protected Text textNombre;

    @FXML
    protected TextField textFieldNombre;

    @FXML
    protected Text textEmail;

    @FXML
    protected TextField textFieldEmail;

    @FXML
    protected Text textEmail2;

    @FXML
    protected TextField textFieldEmail2;

    @FXML
    protected Text textMensaje;

    

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
    

    public void setpropertiesIdioma(Properties properties) {
        propertiesIdioma = properties;
    }

    public Properties getPropertiesIdioma() {
        return propertiesIdioma;
    }


    public Properties loadIdioma(String nombreFichero, String idioma) {
        Properties properties = new Properties();
        
        if (nombreFichero == null || idioma == null) {
            return properties;
        }
        
        String path = "src/main/resources/" + nombreFichero+"-"+idioma+".properties";

        File file = new File(path);

        if (!file.exists() || !file.isFile()) {
            System.out.println("Path:"+file.getAbsolutePath());
            return properties;
        }
        
        try {
            FileInputStream input = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(input, "UTF-8");
            properties.load(isr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return properties;
    }


    public UsuarioServiceModel getUsuarioServiceModel() {
        return this.usuarioServiceModel;
    }


}
