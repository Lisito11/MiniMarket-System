package vista.ventas;

/**
 *
 * @author Lisito
 */
import bd_logica.Conexion;
import bd_logica.DetalleVenta;
import bd_logica.Venta;
import com.mysql.jdbc.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class PantallaVentas extends javax.swing.JDialog {

    public PantallaVentas(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarVentas();
    }

    public PantallaVentas() {
    }
    private ArrayList<String> total_vendido;
    private ArrayList<String> cantidad_vendida;
    private ArrayList<String> producto;

    public static String idVenta = "";
    private javax.swing.JLabel backgroud;
    public javax.swing.JButton btn_agregarVenta;
    private javax.swing.JButton btn_atras;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton btn_exportarAllVentas;
    private javax.swing.JButton btn_exportarUnaVenta;
    private javax.swing.JButton btn_buscarVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButton jrb_costoVenta;
    private javax.swing.JRadioButton jrb_fecha;
    private javax.swing.JRadioButton jrb_totalVenta;
    private javax.swing.JRadioButton jrb_gananciaVenta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> jcmbox_topProductos;
    public DefaultTableModel dtm;

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
        btn_exportarAllVentas = new javax.swing.JButton();
        btn_exportarUnaVenta = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jrb_costoVenta = new javax.swing.JRadioButton();
        jrb_fecha = new javax.swing.JRadioButton();
        jrb_totalVenta = new javax.swing.JRadioButton();
        btn_buscarVenta = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jcmbox_topProductos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jrb_gananciaVenta = new javax.swing.JRadioButton();
        backgroud = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        buttonGroup1.add(jrb_fecha);
        buttonGroup1.add(jrb_costoVenta);
        buttonGroup1.add(jrb_totalVenta);
        buttonGroup1.add(jrb_gananciaVenta);

        jrb_fecha.addActionListener(this::ordernarPor);
        jrb_costoVenta.addActionListener(this::ordernarPor);
        jrb_totalVenta.addActionListener(this::ordernarPor);
        jrb_gananciaVenta.addActionListener(this::ordernarPor);

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
        btn_agregarVenta.addActionListener(this::btn_agregarVenta);

        getContentPane().add(btn_agregarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 170, -1));

        btn_exportarAllVentas.setBackground(new java.awt.Color(0, 102, 153));
        btn_exportarAllVentas.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_exportarAllVentas.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportarAllVentas.setText("Exportar todas las Ventas");
        btn_exportarAllVentas.setFocusPainted(false);
        btn_exportarAllVentas.addActionListener(this::btn_exportarAllVentas);
        getContentPane().add(btn_exportarAllVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 210, -1));

        btn_exportarUnaVenta.setBackground(new java.awt.Color(0, 102, 153));
        btn_exportarUnaVenta.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_exportarUnaVenta.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportarUnaVenta.setText("Exportar una Venta");
        btn_exportarUnaVenta.setFocusPainted(false);
        btn_exportarUnaVenta.addActionListener(this::btn_exportarUnaVenta);
        getContentPane().add(btn_exportarUnaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, -1, -1));

        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("© 2020 Colmado El Viejillo. Todos los derechos reservados. ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 560, -1, -1));

        jrb_costoVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jrb_costoVenta.setForeground(new java.awt.Color(255, 255, 255));
        jrb_costoVenta.setText("Por Costo Venta");
        getContentPane().add(jrb_costoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, -1, 30));

        jrb_fecha.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jrb_fecha.setForeground(new java.awt.Color(255, 255, 255));
        jrb_fecha.setText("Por Fecha");
        getContentPane().add(jrb_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, -1, 30));

        jrb_totalVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jrb_totalVenta.setForeground(new java.awt.Color(255, 255, 255));
        jrb_totalVenta.setText("Por Total Venta");
        getContentPane().add(jrb_totalVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, -1, 30));

        btn_buscarVenta.setBackground(new java.awt.Color(102, 102, 0));
        btn_buscarVenta.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_buscarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscarVenta.setText("Buscar");
        btn_buscarVenta.setFocusPainted(false);
        btn_buscarVenta.addActionListener(this::btn_buscarVenta);

        getContentPane().add(btn_buscarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        jTextField1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 190, 30));
        mostrarProductos();

        jcmbox_topProductos.addItemListener(this::jcmbox_topProductos);
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

        jrb_gananciaVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jrb_gananciaVenta.setForeground(new java.awt.Color(255, 255, 255));
        jrb_gananciaVenta.setText("Ganancias Venta");
        getContentPane().add(jrb_gananciaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, -1, -1));

        backgroud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        getContentPane().add(backgroud, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 580));

        jMenu1.setText("Inicio");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ventas");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);
        pack();
    }

