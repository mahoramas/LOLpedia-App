package es.mahoramas.lolpedia.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.mahoramas.lolpedia.model.abtrastas.Conexion;

class ConexionTest {

    private Connection mockConnection;
    private Conexion conexion;

    // Clase Dummy que fuerza usar el mock
    static class ConexionDummy extends Conexion {
        private final Connection mockedConnection;
    
        public ConexionDummy(Connection mockedConnection) {
            this.mockedConnection = mockedConnection;
        }
    
        @Override
        public Connection getConnection() {
            return mockedConnection;
        }
    }
    

    @BeforeEach
    void setUp() {
        mockConnection = mock(Connection.class);
        conexion = new ConexionDummy(mockConnection);
    }

    @Test
    void testConectarDevuelveConexionMockeada() throws SQLException {
        // Ejecutar
        Connection conn = conexion.getConnection();

        // Verificar
        assertNotNull(conn, "La conexión no debería ser nula");
        assertSame(mockConnection, conn, "La conexión debería ser exactamente el mock");
    }

    @Test
    void testCerrarConexionCuandoEstaAbierta() throws SQLException {
        // Preparar
        when(mockConnection.isClosed()).thenReturn(false);

        // Ejecutar
        conexion.cerrar();

        // Verificar
        verify(mockConnection, times(1)).close();
    }

    @Test
    void testCerrarConexionCuandoYaEstaCerrada() throws SQLException {
        // Preparar
        when(mockConnection.isClosed()).thenReturn(true);

        // Ejecutar
        conexion.cerrar();

        // Verificar
        verify(mockConnection, never()).close();
    }
}
