package es.mahoramas.lolpedia.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.mahoramas.lolpedia.model.abtrastas.Conexion;

class UsuarioServiceModelTest {

    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;
    private UsuarioServiceModel usuarioService;

    static class UsuarioServiceModelDummy extends UsuarioServiceModel {
        private final Connection mockedConnection;

        public UsuarioServiceModelDummy(Connection mockedConnection) {
            this.mockedConnection = mockedConnection;
        }

        @Override
        public Connection getConnection() {
            return mockedConnection;
        }
    }

    @BeforeEach
    void setUp() throws Exception {
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        usuarioService = new UsuarioServiceModelDummy(mockConnection);
    }

    @Test
    void testObtenerTodosUsuariosVacio() throws Exception {
        when(mockResultSet.next()).thenReturn(false);

        ArrayList<UsuarioEntity> usuarios = usuarioService.obtenerTodosUsuarios();

        assertNotNull(usuarios);
        assertTrue(usuarios.isEmpty(), "La lista de usuarios debería estar vacía");
    }

    @Test
    void testObtenerUsuarioPorEmailEncontrado() throws Exception {
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getString("nombreUsuario")).thenReturn("usuario123");
        when(mockResultSet.getString("nombre")).thenReturn("Juan");
        when(mockResultSet.getString("contrasenia")).thenReturn("password");
        when(mockResultSet.getString("email")).thenReturn("correo@test.com");

        UsuarioEntity usuario = usuarioService.obtenerUsuarioPorEmail("correo@test.com", "password");

        assertNotNull(usuario);
        assertEquals("usuario123", usuario.getNombreUsuario());
        assertEquals("Juan", usuario.getNombre());
        assertEquals("password", usuario.getContrasenia());
        assertEquals("correo@test.com", usuario.getEmail());
    }

    @Test
    void testObtenerUsuarioPorEmailNoEncontrado() throws Exception {
        when(mockResultSet.next()).thenReturn(false);

        UsuarioEntity usuario = usuarioService.obtenerUsuarioPorEmail("correo@test.com", "password");

        assertNull(usuario, "Debería devolver null si no encuentra al usuario");
    }

    @Test
    void testAniadirUsuarioExitoso() throws Exception {
        when(mockPreparedStatement.execute()).thenReturn(true);

        boolean resultado = usuarioService.aniadirUsuario("usuario123", "Juan", "password", "correo@test.com");

        assertTrue(resultado, "Debería devolver true si se inserta correctamente");
    }

    @Test
    void testAniadirUsuarioFalla() throws Exception {
        when(mockConnection.prepareStatement(anyString())).thenThrow(new RuntimeException("Error"));

        boolean resultado = usuarioService.aniadirUsuario("usuario123", "Juan", "password", "correo@test.com");

        assertFalse(resultado, "Debería devolver false si ocurre un error");
    }
}
