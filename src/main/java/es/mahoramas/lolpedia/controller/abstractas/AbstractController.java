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
            textUsuario.setText(ConfigManager.getProperty("textUsuario"));
            textContrasenia.setText(ConfigManager.getProperty("textContrasenia"));
        }
        if (!(textContrasenia2 == null)) {
            textContrasenia2.setText(ConfigManager.getProperty("textContrasenia2"));
        }
        if (!(textNombre == null)) {
            textNombre.setText(ConfigManager.getProperty("textNombre"));    
        }
        if (!(textEmail == null)) {
            textEmail.setText(ConfigManager.getProperty("textEmail"));
        }
        if (!(textEmail2 == null)) {
            textEmail2.setText(ConfigManager.getProperty("textEmail2"));
        }
        if (!(textFieldUsuario == null)) {
            textFieldUsuario.setPromptText(ConfigManager.getProperty("textFieldUsuario"));
        }
        if (!(textFieldPassword == null)) {
            textFieldPassword.setPromptText(ConfigManager.getProperty("textFieldPassword"));
        }
        if (!(textFieldPassword2 == null)) {
            textFieldPassword2.setPromptText(ConfigManager.getProperty("textFieldPassword2"));
        }
        if (!(textFieldEmail == null)) {
            textFieldEmail.setPromptText(ConfigManager.getProperty("textFieldEmail"));
        }
        if (!(textFieldEmail2 == null)) {
            textFieldEmail2.setPromptText(ConfigManager.getProperty("textFieldEmail2"));
        }
        if (!(atrasButton == null)) {
            atrasButton.setText(ConfigManager.getProperty("atrasButton"));
        }
        if (!(buttonRegistrar == null)) {
            buttonRegistrar.setText(ConfigManager.getProperty("buttonRegistrar"));
        }
        if (!(buttonIniciarSesion == null)) {
            buttonIniciarSesion.setText(ConfigManager.getProperty("buttonIniciarSesion"));
        }
        if (!(link == null)) {
            link.setText(ConfigManager.getProperty("link"));
        }
        if (!(buttonRegistrarEmail == null)) {
            buttonRegistrarEmail.setText(ConfigManager.getProperty("buttonRegistrarEmail"));
        }
        if (!(resumenText == null)) {
            resumenText.setText(ConfigManager.getProperty("resumenText"));
        }
        if (!(top == null)) {
            top.setText(ConfigManager.getProperty("top"));
        }
        if (!(jungla == null)) {
            jungla.setText(ConfigManager.getProperty("jungla"));
        }
        if (!(mid == null)) {
            mid.setText(ConfigManager.getProperty("mid"));
        }
        if (!(adc == null)) {
            adc.setText(ConfigManager.getProperty("adc"));
        }
        if (!(supp == null)) {
            supp.setText(ConfigManager.getProperty("supp"));
        }
    }
    
    public UsuarioServiceModel getUsuarioServiceModel() {
        return usuarioServiceModel;
    }


}
