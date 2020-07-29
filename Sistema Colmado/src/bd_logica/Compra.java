package bd_logica;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lisito
 */
public class Compra extends Conexion {

    private int idCompra;
    private String fechaCompra;
    private String proveedor;

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public ResultSet getTable(String consulta) {
        ResultSet datos = null;
        try {
            ps = (PreparedStatement) conexion.prepareStatement(consulta);
            datos = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;

    }

    public ResultSet getProveedores() {
        ResultSet datos = null;
        try {
            ps = (PreparedStatement) conexion.prepareStatement("select nombreEmpresa, id_proveedor from proveedor");
            datos = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;

    }

    public boolean PagarFacturaCredito(String pago) {
        sql = "UPDATE compra set Por_pagar = Por_pagar - ? where id_compra = ?";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setDouble(1, Double.parseDouble(pago));
            ps.setInt(2, getIdCompra());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public boolean Agregar() {
        sql = "INSERT INTO compra(id_compra,id_proveedor,fecha_compra) values(?,?,?)";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setInt(1, getIdCompra());
            ps.setString(2, getProveedor());
            ps.setString(3, getFechaCompra());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

   
}
