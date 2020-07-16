package vista.ventas;

import bd_logica.Conexion;
import vista.ventas.VerVenta;
import bd_logica.Venta;
import com.mysql.jdbc.Connection;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.PantallaPrincipal;

/**
 *
 * @author Lisito
 */
public class PantallaVentas extends javax.swing.JFrame {

    public PantallaVentas() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        mostrar();
    }
    public static String idVenta = "";

    @SuppressWarnings("unchecked")
    private void initComponents() {
        String[] columnNames = {"ID Venta", "Fecha ", "Costo venta", "Ganancias venta", "Total venta"};
        Object[][] datos = {};
        dtm = new DefaultTableModel(datos, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new JTable(dtm);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_atras = new javax.swing.JButton();
        btn_agregarVenta = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jcmbox_topProductos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        backgroud = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    System.out.println("Se ha hecho doble click");
                    int fila = jTable1.getSelectedRow();
                    if (fila >= 0) {
                        idVenta = String.valueOf(jTable1.getValueAt(fila, 0));
                        opcionesVenta(idVenta);

                    }
                }
            }
        });

        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
        buttonGroup1.add(jRadioButton4);

        jRadioButton2.addActionListener(this::ordernarPor);
        jRadioButton1.addActionListener(this::ordernarPor);
        jRadioButton3.addActionListener(this::ordernarPor);
        jRadioButton4.addActionListener(this::ordernarPor);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 560, 350));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ordenar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 110, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Facturas de Venta");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        btn_atras.setBackground(new java.awt.Color(255, 0, 51));
        btn_atras.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_atras.setForeground(new java.awt.Color(255, 255, 255));
        btn_atras.setText("Atras");
        btn_atras.setFocusPainted(false);
        btn_atras.addActionListener((java.awt.event.ActionEvent evt) -> {
            btn_atrasActionPerformed(evt);
        });
        getContentPane().add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        btn_agregarVenta.setBackground(new java.awt.Color(0, 102, 153));
        btn_agregarVenta.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_agregarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregarVenta.setText("Agregar Venta");
        btn_agregarVenta.setFocusPainted(false);
        btn_agregarVenta.addActionListener((java.awt.event.ActionEvent evt) -> {
            btn_agregarVentaActionPerformed(evt);
        });

        getContentPane().add(btn_agregarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 170, -1));

        jButton3.setBackground(new java.awt.Color(0, 102, 153));
        jButton3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Exportar todas las Ventas");
        jButton3.setFocusPainted(false);
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 210, -1));

        jButton4.setBackground(new java.awt.Color(0, 102, 153));
        jButton4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Exportar una Venta");
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(this::jButton4ActionPerformed);
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, -1, -1));

        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("© 2020 Colmado El Viejillo. Todos los derechos reservados. ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 560, -1, -1));

        jRadioButton1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Por Costo Venta");
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, -1, 30));

        jRadioButton2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Por Fecha");
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, -1, 30));

        jRadioButton3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("Por Total Venta");
        getContentPane().add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, -1, 30));

        jButton5.setBackground(new java.awt.Color(102, 102, 0));
        jButton5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Buscar");
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(this::buscarPorFecha);

        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        jTextField1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 190, 30));

        jcmbox_topProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jcmbox_topProductos.addActionListener(this::jcmbox_topProductosActionPerformed);
        getContentPane().add(jcmbox_topProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 140, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Top 5 Productos");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total vendido: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, -1, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cantidad vendida:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, -1, -1));

        jRadioButton4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("Ganancias Venta");
        getContentPane().add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, -1, -1));

        backgroud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        getContentPane().add(backgroud, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 580));

        jMenu1.setText("Inicio");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ventas");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }

    private void ExportarVenta(String idventa) {
        try {
            Conexion con = new Conexion();
            Connection conn = (Connection) con.getConection();
            String nombreReporte = "venta.jasper";
            String path = "src/reportes/" + nombreReporte;
            JasperReport reporte = null;
            Map parametro = new HashMap();
            parametro.put("id_venta", Integer.parseInt(idventa));
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn);
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(PantallaVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Generar Reporte de una Venta
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int fila = jTable1.getSelectedRow();
        if (fila >= 0) {
            int input = JOptionPane.showConfirmDialog(null, "¿Desea exportar la venta?", "Exportar Venta", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (input == 0) {
                jTable1.getSelectedRow();
                String id = String.valueOf(dtm.getValueAt(jTable1.getSelectedRow(), 0));
                ExportarVenta(id);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una venta para Exportar");
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jcmbox_topProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbox_topProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmbox_topProductosActionPerformed

    private void btn_agregarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarVentaActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "¿Desea agregar una venta?", "Agregar Venta", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (input == 0) {
            setVisible(false);
            FormVenta.iniciar();
        }
        // 0=yes, 1=no, 2=cancel


    }//GEN-LAST:event_btn_agregarVentaActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        setVisible(false);
        PantallaPrincipal pp = new PantallaPrincipal();
        pp.setVisible(true);

        // PantallaPrincipal.iniciar();
    }//GEN-LAST:event_btn_atrasActionPerformed

    public static void iniciar() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new PantallaVentas().setVisible(true);
        });
    }

    private void mostrar() {
        Venta v = new Venta();
        ResultSet rs = v.getTable("select * from venta");
        try {
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("id_venta"), rs.getString("fecha_venta"), rs.getString("costo_venta"), rs.getString("ganancia_venta"), rs.getString("total_venta")});
            }
        } catch (SQLException e) {
        }
    }

    private javax.swing.JLabel backgroud;
    public javax.swing.JButton btn_agregarVenta;
    private javax.swing.JButton btn_atras;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> jcmbox_topProductos;
    public DefaultTableModel dtm;

    //Consulta para vaciar los datos de la tabla
    private void limpiarTabla() {
        int a = dtm.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            dtm.removeRow(i);
        }
    }

    private void filtrarBusqueda(String filtro) {
        Venta v = new Venta();
        ResultSet rs = v.getTable(filtro);
        try {
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("id_venta"), rs.getString("fecha_venta"), rs.getString("costo_venta"), rs.getString("ganancia_venta"), rs.getString("total_venta")});
            }
        } catch (SQLException c) {
        }
    }
    //Filtrado de busquedas

    // Ordenar por fecha
    private void ordernarPor(ActionEvent e) {

        // Ordenar por fecha
        if (jRadioButton2.isSelected() == true) {
            limpiarTabla();

            filtrarBusqueda("SELECT * from venta order by fecha_venta ASC");
        }

        // Ordenar por costo de la venta
        if (jRadioButton1.isSelected() == true) {
            limpiarTabla();

            filtrarBusqueda("SELECT * from venta order by costo_venta DESC");
        }

        // Ordenar por ganancia de la venta
        if (jRadioButton3.isSelected() == true) {
            limpiarTabla();

            filtrarBusqueda("SELECT * from venta order by ganancia_venta DESC");
        }

        // Ordenar por total de la venta
        if (jRadioButton4.isSelected() == true) {
            limpiarTabla();

            filtrarBusqueda("SELECT * from venta order by total_venta DESC");
        }
    }

    private void buscarPorFecha(ActionEvent e) {
        boolean bandera = true;
        String busqueda = jTextField1.getText();
        if (busqueda.equals("")) {
            JOptionPane.showMessageDialog(null, "Introducir Fecha o ID de la venta");
        } else {
            //Seleccionar la fila dentro del jtable1
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                if (jTable1.getValueAt(i, 1).equals(busqueda)) {
                    jTable1.changeSelection(i, 1, false, false);
                    bandera = true;
                    idVenta = (String) jTable1.getValueAt(i, 0);
                    opcionesVenta(idVenta);
                    jTextField1.setText("");

                    break;
                } else if (jTable1.getValueAt(i, 0).equals(busqueda)) {
                    jTable1.changeSelection(i, 0, false, false);
                    bandera = true;
                    idVenta = (String) jTable1.getValueAt(i, 0);
                    opcionesVenta(idVenta);
                    jTextField1.setText("");
                    break;
                }

                bandera = false;
            }
            if (!bandera) {
                JOptionPane.showMessageDialog(null, "Esta venta no existe");
            }
        }
    }

    private void verVenta() {
        VerVenta vv = new VerVenta();
        vv.setVisible(true);
    }

    private void editarVenta() {
        EditarVenta.iniciar();
    }

  

    private void exportarAllVentas() {
    }

    private void opcionesVenta(String idVenta) {
        String[] opciones = {"Ver", "Editar", "Exportar"};
        int op = JOptionPane.showOptionDialog(
                null //componente
                ,
                 "¿Que quieres hacer con la venta?" // Mensaje
                ,
                 "Venta " + idVenta // Titulo en la barra del cuadro
                ,
                 JOptionPane.DEFAULT_OPTION // Tipo de opciones
                ,
                 JOptionPane.INFORMATION_MESSAGE // Tipo de mensaje (icono)
                ,
                 null // Icono (ninguno)
                ,
                 opciones // Opciones personalizadas
                ,
                 null // Opcion por defecto
        );

        String opcion = opciones[op];
        switch (opcion) {
            case "Ver":
                verVenta();
                break;
            case "Editar":
                editarVenta();
                break;
            case "Exportar":
                jTable1.getSelectedRow();
                String id = String.valueOf(dtm.getValueAt(jTable1.getSelectedRow(), 0));
                ExportarVenta(id);
                break;
            default:
                break;
        }
    }

}
