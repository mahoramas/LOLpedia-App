package es.mahoramas.lolpedia.controller;

import es.mahoramas.lolpedia.model.UsuarioEntity;
import es.mahoramas.lolpedia.model.UsuarioServiceModel;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LoginControllerTest {

    @Mock
    private UsuarioServiceModel usuarioServiceModel;
    
    @Mock
    private UsuarioEntity usuarioEntity;

    @Mock
    private TextField textFieldUsuario;
    
    @Mock
    private PasswordField textFieldPassword;
    
    @Mock
    private Text textFieldMensaje;
    
    @Mock
    private Button buttonIniciarSesion;
    
    @Mock
    private ComboBox comboIdioma;

    @InjectMocks
    private LoginController loginController;

    @BeforeEach
    void setUp() {
        // Inicializamos el controlador antes de cada test.
    }

    @Test
    void testOnLoginButtonClick_Success() {
        // Preparamos el mock para la respuesta exitosa.
        when(textFieldUsuario.getText()).thenReturn("usuarioTest");
        when(textFieldPassword.getText()).thenReturn("passwordTest");
        when(usuarioServiceModel.obtenerUsuarioPorNombreUsuario("usuarioTest", "passwordTest")).thenReturn(usuarioEntity);

        // Llamamos al método que estamos probando.
        loginController.onLoginButtonClick();

        // Verificamos que el mensaje de éxito se haya mostrado.
        verify(textFieldMensaje).setText("Usuario validado correctamente");
        // Verificamos que el método para cargar la siguiente escena se haya invocado.
        verify(buttonIniciarSesion).getScene();
    }

    @Test
    void testOnLoginButtonClick_Failure() {
        // Simulamos que el campo de usuario o contraseña está vacío.
        when(textFieldUsuario.getText()).thenReturn("");
        when(textFieldPassword.getText()).thenReturn("");

        // Llamamos al método que estamos probando.
        loginController.onLoginButtonClick();

        // Verificamos que el mensaje de error se haya mostrado.
        verify(textFieldMensaje).setText("Credenciales invalidas");
    }

    @Test
    void testOnLoginButtonClick_InvalidUser() {
        // Simulamos que el usuario no existe.
        when(textFieldUsuario.getText()).thenReturn("usuarioInvalido");
        when(textFieldPassword.getText()).thenReturn("passwordInvalido");
        when(usuarioServiceModel.obtenerUsuarioPorNombreUsuario("usuarioInvalido", "passwordInvalido")).thenReturn(null);
        when(usuarioServiceModel.obtenerUsuarioPorEmail("usuarioInvalido", "passwordInvalido")).thenReturn(null);

        // Llamamos al método que estamos probando.
        loginController.onLoginButtonClick();

        // Verificamos que el mensaje de error se haya mostrado.
        verify(textFieldMensaje).setText("Credenciales invalidas");
    }

    @Test
    void testSeleccionarIdioma() {
        // Simulamos que el ComboBox tiene seleccionado un idioma.
        when(comboIdioma.getValue()).thenReturn("es");

        // Llamamos al método que estamos probando.
        loginController.seleccionarIdiomaClick();

        // Verificamos que el idioma se haya cargado correctamente.
        verify(comboIdioma).getValue();
    }

    @Test
    void testOpenRegistrarClick() {
        // Simulamos la apertura de la ventana de registro.
        loginController.openRegistrarClick();

        // Verificamos que la escena de registro haya sido cargada correctamente.
        verify(buttonIniciarSesion).getScene();
    }
}
