package appcocina.implementacionfundamentosingsw;

public interface Controlador {
    void agregarUsuario(String nombre, String contrasena, String correo, long telefono );
    public void agregarUsuario(Usuario u);
    public Usuario buscarUsuario(String nombre);
    public Usuario buscarContrasena(String contrasena);
}
