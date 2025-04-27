package es.mahoramas.lolpedia.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioEntityTest {

    private UsuarioEntity usuarioEntity;

    @BeforeEach
    void setUp() {
        usuarioEntity = new UsuarioEntity("elpro", "123", "mati", "matielpro@gmail.com");
    }

    @Test
    void testGetters() {
        assertEquals("elpro", usuarioEntity.getNombreUsuario());
        assertEquals("123", usuarioEntity.getContrasenia());
        assertEquals("mati", usuarioEntity.getNombre());
        assertEquals("matielpro@gmail.com", usuarioEntity.getEmail());
    }

    @Test
    void testSetters() {
        usuarioEntity.setNombreUsuario("nuevoUsuario");
        usuarioEntity.setContrasenia("nuevaPass");
        usuarioEntity.setNombre("Nuevo Nombre");
        usuarioEntity.setEmail("nuevoemail@example.com");

        assertEquals("nuevoUsuario", usuarioEntity.getNombreUsuario());
        assertEquals("nuevaPass", usuarioEntity.getContrasenia());
        assertEquals("Nuevo Nombre", usuarioEntity.getNombre());
        assertEquals("nuevoemail@example.com", usuarioEntity.getEmail());
    }

    @Test
    void testEquals() {
        UsuarioEntity otroUsuario = new UsuarioEntity("elpro", "123", "mati", "matielpro@gmail.com");
        assertEquals(usuarioEntity, otroUsuario);
    }

    @Test
    void testHashCode() {
        UsuarioEntity otroUsuario = new UsuarioEntity("elpro", "123", "mati", "matielpro@gmail.com");
        assertEquals(usuarioEntity.hashCode(), otroUsuario.hashCode());
    }

    @Test
    void testToString() {
        String esperado = "elpro,123,mati,matielpro@gmail.com";
        assertEquals(esperado, usuarioEntity.toString());
    }
}
