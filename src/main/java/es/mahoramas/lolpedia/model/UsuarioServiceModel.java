package es.mahoramas.lolpedia.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import es.mahoramas.lolpedia.model.abtrastas.Conexion;

public class UsuarioServiceModel extends Conexion {

    Set<UsuarioEntity> usuarioEntity;
    public UsuarioServiceModel() {
        super();
        usuarioEntity = new HashSet(obtenerTodosUsuarios());
    }


    public UsuarioEntity obtenerUsuarioPorEmail(String email, String contrasenia) {
        String sql = "SELECT * FROM Usuario " + "where email= '" + email + "' and contrasenia = '" + contrasenia + "'";
        ArrayList<UsuarioEntity> usuarios = obtenerUsuario(sql);
        if (usuarios.isEmpty()) {
            return null;
        }
        return usuarios.get(0);

    }

    public ArrayList<UsuarioEntity> obtenerTodosUsuarios() {
        String sql = "SELECT * FROM Usuario";
        return obtenerUsuario(sql);
    }

    public ArrayList<UsuarioEntity> obtenerUsuario(String sql) {
        ArrayList<UsuarioEntity> usuarios = new ArrayList<UsuarioEntity>();
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                String usuarioStr = resultado.getString("nombreUsuario");
                String nombreStr = resultado.getString("nombre");
                String contraseniaStr = resultado.getString("contrasenia");
                String emailStr = resultado.getString("email");
                UsuarioEntity usuarioModel = new UsuarioEntity(usuarioStr, contraseniaStr, nombreStr,emailStr );
                usuarios.add(usuarioModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
        return usuarios;
    }

    public UsuarioEntity obtenerUsuarioPorNombreUsuario(String nombreUsuario, String contrasenia) {
        String sql = "SELECT * FROM usuario WHERE nombreUsuario = '" + nombreUsuario + "' and contrasenia = '"
                + contrasenia + "'";
        ArrayList<UsuarioEntity> usuarios = obtenerUsuario(sql);
        if (usuarios.isEmpty()) {
            return null;
        }
        return usuarios.get(0);
    }

    public boolean aniadirUsuario(String nombreUsuario, String nombre, String contrasenia, String email) {
        try {
            PreparedStatement sentencia = getConnection().prepareStatement("INSERT INTO usuario (nombreUsuario, nombre, contrasenia, email) values (?,?,?,?)");
            sentencia.setString(1, nombreUsuario);
            sentencia.setString(2, nombre);
            sentencia.setString(3, contrasenia);
            sentencia.setString(4, email);
            sentencia.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally{
            cerrar();
        }
    }

    /**
     * Funcion que verifica si existe el emai asi en los ficheros
     * @param email a verificar
     * @return true/false
     */
    public boolean verificarEmail(String email){
        for (UsuarioEntity usuarioModelBuscar : usuarioEntity) {
            if (usuarioModelBuscar.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Funcion que verifica si existe el usuario en los ficheros
     * @param nombreUsuario a verificar
     * @return true/false
     */
    public boolean verificarUsuario(String nombreUsuario){
        for (UsuarioEntity usuarioModelBuscar : usuarioEntity) {
            if (usuarioModelBuscar.getNombreUsuario().equals(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }

}
