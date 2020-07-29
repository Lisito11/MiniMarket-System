package bd_logica;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import vista.Login;

/**
 *
 * @author Lisito
 */
public class Usuario extends Conexion {

    PreparedStatement ps = null;
    Connection conexion = (Connection) getConection();
    String sql;
    Login login;
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

                return getPassword().equals(rs.getString(3));

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
                JOptionPane.showMessageDialog(login, "Ha ocurrido un problema al conectarse a la base de datos");
                System.err.println(e);
            }
        }
    }

}
