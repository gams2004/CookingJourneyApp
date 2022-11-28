package appcocina.implementacionfundamentosingsw.BD;

import java.sql.*;

public class Operaciones {
    public static void comprasDisponibles() throws SQLException {
        String SQL = "SELECT * FROM compras";
        Connection conn = Conexion.connect();
        Statement pstmt = conn.createStatement();
        ResultSet rs = pstmt.executeQuery(SQL);
        displayCompra(rs);
    }
    public static int buscarCompraCodigo(int codigo) throws Exception {
        int a;
        String SQL = "SELECT * "
                + "FROM compras "
                + "WHERE codigo_compra = ?";

        Connection conn = Conexion.connect();
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setInt(1, codigo);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        a = rs.getInt("codigo_compra");
        return a;
    }
    public static void insertarCompra(int codigoCompra, int codigoObra, int codigoCliente, String fecha, String pagado) throws SQLException {
        String SQL = " INSERT INTO compras(" +
                "codigo_compra, codigo_obra, codigo_cliente, fecha, pagado)" +
                "VALUES (?,?,?,?,?);";

        Connection conn = Conexion.connect();
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setInt(1, codigoCompra);
        pstmt.setInt(2, codigoObra);
        pstmt.setInt(3, codigoCliente);
        pstmt.setString(4, fecha);
        pstmt.setString(5, pagado);
        pstmt.executeUpdate();

        /*Compra compra = new Compra(codigoCompra,codigoObra,codigoCliente,fecha,pagado);
        ControlGaleria.compras.add(compra);*/
    }
    public static void borrarCompra(int codigo) throws Exception {
        boolean cent = false;
        /*for(Compra e: ControlGaleria.compras)
            if (e.getCodigoCompra() == codigo)
                cent = true;
        if(!cent)
            throw new Exception("SQLException");*/

        String SQL = "DELETE FROM compras WHERE codigo_compra = ?";
        Connection conn = Conexion.connect();
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setInt(1, codigo);
        pstmt.executeUpdate();
    }
    public static void clientesDisponibles() throws SQLException {
        String SQL = "SELECT * FROM clientes";

        Connection conn = Conexion.connect();
        Statement pstmt = conn.createStatement();

        ResultSet rs = pstmt.executeQuery(SQL);
        displayCliente(rs);
    }
    public static int buscarClienteNombre(String nombre) throws SQLException {

        String SQL = "SELECT * "
                + "FROM clientes "
                + "WHERE nombre = ?";

        Connection conn = Conexion.connect();
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setString(1, nombre);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        return rs.getInt("codigo_cliente");
    }
    public static void borrarCliente(int codigo) throws SQLException {
        String SQL = "DELETE FROM clientes WHERE codigo_cliente = ?";
        Connection conn = Conexion.connect();
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setInt(1, codigo);
        pstmt.executeUpdate();

    }
    public static void insertarCliente(int codigo, String nombre, String apellido, String direcEntrega, long telefono, int cedula) throws SQLException {
        String SQL = " INSERT INTO clientes(" +
                "codigo_cliente, nombre, apellido, direccion_entrega, telefono, cedula)" +
                "VALUES (?,?,?,?,?,?);";
        Connection conn = Conexion.connect();
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setInt(1, codigo);
        pstmt.setString(2, nombre);
        pstmt.setString(3, apellido);
        pstmt.setString(4, direcEntrega);
        pstmt.setInt(5, (int) telefono);
        pstmt.setInt(6, cedula);
        pstmt.executeUpdate();
    }
    public static void obrasDisponibles() throws SQLException {
        String SQL = "SELECT * FROM obras";
        Connection conn = Conexion.connect();
        Statement pstmt = conn.createStatement();
        ResultSet rs = pstmt.executeQuery(SQL);
        displayObra(rs);
    }
    public static int buscarObraTitulo(String titulo) throws Exception {
        int codigo;
        String SQL = "SELECT * "
                + "FROM obras "
                + "WHERE titulo = ?";

        Connection conn = Conexion.connect();
        PreparedStatement pstmt = conn.prepareStatement(SQL);

        pstmt.setString(1, titulo);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        codigo = rs.getInt("codigo_obra");
        return codigo;
    }
    public static void insertarObra(int codigo, String titulo, String fecha, int precioRef, int dimensiones) throws SQLException {
        String SQL = " INSERT INTO obras(" +
                "codigo_obra, titulo, fecha, precio_referencia, dimensiones)" +
                "VALUES (?,?,?,?,?);";

        Connection conn = Conexion.connect();
        PreparedStatement pstmt = conn.prepareStatement(SQL);

        pstmt.setInt(1, codigo);
        pstmt.setString(2, titulo);
        pstmt.setString(3, fecha);
        pstmt.setInt(4, precioRef);
        pstmt.setInt(5, dimensiones);
        /*Obra obra = new Obra(codigo,titulo,fecha,precioRef,dimensiones);
        ControlGaleria.listaObras.add(obra);*/
        pstmt.executeUpdate();

    }
    public static void borrarObra(String titulo) throws Exception {
        boolean cent = false;
        /*for(Obra e: ControlGaleria.listaObras)
            if (e.getTitulo().equalsIgnoreCase(titulo))
                cent = true;
        if(!cent)
            throw new Exception("SQLException");*/

        String SQL = "DELETE FROM obras WHERE titulo = ?";
        Connection conn = Conexion.connect();
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setString(1, titulo);
        pstmt.executeUpdate();
    }
    public static void artistasDisponibles() {
        String SQL = "SELECT * FROM artistas";

        try (Connection conn = Conexion.connect();
             Statement pstmt = conn.createStatement()) {

            ResultSet rs = pstmt.executeQuery(SQL);
            displayArtistas(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static boolean insertarArtista(int codigo, String nombre, String apellido, int cedula, String fechaNacimiento, int telefono) {
        String SQL = " INSERT INTO artistas(" +
                "codigo_artista, cedula, nombre, apellido, fecha_nacimiento, telefono)" +
                "VALUES (?,?,?,?,?,?);";

        try (Connection conn = Conexion.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, codigo);
            pstmt.setInt(2, cedula);
            pstmt.setString(3, nombre);
            pstmt.setString(4, apellido);
            pstmt.setString(5, fechaNacimiento);
            pstmt.setInt(6, telefono);
            pstmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    public static boolean anexarObraArtista(int codObra, int codArtista) {
        String SQL = " INSERT INTO obra_artista(" +
                "codigo_obra, codigo_artista)" +
                "VALUES (?,?);";

        try (Connection conn = Conexion.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, codObra);
            pstmt.setInt(2, codArtista);
            pstmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    private static void displayObra(ResultSet rs) throws SQLException {
        while (rs.next()) {
            //Obra obra = new Obra( rs.getInt("codigo_obra"),rs.getString("titulo"),
                   // rs.getString("fecha"),rs.getInt("precio_referencia"),rs.getInt("dimensiones"));
            //ControlGaleria.listaObras.add(obra);
        }
    }
    private static void displayCliente(ResultSet rs) throws SQLException {
        while (rs.next()) {
            /*Cliente cliente = new Cliente(rs.getInt("codigo_cliente"),rs.getInt("cedula"),rs.getString("nombre"),
                    rs.getString("apellido"),rs.getString("direccion_entrega"),rs.getLong("telefono"));
            ControlGaleria.listaClientes.add(cliente);*/
        }
    }
    private static void displayCompra(ResultSet rs) throws SQLException {
        while (rs.next()) {
            /*Compra compra = new Compra(rs.getInt("codigo_compra"),rs.getInt("codigo_obra"),rs.getInt("codigo_cliente"),
                    rs.getString("fecha"),rs.getString("pagado"));
            ControlGaleria.compras.add(compra);*/
        }
    }
    private static void displayArtistas(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println("\t" + rs.getString("codigo_artista") + "\t"
                    + rs.getString("cedula") + "\t"
                    + rs.getString("nombre") + "\t"
                    + rs.getString("apellido") + "\t"
                    + rs.getString("telefono") + "\t"
                    + rs.getString("fecha_nacimiento"));
        }
    }
}