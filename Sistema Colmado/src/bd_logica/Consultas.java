package bd_logica;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 *
 * @author Lisito
 */
public abstract class Consultas extends Conexion{
    PreparedStatement ps = null;
    Connection conexion = (Connection) getConection();
    String sql;
    abstract public boolean Agregar();
    abstract public boolean Editar();
}
