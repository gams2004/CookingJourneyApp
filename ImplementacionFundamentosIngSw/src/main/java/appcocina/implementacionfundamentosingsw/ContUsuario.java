package appcocina.implementacionfundamentosingsw;

import java.util.ArrayList;

public class ContUsuario implements Controlador{
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public void agregarUsuario(String nombre, String contrasena, String correo, long telefono ){
        usuarios.add(new Usuario(nombre,contrasena,correo,telefono));
    }

    public void agregarUsuario(Usuario u){
        usuarios.add(new Usuario(u.getNombre(),u.getContrasena(),u.getCorreo(),u.getTelefono()));
    }
    public Usuario buscarUsuario(String nombre){
        for(Usuario u:usuarios){
            if(u.getNombre().equals(nombre))
                return u;
        }
        return null;
    }

    public Usuario buscarContrasena(String contrasena){
        for(Usuario u:usuarios){
            if(u.getContrasena().equals(contrasena))
                return u;
        }
        return null;
    }

}
