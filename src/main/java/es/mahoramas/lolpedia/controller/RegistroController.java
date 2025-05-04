package es.mahoramas.lolpedia.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.mahoramas.lolpedia.PrincipalApplication;
import es.mahoramas.lolpedia.config.ConfigManager;
import es.mahoramas.lolpedia.controller.abstractas.AbstractController;
import es.mahoramas.lolpedia.model.UsuarioServiceModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistroController extends AbstractController {

    @FXML
    protected TextField textFiledUsuario;

    @FXML
    protected Text textMensaje;

    @FXML
    protected Button buttonRegistrar;

    @FXML
    protected PasswordField textFieldPassword;

    @FXML
    protected PasswordField textFieldPasswordRepit;

    @FXML
    protected Text textUsuario;

    @FXML
    protected Text textNombre;

    @FXML
    protected Text textContrasenia;

    @FXML
    protected Text textEmail;

    @FXML
    protected Text textEmail2;

    @FXML
    protected Button atrasButton;

    UsuarioServiceModel usuarioServiceModel;

    public RegistroController() {
    }

    /**
     * Metodo que inicializa la clase
     */
    @FXML
    public void initialize() {
        cambiarIdioma();
    }

    /**
     * Metodo que verifica los datos y registra al usuario
     */
    @FXML
    protected void onClickRegistrar() {
        usuarioServiceModel = getUsuarioServiceModel();

        if (textFieldUsuario == null || textFieldUsuario.getText().isEmpty()) {
            textMensaje.setText("¡El nombre de usuario no puede ser nulo o vacio!");
            return;
        }

        if (usuarioServiceModel.verificarUsuario(textFieldUsuario.getText())) {
            textMensaje.setText("El usuario ya esta registrado.");
            return;
        }

        if (textFieldPassword == null || textFieldPassword.getText().isEmpty() || textFieldPassword2 == null
                || textFieldPassword2.getText().isEmpty()) {
            textMensaje.setText("¡El password no puede ser nulo o vacio!");
            return;
        }

        if (textFieldNombre == null || textFieldNombre.getText().isEmpty()) {
            textMensaje.setText("¡El nombre no puede ser nulo o vacio!");
            return;
        }

        if (textFieldEmail == null || textFieldEmail.getText().isEmpty() || textFieldEmail2 == null
                || textFieldEmail2.getText().isEmpty()) {
            textMensaje.setText("¡El email no puede ser nulo o vacio!");
            return;
        }

        String patron = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(textFieldEmail.getText());
        if (!m.matches()) {
            textMensaje.setText("El correo electrónico no es válido.");
            return;
        }

        if (usuarioServiceModel.verificarEmail(textFieldEmail2.getText())) {
            textMensaje.setText("El email ya esta registrado.");
            return;
        }

        if (!textFieldPassword.getText().equals(textFieldPassword2.getText())) {
            textMensaje.setText("¡La passwords no son iguales!");
            return;
        }

        boolean registro = usuarioServiceModel.aniadirUsuario(textFieldUsuario.getText(), textFieldNombre.getText(),
                textFieldPassword.getText(), textFieldEmail.getText());
        if (registro == false) {
            textMensaje.setText("Ya hay una cuenta con ese usuario e email");
        } else {
            textMensaje.setText("¡Usuario registrado!");
        }
    }

    /**
     * Metodo para volver a la pantalla anterior
     */
    @FXML
    protected void volverAtrasClick() {
        try {
            Stage stage = (Stage) atrasButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1280, 800);
            stage.setTitle("Pantalla inicio");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
