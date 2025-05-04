package es.mahoramas.lolpedia.controller;

import es.mahoramas.lolpedia.PrincipalApplication;
import es.mahoramas.lolpedia.controller.abstractas.AbstractController;
import es.mahoramas.lolpedia.model.UsuarioEntity;
import es.mahoramas.lolpedia.sesion.Sesion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PerfilUsuarioController extends AbstractController {
    @FXML
    private TextField textFieldUser;

    @FXML
    private TextField textFieldPasswordUser;

    @FXML
    private TextField textFieldNombre2;

    @FXML
    private TextField textFieldEmail3;

    @FXML
    private Button atrasButton;

    /**
     * Metodo que inicializa la clase
     */
    @FXML
    public void initialize() {
        cambiarIdioma();
        cargarDatos();
    }

    /**
     * Metodo que carga los datos del usuario
     */
    private void cargarDatos() {
        UsuarioEntity usuarioEntity = Sesion.getInstance().getUsuarioActual();

        if (usuarioEntity != null) {
            textFieldUser.setText(usuarioEntity.getNombreUsuario());
            textFieldPasswordUser.setText(usuarioEntity.getContrasenia());
            textFieldNombre2.setText(usuarioEntity.getNombre());
            textFieldEmail3.setText(usuarioEntity.getEmail());
        } else {
            System.out.println("No hay usuario en sesión");
        }
    }

    /**
     * Metodo para volver a la pantalla anterior
     */
    @FXML
    protected void onClickVolver() {
        try {
            Stage stage = (Stage) atrasButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("principal.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1280, 800);
            stage.setTitle("Pantalla Usuario");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
