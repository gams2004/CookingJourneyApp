package appcocina.implementacionfundamentosingsw;

import java.util.List;

import appcocina.implementacionfundamentosingsw.Usuario;

public interface Dao {

    public boolean registrar(Usuario usuario);
    public List<Usuario> obtener();
    public boolean actualizar(Usuario usuario);
    public boolean eliminar(Usuario usuario);
}
