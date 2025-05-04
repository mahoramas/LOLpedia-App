package es.mahoramas.lolpedia.controller.abstractas;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.Properties;

import es.mahoramas.lolpedia.config.ConfigManager;
import es.mahoramas.lolpedia.model.UsuarioServiceModel;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public abstract class AbstractController {

    protected UsuarioServiceModel usuarioServiceModel = new UsuarioServiceModel();

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
    protected Button atrasButton;

    @FXML
    public Button buttonRegistrar;

    @FXML
    protected Button buttonIniciarSesion;

    @FXML
    protected Hyperlink link;

    @FXML
    protected Text textMensaje;

    @FXML 
    private Button buttonRegistrarEmail;

    @FXML
    protected Text resumenText;

    @FXML
    protected Text top;

    @FXML
    protected Text jungla;

    @FXML
    protected Text mid;

    @FXML
    protected Text adc;

    @FXML
    protected Text supp;

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
        if (!(textFieldUsuario == null)) {
            textFieldUsuario.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldUsuario"));
        }
        if (!(textFieldPassword == null)) {
            textFieldPassword.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldPassword"));
        }
        if (!(textFieldPassword2 == null)) {
            textFieldPassword2.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldPassword2"));
        }
        if (!(textFieldEmail == null)) {
            textFieldEmail.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldEmail"));
        }
        if (!(textFieldEmail2 == null)) {
            textFieldEmail2.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldEmail2"));
        }
        if (!(atrasButton == null)) {
            atrasButton.setText(ConfigManager.ConfigProperties.getProperty("atrasButton"));
        }
        if (!(buttonRegistrar == null)) {
            buttonRegistrar.setText(ConfigManager.ConfigProperties.getProperty("buttonRegistrar"));
        }
        if (!(buttonIniciarSesion == null)) {
            buttonIniciarSesion.setText(ConfigManager.ConfigProperties.getProperty("buttonIniciarSesion"));
        }
        if (!(link == null)) {
            link.setText(ConfigManager.ConfigProperties.getProperty("link"));
        }
        if (!(buttonRegistrarEmail == null)) {
            buttonRegistrarEmail.setText(ConfigManager.ConfigProperties.getProperty("buttonRegistrarEmail"));
        }
        if (!(resumenText == null)) {
            resumenText.setText(ConfigManager.ConfigProperties.getProperty("resumenText"));
        }
        if (!(top == null)) {
            top.setText(ConfigManager.ConfigProperties.getProperty("top"));
        }
        if (!(jungla == null)) {
            jungla.setText(ConfigManager.ConfigProperties.getProperty("jungla"));
        }
        if (!(mid == null)) {
            mid.setText(ConfigManager.ConfigProperties.getProperty("mid"));
        }
        if (!(adc == null)) {
            adc.setText(ConfigManager.ConfigProperties.getProperty("adc"));
        }
        if (!(supp == null)) {
            supp.setText(ConfigManager.ConfigProperties.getProperty("supp"));
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
        return usuarioServiceModel;
    }


}
