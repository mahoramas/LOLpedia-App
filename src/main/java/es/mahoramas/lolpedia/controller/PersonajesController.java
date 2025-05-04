package es.mahoramas.lolpedia.controller;

import java.util.Locale;
import java.util.ResourceBundle;

import es.mahoramas.lolpedia.PrincipalApplication;
import es.mahoramas.lolpedia.config.ConfigManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PersonajesController {

    @FXML
    private Text nombrePersonaje;

    @FXML
    private Text descripcionPersonaje;

    @FXML
    private Button atrasButton;

    /**
     * Metodo que recoge el personaje y pone el texto asociado a el
     * 
     * @param personaje personaje
     */
    public void setPersonaje(String personaje) {
        String nombre = ConfigManager.getProperty(personaje + ".nombre");
        String descripcion = ConfigManager.getProperty(personaje + ".descripcion");

        nombrePersonaje.setText(nombre != null ? nombre : "Nombre no disponible");
        descripcionPersonaje.setText(descripcion != null ? descripcion : "Descripción no disponible");
    }

    /**
     * Metodo para volver a la pantalla anterior
     */
    @FXML
    protected void volverAtrasClick() {
        try {
            Stage stage = (Stage) atrasButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("principal.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1280, 800);
            stage.setTitle("Pantalla inicio");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que lleva a la pantalla perfil
     */
    @FXML
    protected void perfilButtonClick() {
        try {
            Stage stage = (Stage) atrasButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("perfil.fxml"));
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
