package bd_logica;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lisito
 */
public abstract class Conexion {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String BD = "db_colmado";
    private static final String URL = "jdbc:mysql://localhost/" + BD;
    private Connection conexionn = null;
    PreparedStatement ps = null;
    String sql;
    Connection conexion = (Connection) getConection();

    abstract public boolean Agregar();

    public Connection getConection() {
        try {
            conexionn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conexionn;
    }

}