//------------------------------------------------------------------------------    
    /* Acciones de los botones principales
    *  
    *  Agregar Venta
    *  Exportar una Venta 
    *  Exportar todas las Ventas
    *  Regresar al Menu Principal
    *
     */
    // Metodo - Agregar Venta
    private void btn_agregarVenta(ActionEvent e) {
        int input = JOptionPane.showConfirmDialog(null, "¿Desea agregar una venta?", "Agregar Venta", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (input == 0) {
            FormVenta fv = new FormVenta(new PantallaVentas(), true);
            fv.setVisible(true);
        }
    }

    // Metodo - Exportar Venta
    private void btn_exportarUnaVenta(ActionEvent e) {
        int fila = jTable1.getSelectedRow();
        if (fila >= 0) {
            int input = JOptionPane.showConfirmDialog(null, "¿Desea exportar la venta?", "Exportar Venta", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (input == 0) {
                jTable1.getSelectedRow();
                String id = String.valueOf(dtm.getValueAt(jTable1.getSelectedRow(), 0));
                exportarVenta(id);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una venta para Exportar");
        }

    }

    // Metodo - Exportar Todas Las Ventas 
    private void btn_exportarAllVentas(ActionEvent e) {
        int input = JOptionPane.showConfirmDialog(null, "¿Desea exportar la venta?", "Exportar Venta", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (input == 0) {
            exportarAllVentas();
        }
    }

    // Metodo - Buscar Venta (Por Fecha Venta o ID Venta)
    private void btn_buscarVenta(ActionEvent e) {
        boolean bandera = true;
        String busqueda = jTextField1.getText();
        if (busqueda.equals("")) {
            JOptionPane.showMessageDialog(null, "Introducir Fecha o ID de la venta");
        } else {
            //Seleccionar la fila dentro del jtable1
            for (int i = 0; i < jTable1.getRowCount(); i++) {

                //Buscamos por Fecha Venta
                if (jTable1.getValueAt(i, 1).equals(busqueda)) {
                    jTable1.changeSelection(i, 1, false, false);
                    bandera = true;
                    idVenta = (String) jTable1.getValueAt(i, 0);
                    opcionesVenta(idVenta);
                    jTextField1.setText("");
                    break;

                } //Buscamos por ID venta
                else if (jTable1.getValueAt(i, 0).equals(busqueda)) {
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

    // Metodo - Regresar Menu
    private void btn_atrasActionPerformed(ActionEvent e) {
        dispose();
    }

//------------------------------------------------------------------------------    

    /* Metodos Auxiliares de los botones Principales
     *
     * Auxiliar exportar venta
     * Auxiliar limpiar tabla
     * Auxiliar ver venta
     * Auxiliar editar venta
     * Auxiliar exportar todas las venta
     */
    // Metodo - Auxiliar exportar venta
    private void exportarVenta(String idventa) {
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

    // Metodo - Auxiliar limpiar tabla
    private void limpiarTabla() {
        int a = dtm.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            dtm.removeRow(i);
        }
    }

    // Metodo - Auxiliar ver venta
    private void verVenta() {
        VerVenta vv = new VerVenta(new PantallaVentas(), true);
        vv.setVisible(true);
    }

    // Metodo - Auxiliar editar venta
    private void editarVenta() {
        EditarVenta ev = new EditarVenta(new PantallaVentas(), true);
        ev.setVisible(true);
    }

    // Metodo - Auxiliar exportar todas las venta
    private void exportarAllVentas() {
        try {
            Conexion con = new Conexion();
            Connection conn = (Connection) con.getConection();
            String nombreReporte = "allVentas.jasper";
            String path = "src/reportes/" + nombreReporte;
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn);
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(PantallaVentas.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    //------------------------------------------------------------------------------    
    /* Filtrado de busquedas - Opciones de Facturas - 
    *  
    *  Mostrar todas las ventas
    *  Ordenar facturas
    *  Mostrar Top 5 Productos mas Vendidos
    *  Auxiliar Opciones Venta
    *  Auxiliar filtrar busqueda
    *  Auxiliar mostrarProductos
     */
    // Metodo - Mostrar todas las ventas
    private void mostrarVentas() {
        Venta v = new Venta();
        ResultSet rs = v.getTable("select * from venta");
        try {
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("id_venta"), rs.getString("fecha_venta"), rs.getString("costo_venta"), rs.getString("ganancia_venta"), rs.getString("total_venta")});
            }
        } catch (SQLException e) {
        }
    }

    // Metodo - Ordenar facturas (Por fecha - Por Costo Venta - Por Total Venta - Ganancias Venta)
    private void ordernarPor(ActionEvent e) {

        // Ordenar por fecha
        if (jrb_fecha.isSelected() == true) {
            limpiarTabla();
            filtrarBusqueda("SELECT * from venta order by fecha_venta ASC");
        }

        // Ordenar por costo de la venta
        if (jrb_costoVenta.isSelected() == true) {
            limpiarTabla();
            filtrarBusqueda("SELECT * from venta order by costo_venta DESC");
        }

        // Ordenar por ganancia de la venta
        if (jrb_gananciaVenta.isSelected() == true) {
            limpiarTabla();
            filtrarBusqueda("SELECT * from venta order by ganancia_venta DESC");
        }

        // Ordenar por total de la venta
        if (jrb_totalVenta.isSelected() == true) {
            limpiarTabla();
            filtrarBusqueda("SELECT * from venta order by total_venta DESC");
        }
    }

    //Mostrar Top 5 Productos mas Vendidos
    private void jcmbox_topProductos(ItemEvent itemEvent) {
        if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
            if (jcmbox_topProductos.getItemCount() > 0) {
                String id = itemEvent.getItem().toString();
                int pos = producto.indexOf(id);
                jLabel5.setText("Total vendido: " + total_vendido.get(pos));
                jLabel6.setText("Cantidad vendida: " + cantidad_vendida.get(pos));
            }
        }
    }

    // Metodo - Auxiliar Opciones Venta
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
                exportarVenta(id);
                break;
            default:
                break;
        }
    }

    // Metodo - Auxiliar filtrar busqueda
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

    // Auxiliar mostrarProductos
    private void mostrarProductos() {
        DetalleVenta dv = new DetalleVenta();
        ResultSet rs = dv.TopProductos();

        cantidad_vendida = new ArrayList<>();
        total_vendido = new ArrayList<>();
        producto = new ArrayList<>();

        try {
            while (rs.next()) {
                jcmbox_topProductos.addItem(rs.getString("p.nombre"));
                producto.add(rs.getString("p.nombre"));
                cantidad_vendida.add(String.valueOf(rs.getInt("cantidad_vendida")));
                total_vendido.add(String.valueOf(rs.getDouble("total_vendido")));

            }
        } catch (SQLException e) {
        }
    }
}
