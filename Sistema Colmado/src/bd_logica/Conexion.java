package bd_logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Lisito
 */
public class Conexion {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String BD = "db_colmado";
    private static final String URL = "jdbc:mysql://localhost/" + BD;
    private Connection conexion = null;

    
    public Connection getConection(){
        try {
            conexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Conexion Exitosa");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return conexion;
    }
    
}
