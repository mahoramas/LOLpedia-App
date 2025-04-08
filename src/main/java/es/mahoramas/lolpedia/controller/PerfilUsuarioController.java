package es.mahoramas.lolpedia.controller;

import es.mahoramas.lolpedia.PrincipalApplication;
import es.mahoramas.lolpedia.controller.abstractas.AbstractController;
import es.mahoramas.lolpedia.model.UsuarioEntity;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PerfilUsuarioController extends AbstractController{
    @FXML 
    private TextField textFieldUser;

    @FXML 
    private TextField textFieldPasswordUser;

    @FXML 
    private TextField textFieldNombre2;
    
    @FXML 
    private TextField textFieldEmail3;
    
    @FXML 
    private Button buttonVolverAtras;

    UsuarioEntity usuarioEntity;

    @FXML
    public void initialize(){
        cambiarIdioma();
    }
   
    public PerfilUsuarioController(){
        System.out.println("Second");
    }

    public void setUsuario(UsuarioEntity usuario){
        this.usuarioEntity = usuario;
        cargarDatos();
    }

    private void cargarDatos(){
        if (usuarioEntity != null ) {
            textFieldUser.setText(usuarioEntity.getNombreUsuario());
            textFieldPasswordUser.setText(usuarioEntity.getContrasenia());
            textFieldNombre2.setText(usuarioEntity.getNombre());
            textFieldEmail3.setText(usuarioEntity.getEmail());
        }
    }

    @FXML
    protected void onClickVolver(){
        try {
            Stage stage = (Stage) buttonVolverAtras.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("login.fxml"));
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
