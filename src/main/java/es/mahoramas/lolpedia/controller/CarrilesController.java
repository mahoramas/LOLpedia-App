package es.mahoramas.lolpedia.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import es.mahoramas.lolpedia.PrincipalApplication;
import es.mahoramas.lolpedia.config.ConfigManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CarrilesController {
    private String carril;

    @FXML
    private TextArea textoCarril;
    @FXML
    protected Button atrasButton;

    public void setCarril(String carril) {
        this.carril = carril;
        cargarTextoCarril();
    }

    private void cargarTextoCarril() {
        String idioma = ConfigManager.getIdioma();
        String archivo = "/textos/carriles/" + carril + "-" + idioma + ".txt";

        try (InputStream is = getClass().getResourceAsStream(archivo);
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }

            textoCarril.setText(contenido.toString());
        } catch (IOException | NullPointerException e) {
            textoCarril.setText("No se pudo cargar la información del carril.");
            e.printStackTrace();
        }
    }

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
