package es.mahoramas.lolpedia.model;
import java.util.Objects;

/**
 * @author mahoramas
 */
public class UsuarioEntity {

    private String nombreUsuario;
    private String contrasenia;
    private String nombre;
    private String email;

    /**
     * Constructor vacio
     */
    public UsuarioEntity(){}

    /**
     * Constructor con el atributo principal de la clase
     * @param email de usuario
     */
    public UsuarioEntity(String email){
        this.email = email;
    }

    /**
     * Constructor de los atributos de la clase
     * @param nombreUsuario nombre de usuario
     * @param contrasenia contrasenia del usuario
     * @param nombre nombre del usuario
     * @param email email del usuario
     */
    public UsuarioEntity(String nombreUsuario, String contrasenia,String nombre,String email ){
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Funcion equals de la clase
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UsuarioEntity)) {
            return false;
        }
        UsuarioEntity ususarioModel = (UsuarioEntity) o;
        return Objects.equals(email, ususarioModel.email);
    }

    /**
     * Funcion hascode de la clase
     */
    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    /**
     * Funcion toString de la clase
     */
    @Override
    public String toString() {
        return getNombreUsuario() + "," +
            getContrasenia() + "," +
            getNombre() + "," +
            getEmail();
    }

}
