package appcocina.implementacionfundamentosingsw;


import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class ManejadorArchivos {

    public ContUsuario leerUsuarios() throws IOException {
        ContUsuario contUsuario = new ContUsuario();
        InputStreamReader input = new InputStreamReader(new FileInputStream("Usuarios.txt"));
        BufferedReader fa = new BufferedReader(input);
        String cad = fa.readLine();
        while (cad!=null) {
            Scanner del = new Scanner(cad).useDelimiter("%");
            String nombre = del.next();
            String contrasena = del.next();
            String correo = del.next();
            long telefono = del.nextLong();
            cad = fa.readLine();
            contUsuario.agregarUsuario(nombre, contrasena, correo, telefono);
        }
        return contUsuario;
    }

    public static void EscribirAArchivoTexto(ContUsuario man, String nombre){
        String nomarch = "Usuarios.txt";
        Usuario usuario = man.buscarUsuario(nombre);
        try{
            // Se crea el flujo de salida al archivo de nombre nomarch
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomarch, true));
            writer.append("\n").append(usuario.getNombre()).append("%").append(usuario.getContrasena()).append("%").append(usuario.getCorreo()).append("%").append(String.valueOf(usuario.getTelefono())).append("%");
            writer.close();
        }
        catch(Exception e){
            System.out.println("Ocurrio un error escribiendo a un archivo el reporte: " + e);
        }
    }

}

