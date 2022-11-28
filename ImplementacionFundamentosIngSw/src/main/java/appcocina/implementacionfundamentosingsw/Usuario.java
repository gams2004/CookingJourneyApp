package appcocina.implementacionfundamentosingsw;

public class Usuario {

    private String nombre;
    private String contrasena;
    private String correo;
    private long telefono;


    public Usuario(String nombre, String contrasena, String correo, long telefono) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Usuario() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
}
