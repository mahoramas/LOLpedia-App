package es.mahoramas.lolpedia.model;
import java.util.Objects;

public class UsuariosModel {
    private String usuario;
    private String nombre;
    private String correo;
    private String password;


    public UsuariosModel() {
    }

    public UsuariosModel(String correo) {
        this.correo = correo;
    }

    public UsuariosModel(String usuario, String nombre, String correo, String password) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UsuariosModel)) {
            return false;
        }
        UsuariosModel usuariosModel = (UsuariosModel) o;
        return Objects.equals(correo, usuariosModel.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correo);
    }

    @Override
    public String toString() {
        return "{" +
            " usuario='" + getUsuario() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", correo='" + getCorreo() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }

}
