package es.mahoramas.lolpedia.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import es.mahoramas.lolpedia.config.ConfigManager;
import es.mahoramas.lolpedia.controller.abstractas.AbstractController;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Properties;

@ExtendWith(PowerMockExtension.class)
@PrepareForTest({ Text.class, TextField.class, PasswordField.class, ConfigManager.ConfigProperties.class })
class AbstractControllerTest {

    @Mock
    private AbstractController controller;

    @Mock
    private Text textUsuario;
    @Mock
    private TextField textFieldUsuario;
    @Mock
    private Text textContrasenia;
    @Mock
    private PasswordField textFieldPassword;
    @Mock
    private Button buttonRegistrar;

    @BeforeEach
    void setUp() {
        // Inicializa los mocks de Mockito
        MockitoAnnotations.openMocks(this);

        // Creamos una instancia anónima de AbstractController para probar sus métodos.
        controller = new AbstractController() {};  // Usamos la clase anónima ya que es abstracta.
        
        // Inyectamos los mocks en la instancia de AbstractController
        controller.textUsuario = textUsuario;
        controller.textFieldUsuario = textFieldUsuario;
        controller.textContrasenia = textContrasenia;
        controller.textFieldPassword = textFieldPassword;
        controller.buttonRegistrar = buttonRegistrar;

        // Usamos PowerMockito para mockear la clase estática
        PowerMockito.mockStatic(ConfigManager.ConfigProperties.class);
    }

    @Test
    void testCambiarIdioma() {
        // Mock de las propiedades de idioma
        when(ConfigManager.ConfigProperties.getProperty("textUsuario")).thenReturn("Usuario");
        when(ConfigManager.ConfigProperties.getProperty("textContrasenia")).thenReturn("Contraseña");

        // Llamada al método cambiarIdioma
        controller.cambiarIdioma();

        // Verificar que los métodos setText se invocan con los valores correctos
        verify(textUsuario).setText("Usuario");
        verify(textContrasenia).setText("Contraseña");
    }

    @Test
    void testLoadIdioma() {
        // Test de carga correcta de propiedades
        String idioma = "es";
        String nombreFichero = "strings";
        
        Properties properties = mock(Properties.class);
        properties.setProperty("textUsuario", "Usuario");
        properties.setProperty("textContrasenia", "Contraseña");

        // Simulamos la carga de propiedades
        when(controller.loadIdioma(nombreFichero, idioma)).thenReturn(properties);

        Properties result = controller.loadIdioma(nombreFichero, idioma);

        // Verificamos que las propiedades correctas han sido cargadas
        assertEquals("Usuario", result.getProperty("textUsuario"));
        assertEquals("Contraseña", result.getProperty("textContrasenia"));
    }

    @Test
    void testLoadIdiomaFileNotFound() {
        // Test cuando el archivo no existe
        AbstractController controller = new AbstractController() {};  // Usamos la clase anónima

        String idioma = "es";
        String nombreFichero = "strings";

        // Simulamos que el archivo no existe
        Properties properties = controller.loadIdioma(nombreFichero, idioma);
        
        // Comprobamos que no se cargaron propiedades
        assertTrue(properties.isEmpty());
    }

    @Test
    void testSetAndGetPropertiesIdioma() {
        // Test de setter y getter de propertiesIdioma
        AbstractController controller = new AbstractController() {};  // Usamos la clase anónima

        Properties properties = new Properties();
        properties.setProperty("key", "value");

        controller.setpropertiesIdioma(properties);

        Properties result = controller.getPropertiesIdioma();

        // Verificamos que el setter y getter funcionan correctamente
        assertNotNull(result);
        assertEquals("value", result.getProperty("key"));
    }
}
