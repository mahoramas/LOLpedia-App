package es.mahoramas.lolpedia.controller;

import es.mahoramas.lolpedia.PrincipalApplication;
import es.mahoramas.lolpedia.controller.abstractas.AbstractController;
import es.mahoramas.lolpedia.model.UsuarioServiceModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class RecuperarContraseniaController  extends AbstractController{
    
    @FXML 
    private TextField textFieldEmailRecover;
    
    @FXML 
    private Text textFieldMensajeRecover;

    @FXML 
    private Text textEmail;
    
    @FXML 
    private Button buttonRegistrarEmail;
    
    @FXML 
    private Button atrasButton2;

    UsuarioServiceModel usuarioServiceModel;

    @FXML
    public void initialize(){
        cambiarIdioma();
    }

    public RecuperarContraseniaController(){
        usuarioServiceModel = new UsuarioServiceModel();
    }

    @FXML
    protected void onRecoverButtonClick(){
        if (textFieldEmailRecover == null || textFieldEmailRecover.getText().isEmpty()) {
            textFieldMensajeRecover.setText("¡El Email no puede ser nulo o vacio!");
            return;
        }

        if (!usuarioServiceModel.verificarEmail(textFieldEmailRecover.getText())) {
            textFieldMensajeRecover.setText("El correo electrónico no es válido o no esta registrado.");
            return;
        }
        textFieldMensajeRecover.setText("¡Mensaje enviado!, revisa el email");
    }

    @FXML
    protected void atrasClick(){
        try {
            Stage stage = (Stage) atrasButton2.getScene().getWindow();
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
