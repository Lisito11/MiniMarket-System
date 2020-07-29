package bd_logica;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lisito
 */
public class DetalleCompra extends Conexion {

    private int idCompra;
    private String idProducto;
    private String costoUnidad;
    private int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getCostoUnidad() {
        return costoUnidad;
    }

    public void setCostoUnidad(String costoUnidad) {
        this.costoUnidad = costoUnidad;
    }

    public boolean VerificarProducto(String idproducto) {
        sql = "select * from producto where id_producto = ? ";
        ResultSet rs = null;
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, idproducto);
            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Producto Valido");
                return true;
            } else {
                System.out.println("Producto NO Valido");
                return false;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public ResultSet getNombreProducto() {
        ResultSet datos = null;
        try {
            ps = (PreparedStatement) conexion.prepareStatement("select nombre from producto where id_producto = ?");
            ps.setString(1, getIdProducto());
            datos = ps.executeQuery();
            return datos;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;

    }

    public ResultSet getTotalCompra() {
        ResultSet datos = null;
        try {
            ps = (PreparedStatement) conexion.prepareStatement("select sum(costoUnidad * Cantidad) as total from detalle_compra WHERE id_compra = ?");
            ps.setInt(1, getIdCompra());
            datos = ps.executeQuery();
            return datos;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;

    }

    public boolean FinalizarCompraCredito(String porpagar) {
        sql = "UPDATE compra set Por_pagar = ? where id_compra = ?";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setDouble(1,Double.parseDouble(porpagar));
            ps.setInt(2, getIdCompra());
            ps.execute();
            System.out.println("Compra finalizada Credito");
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
    
    
    
     

    public boolean Eliminar(String idproducto, String cantidad, String costoUnidad, String idCompra) {
        sql = "delete from detalle_compra where id_producto = ?  and cantidad = ? and costoUnidad = ? and id_compra = ?";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, idproducto);
            ps.setInt(2, Integer.parseInt(cantidad));
            ps.setDouble(3, Double.parseDouble(costoUnidad));
            ps.setInt(4, Integer.parseInt(idCompra));
            ps.execute();
            System.out.println("Producto Elminado");
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public boolean Agregar() {
        sql = "INSERT INTO detalle_compra(id_compra,id_producto,costoUnidad,cantidad) values(?,?,?,?)";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setInt(1, getIdCompra());
            ps.setString(2, getIdProducto());
            ps.setDouble(3, Double.parseDouble(getCostoUnidad()));
            ps.setInt(4, getCantidad());
            ps.execute();
            System.out.println("Producto agregado");
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean FinalizarCompra() {
        sql = "call proc_completarCompra(?);";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            System.out.println(getIdCompra());
            ps.setInt(1, getIdCompra());
            ps.execute();
            conexion.close();
            System.out.println("Conexion finalizada");
            System.out.println("Compra finalizada");

            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    

}
