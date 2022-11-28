package appcocina.implementacionfundamentosingsw;

public class CreadorControladores {
    private Controlador contUsuario;

    public CreadorControladores(){
        contUsuario = new ContUsuario();
    }

    public void agregarUsuarioCont(String nombre, String contrasena, String correo, long telefono){
        contUsuario.agregarUsuario(nombre,contrasena,correo,telefono);
    }

    public void agregarUsuarioCont(Usuario u){
        contUsuario.agregarUsuario(u);
    }

    public void buscarUsarioCont(String nombre){
        contUsuario.buscarUsuario(nombre);
    }

    public void buscarContrasenaCont(String contrasena){
        contUsuario.buscarContrasena(contrasena);
    }
}
