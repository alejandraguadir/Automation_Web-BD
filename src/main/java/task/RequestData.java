package task;

import interactions.DatabaseConnection;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RequestData implements Task {
    private final String consultaSQL;
    private final String key;

    public RequestData(String consultaSQL, String key) {
        this.consultaSQL = consultaSQL;
        this.key = key;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try (Connection conexion = DatabaseConnection.getConnection();
             PreparedStatement statement = conexion.prepareStatement(consultaSQL);
             ResultSet resultado = statement.executeQuery()) {

            if (resultado.next()) {
                String products = resultado.getString("products"); // Obtener el valor consultado
                actor.remember(key, products); // Guardar el valor en el Actor
            } else {
                throw new RuntimeException("No se encontraron resultados para la consulta");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar la consulta", e);
        }
    }

    // Método para instanciar la tarea
    public static RequestData con(String consultaSQL, String key) {
        return instrumented(RequestData.class, consultaSQL, key);
    }
}

