package vista;

import bd_logica.DetalleVenta;
import bd_logica.Venta;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lisito
 */
public class VerVenta extends javax.swing.JFrame {

    DetalleVenta dv = new DetalleVenta();
    String idVenta = PantallaVentas.idVenta;

    public VerVenta() {
        initComponents();
        mostrar();
    }

    private void initComponents() {
        String[] columnNames = {"ID Producto", "Nombre", "Cantidad"};
        Object[][] datos = {};
        dtm = new DefaultTableModel(datos, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jLabel1 = new javax.swing.JLabel();
        btn_VolverAtras = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new JTable(dtm);
        btn_productoMasVendido = new javax.swing.JButton();
        btn_productoMenosVendido = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ver Venta");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 35, -1, -1));

        btn_VolverAtras.setBackground(new java.awt.Color(255, 0, 51));
        btn_VolverAtras.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_VolverAtras.setForeground(new java.awt.Color(255, 255, 255));
        btn_VolverAtras.setText("Volver Atras");
        btn_VolverAtras.addActionListener(this::VolverAtras);
        getContentPane().add(btn_VolverAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 110, -1));

        btn_editar.setBackground(new java.awt.Color(153, 153, 0));
        btn_editar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_editar.setForeground(new java.awt.Color(255, 255, 255));
        btn_editar.setText("Editar Venta");
        btn_editar.addActionListener(this::Editar);
        getContentPane().add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 110, -1));

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);

        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 510, 210));

        btn_productoMasVendido.setBackground(new java.awt.Color(0, 102, 153));
        btn_productoMasVendido.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_productoMasVendido.setForeground(new java.awt.Color(255, 255, 255));
        btn_productoMasVendido.setText("Producto Mas Vendido");
        btn_productoMasVendido.addActionListener(this::BuscarProductoMasVendido);

        getContentPane().add(btn_productoMasVendido, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 180, -1));

        btn_productoMenosVendido.setBackground(new java.awt.Color(0, 102, 153));
        btn_productoMenosVendido.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_productoMenosVendido.setForeground(new java.awt.Color(255, 255, 255));
        btn_productoMenosVendido.setText("Producto Menos Vendido");
        btn_productoMenosVendido.addActionListener(this::BuscarProductoMenosVendido);
        getContentPane().add(btn_productoMenosVendido, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 190, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 360));

        pack();
    }
  private void limpiarTabla() {
        int a = dtm.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            dtm.removeRow(i);
        }
    }
    private void BuscarProductoMasVendido(ActionEvent e) {
        String [] producto = dv.BuscarProductoMasVendido(idVenta);
        JOptionPane.showMessageDialog(null, "Producto: " + producto[1] + "\nID del producto: " + producto[0] + "\nCantidad vendida: " + producto[2], "Producto Mas Vendido",JOptionPane.INFORMATION_MESSAGE);
        
    }

    private void BuscarProductoMenosVendido(ActionEvent e) {
        String [] producto = dv.BuscarProductoMenosVendido(idVenta);
        JOptionPane.showMessageDialog(null, "Producto: " + producto[1] + "\nID del producto: " + producto[0] + "\nCantidad vendida: " + producto[2],"Producto Menos Vendido",JOptionPane.INFORMATION_MESSAGE);
    }

    private void Editar(ActionEvent e) {
        setVisible(false);
        EditarVenta.iniciar();
    }

    private void VolverAtras(ActionEvent e) {
        setVisible(false);
    }

    public void setFila(String a, String b, String c) {
        Object[] newRow = {a, b, c};
        dtm.addRow(newRow);
    }

    public static void iniciar() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new VerVenta().setVisible(true);
        });
    }

    private void mostrar() {
        Venta v = new Venta();
        ResultSet rs = v.getTable("select dv.id_producto, p.nombre, dv.cantidad from detalle_venta dv inner join producto p on dv.id_producto = p.id_producto where id_venta =" + idVenta);
        try {
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("dv.id_producto"), rs.getString("p.nombre"), rs.getString("dv.cantidad")});
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    // Variables declaration - do not modify                     
    public javax.swing.JButton btn_productoMasVendido;
    public javax.swing.JButton btn_VolverAtras;
    public javax.swing.JButton btn_editar;

    public javax.swing.JButton btn_productoMenosVendido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public DefaultTableModel dtm;
    // End of variables declaration                   
}
