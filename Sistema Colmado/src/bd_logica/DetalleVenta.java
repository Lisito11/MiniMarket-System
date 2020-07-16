package bd_logica;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DetalleVenta extends Consultas {

    private int idVenta;
    private String idProducto;
    private String fechaProducto;
    private int cantidad;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getFechaProducto() {
        return fechaProducto;
    }

    public void setFechaProducto(String fechaProducto) {
        this.fechaProducto = fechaProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean Agregar(DetalleVenta dv) {
        sql = "INSERT INTO detalle_venta(id_venta,id_producto,cantidad,hora_producto) values(?,?,?,?)";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setInt(1, dv.getIdVenta());
            ps.setString(2, dv.getIdProducto());
            ps.setInt(3, dv.getCantidad());
            ps.setString(4, dv.getFechaProducto());
            ps.execute();
            System.out.println("Producto agregado");
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean Eliminar(String nombre, int cnt, String hora) {
        sql = "delete from detalle_venta where id_producto = ?  and cantidad = ? and hora_producto = ?";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setInt(2, cnt);
            ps.setString(3, hora);

            ps.execute();
            System.out.println("Producto Elminado");
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public String[] BuscarProductoMasVendido(String idVenta) {
        sql = "select dv.id_producto,p.nombre, sum(dv.cantidad) from detalle_venta dv inner join producto p on dv.id_producto = p.id_producto WHERE dv.id_venta = ? GROUP by dv.id_producto \n"
                + "order by sum(dv.cantidad) desc LIMIT 1";
        ResultSet rs = null;
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, idVenta);
            rs = ps.executeQuery();

            if (rs.next()) {
                String[] a = {rs.getString("dv.id_producto"), rs.getString("p.nombre"), String.valueOf(rs.getInt("sum(dv.cantidad)"))};
                return a;

            } else {
                System.out.println("Producto NO Valido");
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
        return null;

    }
    
     public String[] BuscarProductoMenosVendido(String idVenta) {
        sql = "select dv.id_producto,p.nombre, sum(dv.cantidad) from detalle_venta dv inner join producto p on dv.id_producto = p.id_producto WHERE dv.id_venta = ? GROUP by dv.id_producto \n"
                + "order by sum(dv.cantidad) asc LIMIT 1";
        ResultSet rs = null;
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, idVenta);
            rs = ps.executeQuery();

            if (rs.next()) {
                String[] a = {rs.getString("dv.id_producto"), rs.getString("p.nombre"), String.valueOf(rs.getInt("sum(dv.cantidad)"))};
                return a;

            } else {
                System.out.println("Producto NO Valido");
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
        return null;

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

    public boolean EditarProducto(String productoM, String horaM, String cantidadM, String idA, String horaA, String cantidadA) {
        sql = "update detalle_venta set id_producto = ?, cantidad = ?, hora_producto = ? where id_producto = ? and cantidad = ? and hora_producto = ?";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, productoM);
            ps.setInt(2, Integer.parseInt(cantidadM));
            ps.setString(3, horaM);
            ps.setString(4, idA);
            ps.setInt(5, Integer.parseInt(cantidadA));
            ps.setString(6, horaA);
            ps.execute();
            System.out.println("Producto Editado");
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean FinalizarVenta(String idVenta) {
        sql = "call proc_FinalizarVenta(?);";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, idVenta);
            ps.execute();
            conexion.close();
            System.out.println("Conexion finalizada");
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public ResultSet getTable(String consulta) {
        ResultSet datos = null;
        try {
            ps = (PreparedStatement) conexion.prepareStatement(consulta);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Editar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
