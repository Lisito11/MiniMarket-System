package bd_logica;

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


    Login login;
    private String usuario;
    private String password;
    private String email;
    private String nombre;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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

    public boolean ComprobarUsuario() {
        ResultSet rs = null;
        sql = "Select id_usuario,nombre,password,email from usuario where email = ?";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, getEmail());
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

    public ResultSet getNombreUsuario() {
        ResultSet datos = null;
        try {
            ps = (PreparedStatement) conexion.prepareStatement("select nombre from usuario where email = ? ");
            ps.setString(1, getEmail());
            datos = ps.executeQuery();
            System.out.println("CONSULTA EXITOSA");
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;

    }

    @Override
    public boolean Agregar() {
        sql = "INSERT INTO Usuario(id_usuario,nombre,id_administrador, password, email) values(?,?,?,?,?)";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, getUsuario());
            ps.setString(2, getNombre());
            ps.setString(3, "amgc72");
            ps.setString(4, getPassword());
            ps.setString(5, getEmail());

            ps.execute();
            System.out.println("Usuario Agregado");
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    

}
