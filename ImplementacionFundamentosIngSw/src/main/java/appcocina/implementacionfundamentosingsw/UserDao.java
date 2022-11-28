package appcocina.implementacionfundamentosingsw;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import appcocina.implementacionfundamentosingsw.BD.Conexion;
import appcocina.implementacionfundamentosingsw.Dao;
import appcocina.implementacionfundamentosingsw.Usuario;

public class UserDao implements Dao {

    @Override
    public boolean registrar(Usuario usuario) {
        boolean registrar = false;

        Statement stm= null;
        Connection con=null;

        String sql="INSERT INTO cliente values (NULL,'"+usuario.getNombre()+"','"+usuario.getCorreo()+"','"+usuario.getTelefono()+"','"+usuario.getContrasena()+"')";

        try {
            con=Conexion.connect();
            stm= con.createStatement();
            stm.execute(sql);
            registrar=true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método registrar");
            e.printStackTrace();
        }
        return registrar;
    }

    @Override
    public List<Usuario> obtener() {
        Connection co =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="SELECT * FROM CLIENTE ORDER BY ID";

        List<Usuario> listaUsuario= new ArrayList<Usuario>();

        try {
            co= Conexion.connect();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Usuario c=new Usuario();
                c.setNombre(rs.getString(1));
                c.setCorreo(rs.getString(2));
                c.setTelefono(rs.getLong(3));
                c.setContrasena(rs.getString(4));
                listaUsuario.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO, método obtener");
            e.printStackTrace();
        }

        return listaUsuario;
    }

    @Override
    public boolean actualizar(Usuario usuario) {
        Connection connect= null;
        Statement stm= null;

        boolean actualizar=false;

        String sql="UPDATE CLIENTE SET correo='"+usuario.getCorreo()+"', nombres='"+usuario.getNombre()+"', telefono='"+usuario.getTelefono()+"'" +" WHERE CONTRASEÑA="+usuario.getContrasena();
        try {
            connect=Conexion.connect();
            stm=connect.createStatement();
            stm.execute(sql);
            actualizar=true;
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Usuario usuario) {
        Connection connect= null;
        Statement stm= null;

        boolean eliminar=false;

        String sql="DELETE FROM CLIENTE WHERE CORREO="+usuario.getCorreo();
        try {
            connect=Conexion.connect();
            stm=connect.createStatement();
            stm.execute(sql);
            eliminar=true;
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }

}