package appcocina.implementacionfundamentosingsw.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String url = "jdbc:postgresql://localhost/DatosUsuarioCocina";
    private static final String user = "postgres";
    private static final String password = "1234";

    public static Connection connect() throws SQLException {
        Connection c =DriverManager.getConnection(url, user, password);
        return c;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
