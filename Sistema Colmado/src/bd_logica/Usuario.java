package bd_logica;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Lisito
 */
public class Usuario extends Conexion {

    PreparedStatement ps = null;
    Connection conexion = (Connection) getConection();
    String sql;

    private String usuario;
    private String password;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean ComprobarUsuario(Usuario usr) {
        ResultSet rs = null;
        sql = "Select id_usuario,nombre, password from usuario where nombre = ?";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();
            if (rs.next()) {
                
                if(getPassword().equals(rs.getString(3))){
                return true;
                }
                else{
                    return false;
                }
                
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

}
