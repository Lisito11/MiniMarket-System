package bd_logica;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lisito
 */
public class Venta extends Consultas {

    private int idVenta;
    private String idAdministrador;
    private String fechaVenta;
    private double totalVenta;
    private double costoVenta;
    private double gananciaVenta;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public double getCostoVenta() {
        return costoVenta;
    }

    public void setCostoVenta(double costoVenta) {
        this.costoVenta = costoVenta;
    }

    public double getGananciaVenta() {
        return gananciaVenta;
    }

    public void setGananciaVenta(double gananciaVenta) {
        this.gananciaVenta = gananciaVenta;
    }

    public boolean AgregarVenta(Venta newVenta) {
        sql = "INSERT INTO venta(id_venta,id_administrador,fecha_venta) values(?,?,?)";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setInt(1, newVenta.getIdVenta());
            ps.setString(2, newVenta.getIdAdministrador());
            ps.setString(3, newVenta.getFechaVenta());
            ps.execute();
            System.out.println("Venta Agregada");
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } 
    }

    @Override
    public boolean Agregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    public ResultSet getTable(String consulta) {
        ResultSet datos = null;
        try {
            ps = (PreparedStatement) conexion.prepareStatement(consulta);
            datos = ps.executeQuery();
            System.out.println("CONSULTA EXITOSA");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;

    }

    @Override
    public boolean Editar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void GenerarReporte(){
    
    }
    
    

}
