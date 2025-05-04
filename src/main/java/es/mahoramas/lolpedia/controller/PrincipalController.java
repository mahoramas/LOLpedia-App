package es.mahoramas.lolpedia.controller;

import java.io.IOException;

import es.mahoramas.lolpedia.PrincipalApplication;
import es.mahoramas.lolpedia.controller.abstractas.AbstractController;
import es.mahoramas.lolpedia.model.UsuarioServiceModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PrincipalController extends AbstractController {

    @FXML
    protected Button atrasButton;

    @FXML
    protected ImageView buttonPerfil;

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

    @FXML
    protected Label titulo;

    @FXML
    public void initialize() {
        cambiarIdioma();
    }

    public PrincipalController() {
    }

    @FXML
    private void onClickTop() {
        abrirPantallaCarril("top", top);
    }

    @FXML
    private void onClickJungla() {
        abrirPantallaCarril("jungla", jungla);
    }

    @FXML
    private void onClickMid() {
        abrirPantallaCarril("mid", mid);
    }

    @FXML
    private void onClickAdc() {
        abrirPantallaCarril("adc", adc);
    }

    @FXML
    private void onClickSupp() {
        abrirPantallaCarril("supp", supp);
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
     * Metodo que dependiendo de que carril clickes te lleva a la pantalla carriles
     * @param carril carril seleccionado
     * @param sourceNode Nodo seleccionado
     */
    private void abrirPantallaCarril(String carril, javafx.scene.Node sourceNode) {
        try {
            FXMLLoader loader = new FXMLLoader(PrincipalApplication.class.getResource("Carriles.fxml"));
            Scene scene = new Scene(loader.load(), 1280, 800);

            CarrilesController controller = loader.getController();
            controller.setCarril(carril);

            Stage stage = (Stage) sourceNode.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
