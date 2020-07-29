package bd_logica;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Lisito
 */
public class Proveedor extends Conexion {

    private String idProveedor;
    private String nombreEmpresa;
    private String nombreContacto;
    private String telefonoContacto;
    private String telefonoEmpresa;
    private String direccion;

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean Agregar() {
        sql = "INSERT INTO Proveedor(id_proveedor,nombreEmpresa,nombreContacto, telefonoContacto, telefonoEmpresa,direccion) values(?,?,?,?,?,?)";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, getIdProveedor());
            ps.setString(2, getNombreEmpresa());
            ps.setString(3, getNombreContacto());
            ps.setString(4, getTelefonoContacto());
            ps.setString(5, getTelefonoEmpresa());
            ps.setString(6, getDireccion());

            ps.execute();
            System.out.println("Usuario Agregado");
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }

    }

    

}
