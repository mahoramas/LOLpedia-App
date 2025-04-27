package es.mahoramas.lolpedia.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import es.mahoramas.lolpedia.model.abtrastas.Conexion;

class ConexionTest {

    private Connection mockConnection;

    static class ConexionDummy extends Conexion {
        private Connection mockedConnection;

        public ConexionDummy(Connection mockedConnection) {
            this.mockedConnection = mockedConnection;
        }

        @Override
        public Connection getConnection() {
            return mockedConnection;
        }
    }

    private ConexionDummy conexion;

    @BeforeEach
    void setUp() {
        mockConnection = mock(Connection.class);

        conexion = new ConexionDummy(mockConnection);
    }

    @Test
    void testConectar() throws SQLException {
        Connection conn = conexion.getConnection();
        assertNotNull(conn);
        assertEquals(mockConnection, conn);
    }

    @Test
    void testCerrarConexion() throws SQLException {
        // Preparamos el mock
        when(mockConnection.isClosed()).thenReturn(false);
    
        // Inyectamos el mock a una nueva instancia de Conexion
        conexion = new Conexion() {
            {
                this.connection = mockConnection;
            }
        };
    
        // Ahora cerramos
        conexion.cerrar();
    
        // Y verificamos que cerró correctamente
        verify(mockConnection, times(1)).close();
    }

    @Test
    void testCerrarConexionYaCerrada() throws SQLException {
        when(mockConnection.isClosed()).thenReturn(true);
        conexion.cerrar();
        verify(mockConnection, never()).close();
    }
}
