package es.mahoramas.lolpedia.sesion;

import es.mahoramas.lolpedia.model.UsuarioEntity;

public class Sesion {
    private static Sesion instance;
    private UsuarioEntity usuarioActual;

    private Sesion() {}

    public static Sesion getInstance() {
        if (instance == null) {
            instance = new Sesion();
        }
        return instance;
    }

    public UsuarioEntity getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(UsuarioEntity user) {
        this.usuarioActual = user;
    }

    public void logout() {
        this.usuarioActual = null;
    }
}
