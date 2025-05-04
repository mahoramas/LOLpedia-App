package es.mahoramas.lolpedia.controller;

import es.mahoramas.lolpedia.PrincipalApplication;
import es.mahoramas.lolpedia.config.ConfigManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CarrilesController {

    private String carril;

    @FXML
    private Text textoCarril;
    
    @FXML
    protected Button atrasButton;

    public void setCarril(String carril) {
        this.carril = carril;
        cargarTextoCarril();
    }

    private void cargarTextoCarril() {
        String keyResumen = carril + "Resumen";
        String resumen = ConfigManager.getProperty(keyResumen);
        if (resumen != null && !resumen.isEmpty()) {
            textoCarril.setText(resumen);
        } else {
            textoCarril.setText("No se pudo cargar la información del carril.");
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
