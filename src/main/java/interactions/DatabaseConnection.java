package interactions;

import com.sun.tools.sjavac.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3307/db_sausedemo";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "admi";

    public static Connection getConnection() {
        try {
            Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            if (conexion != null) {
                System.out.println("Conexión exitosa a la base de datos.");

            }
            return conexion;
        } catch (SQLException e) {
            System.out.println("Error en la conexión a la base de datos: " + e.getMessage());
            throw new RuntimeException("Error en la conexión a la base de datos", e);
        }
    }
}
