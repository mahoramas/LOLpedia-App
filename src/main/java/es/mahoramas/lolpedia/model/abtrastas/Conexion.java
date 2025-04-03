package es.ies.puerto.model.abtrastas;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Conexion {

    static final String PATH_DB ="src\\main\\resources\\usuarios.db";
    private Connection connection;

    /**
     * Constructor con path de conexion
     * 
     * @param unaRutaArchivoBD ruta de la bbdd
     * @throws SQLException error controlado
     */
    public Conexion() {
        try {
            if (PATH_DB == null || PATH_DB.isEmpty()) {
                throw new SQLException("El fichero es nullo o vacio");
            }
            File file = new File(PATH_DB);
            if (!file.exists()) {
                throw new SQLException("No exise la bbdd:" + PATH_DB);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getRutaArchivoBD() {
        return this.PATH_DB;
    }

    public Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:sqlite:" + PATH_DB);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this.connection;
    }

    /**
     * Funcion que abre la conexion a la bbdd
     * 
     * @return
     * @throws SQLException
     */
    public Connection conectar() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:sqlite:" + PATH_DB);
        }
        return connection;
    }

    /**
     * Funcion que cierra la conexion de bbdd
     * 
     * @throws SQLException
     */
    public void cerrar() {
        try {
            if (connection != null || !connection.isClosed()) {
                connection.close();
                connection = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
