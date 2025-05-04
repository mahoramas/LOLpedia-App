package es.mahoramas.lolpedia.controller;

import es.mahoramas.lolpedia.PrincipalApplication;
import es.mahoramas.lolpedia.config.ConfigManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CarrilesController {

    private String carril;

    @FXML
    private Text textoCarril;

    @FXML
    protected Button atrasButton;

    @FXML
    private VBox personajesBox;

    public void setCarril(String carril) {
        this.carril = carril;
        cargarTextoCarril();
        cargarPersonajesDelCarril();
    }

    /**
     * Metodo que carga el texto del properties
     */
    private void cargarTextoCarril() {
        String keyResumen = carril + "Resumen";
        String resumen = ConfigManager.getProperty(keyResumen);
        if (resumen != null && !resumen.isEmpty()) {
            textoCarril.setText(resumen);
        } else {
            textoCarril.setText("No se pudo cargar la información del carril.");
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

    /**
     * Metodo que carga los personajes del carril para que sean interactivos
     */
    private void cargarPersonajesDelCarril() {
        String keyPersonajes = carril + ".personajes";
        String personajesStr = ConfigManager.getProperty(keyPersonajes);

        if (personajesStr == null || personajesStr.isEmpty()) {
            return;
        }

        personajesBox.getChildren().clear();

        String[] personajes = personajesStr.split(",");

        for (String personaje : personajes) {
            String nombreFormateado = personaje.substring(0, 1).toUpperCase() + personaje.substring(1);
            Text textoClickable = new Text(nombreFormateado);
            textoClickable.getStyleClass().add("personaje-link");
            textoClickable.setOnMouseClicked(e -> abrirVistaPersonaje(personaje));
            personajesBox.getChildren().add(textoClickable);
        }
    }

    /**
     * Metodo que lleva a la pantalla personajes con el personaje cargado
     * 
     * @param personaje personaje que tiene que cargar
     */
    private void abrirVistaPersonaje(String personaje) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("personajes.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1280, 800);

            PersonajesController controller = fxmlLoader.getController();
            controller.setPersonaje(personaje);

            Stage stage = (Stage) atrasButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
