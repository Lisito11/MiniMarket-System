package vista.compras;

import bd_logica.Compra;
import bd_logica.Conexion;
import bd_logica.Venta;
import com.mysql.jdbc.Connection;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.ventas.PantallaVentas;

/**
 *
 * @author Lisito
 */
public class PantallaCompras extends javax.swing.JDialog {

    public PantallaCompras(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarCompras1();
        mostrarCompras2();
    }

    public PantallaCompras() {
    }

    private javax.swing.JLabel background;
    private javax.swing.JLabel background_contado;
    private javax.swing.JButton btn_agregarFacturaContado;
    private javax.swing.JButton btn_agregarFacturaCredito;
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_exportarContado;
    private javax.swing.JButton btn_exportarCredito;
    private javax.swing.JButton btn_buscarFacturasContado;
    private javax.swing.JButton btn_buscarFacturasCredito;
    private javax.swing.JButton btn_exportarFacturaContado;
    private javax.swing.JButton btn_exportarFacturaCredito;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField input_facturaContado;
    private javax.swing.JTextField input_facturaCredito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbton_fechaContado;
    private javax.swing.JRadioButton rbton_fechaCredito;
    private javax.swing.JRadioButton rbton_idContado;
    private javax.swing.JRadioButton rbton_idCredito;
    private javax.swing.JRadioButton rbton_montoContado;
    private javax.swing.JRadioButton rbton_montoCredito;
    private javax.swing.JRadioButton rbton_proveedorContado;
    private javax.swing.JRadioButton rbton_proveedorCredito;
    private javax.swing.JTable tabla_facturasContado;
    private javax.swing.JTable tabla_facturasCredito;
    public DefaultTableModel dtm1;
    public DefaultTableModel dtm2;

    @SuppressWarnings("unchecked")
    private void initComponents() {
        String[] columnNames = {"ID Factura", "Proveedor", "Fecha", "Total"};
        Object[][] datos = {};
        dtm1 = new DefaultTableModel(datos, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] columnNames2 = {"ID Factura", "Proveedor", "Fecha", "Total", "Por Pagar"};
        Object[][] datos2 = {};
        dtm2 = new DefaultTableModel(datos2, columnNames2) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_buscarFacturasContado = new javax.swing.JButton();
        btn_exportarFacturaContado = new javax.swing.JButton();
        input_facturaContado = new javax.swing.JTextField();
        rbton_proveedorContado = new javax.swing.JRadioButton();
        rbton_fechaContado = new javax.swing.JRadioButton();
        rbton_idContado = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        btn_agregarFacturaContado = new javax.swing.JButton();
        rbton_montoContado = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_facturasContado = new JTable(dtm1);
        btn_exportarContado = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        background_contado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_facturasCredito = new JTable(dtm2);
        btn_agregarFacturaCredito = new javax.swing.JButton();
        btn_exportarFacturaCredito = new javax.swing.JButton();
        btn_buscarFacturasCredito = new javax.swing.JButton();
        input_facturaCredito = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rbton_proveedorCredito = new javax.swing.JRadioButton();
        rbton_montoCredito = new javax.swing.JRadioButton();
        rbton_fechaCredito = new javax.swing.JRadioButton();
        rbton_idCredito = new javax.swing.JRadioButton();
        btn_exportarCredito = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rbton_proveedorContado);
        buttonGroup1.add(rbton_fechaContado);
        buttonGroup1.add(rbton_idContado);
        buttonGroup1.add(rbton_montoContado);

        buttonGroup2.add(rbton_proveedorCredito);
        buttonGroup2.add(rbton_fechaCredito);
        buttonGroup2.add(rbton_idCredito);
        buttonGroup2.add(rbton_montoCredito);

        rbton_proveedorContado.addActionListener(this::ordernarPor);
        rbton_fechaContado.addActionListener(this::ordernarPor);
        rbton_idContado.addActionListener(this::ordernarPor);
        rbton_montoContado.addActionListener(this::ordernarPor);

        rbton_proveedorCredito.addActionListener(this::ordernarPor);
        rbton_fechaCredito.addActionListener(this::ordernarPor);
        rbton_idCredito.addActionListener(this::ordernarPor);
        rbton_montoCredito.addActionListener(this::ordernarPor);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Facturas al contado");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        btn_buscarFacturasContado.setBackground(new java.awt.Color(102, 102, 0));
        btn_buscarFacturasContado.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_buscarFacturasContado.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscarFacturasContado.setText("Buscar");
        btn_buscarFacturasContado.setFocusPainted(false);
        btn_buscarFacturasContado.addActionListener(this::btn_buscarFacturasContado);
        jPanel1.add(btn_buscarFacturasContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 77, -1));

        btn_exportarFacturaContado.setBackground(new java.awt.Color(0, 102, 153));
        btn_exportarFacturaContado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_exportarFacturaContado.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportarFacturaContado.setText("Exportar una Factura");
        btn_exportarFacturaContado.setFocusPainted(false);
        btn_exportarFacturaContado.addActionListener(this::btn_exportarUnaCompra);

        jPanel1.add(btn_exportarFacturaContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 280, -1));
        jPanel1.add(input_facturaContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 130, 30));

        rbton_proveedorContado.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        rbton_proveedorContado.setForeground(new java.awt.Color(255, 255, 255));
        rbton_proveedorContado.setText("Por proveedor");
        jPanel1.add(rbton_proveedorContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 170, 30));

        rbton_fechaContado.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        rbton_fechaContado.setForeground(new java.awt.Color(255, 255, 255));
        rbton_fechaContado.setText("Por fecha");
        jPanel1.add(rbton_fechaContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 170, 30));

        rbton_idContado.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        rbton_idContado.setForeground(new java.awt.Color(255, 255, 255));
        rbton_idContado.setText("Por ID");
        jPanel1.add(rbton_idContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 170, 30));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ordenar Facturas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 180, 20));

        btn_agregarFacturaContado.setBackground(new java.awt.Color(0, 102, 153));
        btn_agregarFacturaContado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_agregarFacturaContado.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregarFacturaContado.setText("Agregar Factura");
        btn_agregarFacturaContado.setFocusPainted(false);
        btn_agregarFacturaContado.addActionListener(this::btn_AgregarFacturaContado);

        jPanel1.add(btn_agregarFacturaContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 270, -1));

        rbton_montoContado.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        rbton_montoContado.setForeground(new java.awt.Color(255, 255, 255));
        rbton_montoContado.setText("Por monto");
        jPanel1.add(rbton_montoContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 170, 30));

        tabla_facturasContado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabla_facturasContado.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla_facturasContado);
        if (tabla_facturasContado.getColumnModel().getColumnCount() > 0) {
            tabla_facturasContado.getColumnModel().getColumn(0).setResizable(false);
            tabla_facturasContado.getColumnModel().getColumn(1).setResizable(false);
            tabla_facturasContado.getColumnModel().getColumn(2).setResizable(false);
            tabla_facturasContado.getColumnModel().getColumn(3).setResizable(false);
        }
        tabla_facturasContado.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int fila = tabla_facturasContado.getSelectedRow();
                    if (fila >= 0) {
                        int input = JOptionPane.showConfirmDialog(null, "¿Desea exportar la compra?", "Exportar Comprar", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (input == 0) {
                            tabla_facturasContado.getSelectedRow();
                            String id = String.valueOf(dtm1.getValueAt(tabla_facturasContado.getSelectedRow(), 0));
                            exportarCompra(id, "compra");
                        }
                    }
                }
            }
        });
        tabla_facturasContado.getColumnModel().getColumn(0).setPreferredWidth(30);
        tabla_facturasContado.getColumnModel().getColumn(3).setPreferredWidth(30);
        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 560, 200));

        btn_exportarContado.setBackground(new java.awt.Color(102, 102, 0));
        btn_exportarContado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_exportarContado.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportarContado.setText("Exportar Facturas");
        btn_exportarContado.setFocusPainted(false);
        btn_exportarContado.addActionListener(this::btn_exportarAllCompras);
        jPanel1.add(btn_exportarContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 200, -1));

        btn_atras.setBackground(new java.awt.Color(255, 0, 51));
        btn_atras.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_atras.setForeground(new java.awt.Color(255, 255, 255));
        btn_atras.setText("Atras");
        btn_atras.setFocusPainted(false);
        btn_atras.addActionListener(this::btn_atrasActionPerformed);
        jPanel1.add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        background_contado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        jPanel1.add(background_contado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 290));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 795, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Facturas a crédito");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        tabla_facturasCredito.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tabla_facturasCredito.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabla_facturasCredito);

        if (tabla_facturasCredito.getColumnModel().getColumnCount() > 0) {
            tabla_facturasCredito.getColumnModel().getColumn(0).setResizable(false);
            tabla_facturasCredito.getColumnModel().getColumn(1).setResizable(false);
            tabla_facturasCredito.getColumnModel().getColumn(2).setResizable(false);
            tabla_facturasCredito.getColumnModel().getColumn(3).setResizable(false);
            tabla_facturasCredito.getColumnModel().getColumn(4).setResizable(false);

        }
        tabla_facturasCredito.getColumnModel().getColumn(0).setPreferredWidth(30);
        tabla_facturasCredito.getColumnModel().getColumn(3).setPreferredWidth(30);
        tabla_facturasCredito.getColumnModel().getColumn(2).setPreferredWidth(30);
        tabla_facturasCredito.getColumnModel().getColumn(4).setPreferredWidth(30);

        tabla_facturasCredito.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    System.out.println("Se ha hecho doble click");
                    int fila = tabla_facturasCredito.getSelectedRow();
                    if (fila >= 0) {
                        opcionesCompra();
                    }
                }
            }
        });
        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 560, 210));

        btn_agregarFacturaCredito.setBackground(new java.awt.Color(0, 102, 153));
        btn_agregarFacturaCredito.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_agregarFacturaCredito.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregarFacturaCredito.setText("Agregar Factura");
        btn_agregarFacturaCredito.setFocusPainted(false);
        btn_agregarFacturaCredito.addActionListener(this::btn_agregarFacturaCredito);

        jPanel2.add(btn_agregarFacturaCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 270, -1));

        btn_exportarFacturaCredito.setBackground(new java.awt.Color(0, 102, 153));
        btn_exportarFacturaCredito.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_exportarFacturaCredito.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportarFacturaCredito.setText("Exportar una Factura");
        btn_exportarFacturaCredito.setFocusPainted(false);
        btn_exportarFacturaCredito.addActionListener(this::btn_exportarCredito);

        jPanel2.add(btn_exportarFacturaCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 280, -1));

        btn_buscarFacturasCredito.setBackground(new java.awt.Color(102, 102, 0));
        btn_buscarFacturasCredito.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_buscarFacturasCredito.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscarFacturasCredito.setText("Buscar");
        btn_buscarFacturasCredito.setFocusPainted(false);
        btn_buscarFacturasCredito.addActionListener(this::btn_buscarFacturasCredito);

        jPanel2.add(btn_buscarFacturasCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, -1, -1));
        jPanel2.add(input_facturaCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 130, 30));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ordenar Facturas");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, -1, -1));

        rbton_proveedorCredito.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        rbton_proveedorCredito.setForeground(new java.awt.Color(255, 255, 255));
        rbton_proveedorCredito.setText("Por proveedor");
        jPanel2.add(rbton_proveedorCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 150, 30));

        rbton_montoCredito.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        rbton_montoCredito.setForeground(new java.awt.Color(255, 255, 255));
        rbton_montoCredito.setText("Por monto");
        jPanel2.add(rbton_montoCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 150, 30));

        rbton_fechaCredito.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        rbton_fechaCredito.setForeground(new java.awt.Color(255, 255, 255));
        rbton_fechaCredito.setText("Por fecha");
        jPanel2.add(rbton_fechaCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 150, 30));

        rbton_idCredito.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        rbton_idCredito.setForeground(new java.awt.Color(255, 255, 255));
        rbton_idCredito.setText("Por ID");
        jPanel2.add(rbton_idCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 150, 30));

        btn_exportarCredito.setBackground(new java.awt.Color(102, 102, 0));
        btn_exportarCredito.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_exportarCredito.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportarCredito.setText("Exportar Facturas");
        btn_exportarCredito.setFocusPainted(false);
        btn_exportarCredito.addActionListener(this::btn_exportarAllCredito);
        jPanel2.add(btn_exportarCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 200, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 310));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 337, 795, 302));

        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("© 2020 Colmado El Viejillo. Todos los derechos reservados. ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 640, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-9, -4, 820, 665));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();

    }
// Metodo - Exportar Venta

    private void btn_exportarUnaCompra(ActionEvent e) {
        int fila = tabla_facturasContado.getSelectedRow();
        if (fila >= 0) {
            int input = JOptionPane.showConfirmDialog(null, "¿Desea exportar la compra?", "Exportar Comprar", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (input == 0) {
                String id = String.valueOf(dtm1.getValueAt(tabla_facturasContado.getSelectedRow(), 0));
                exportarCompra(id, "compra");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una Compra para Exportar");
        }

    }

    // Metodo - Exportar Todas Las Ventas 
    private void btn_exportarAllCompras(ActionEvent e) {
        int input = JOptionPane.showConfirmDialog(null, "¿Desea exportar todas las Compras?", "Exportar Compras", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (input == 0) {
            exportarAllCompras("allCompras");
        }
    }

    private void btn_buscarFacturasContado(ActionEvent e) {
        btn_buscarCompras(input_facturaContado, tabla_facturasContado);
    }

    private void btn_buscarFacturasCredito(ActionEvent e) {
        btn_buscarCompras(input_facturaCredito, tabla_facturasCredito);
    }

    private void btn_atrasActionPerformed(ActionEvent e) {
        setVisible(false);
    }

    private void btn_AgregarFacturaContado(ActionEvent e) {
        int input = JOptionPane.showConfirmDialog(null, "¿Desea agregar una Factura?", "Agregar Factura", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (input == 0) {
            AgregarFactura af = new AgregarFactura(new PantallaCompras(), true);
            af.setVisible(true);
        }
    }

    private void btn_agregarFacturaCredito(ActionEvent e) {
        int input = JOptionPane.showConfirmDialog(null, "¿Desea agregar una Factura?", "Agregar Factura", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (input == 0) {
            AgregarFactura_Credito af = new AgregarFactura_Credito(new PantallaCompras(), true);
            af.setVisible(true);
        }
    }

    private void mostrarCompras1() {
        Compra c = new Compra();
        ResultSet rs = c.getTable("select c.id_compra, p.nombreEmpresa,c.fecha_compra, c.total_costo from compra c inner join proveedor p on p.id_proveedor = c.id_proveedor where c.Por_pagar is null");
        try {
            while (rs.next()) {
                dtm1.addRow(new Object[]{rs.getString("c.id_compra"), rs.getString("p.nombreEmpresa"), rs.getString("c.fecha_compra"), rs.getString("c.total_costo")});

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void mostrarCompras2() {
        Compra c = new Compra();
        ResultSet rs = c.getTable("select c.id_compra, p.nombreEmpresa,c.fecha_compra, c.total_costo, c.Por_pagar from compra c inner join proveedor p on p.id_proveedor = c.id_proveedor where c.Por_pagar is not null");
        try {
            while (rs.next()) {
                dtm2.addRow(new Object[]{rs.getString("c.id_compra"), rs.getString("p.nombreEmpresa"), rs.getString("c.fecha_compra"), rs.getString("c.total_costo"), rs.getString("c.Por_pagar")});
            }
        } catch (SQLException e) {
            System.out.println(e);

        }
    }

    private void ordernarPor(ActionEvent e) {

        // Ordenar por Proveedor
        if (rbton_proveedorContado.isSelected() == true) {
            limpiarTabla(dtm1);
            filtrarBusqueda("select c.id_compra, p.nombreEmpresa,c.fecha_compra, c.total_costo from compra c inner join proveedor p on p.id_proveedor = c.id_proveedor where c.Por_pagar is null order by p.nombreEmpresa ASC ", dtm1);
        }

        // Ordenar por Fecha
        if (rbton_fechaContado.isSelected() == true) {
            limpiarTabla(dtm1);
            filtrarBusqueda("select c.id_compra, p.nombreEmpresa,c.fecha_compra, c.total_costo from compra c inner join proveedor p on p.id_proveedor = c.id_proveedor where c.Por_pagar is null order by c.fecha_compra ASC ", dtm1);
        }

        // Ordenar por id
        if (rbton_idContado.isSelected() == true) {
            limpiarTabla(dtm1);
            filtrarBusqueda("select c.id_compra, p.nombreEmpresa,c.fecha_compra, c.total_costo from compra c inner join proveedor p on p.id_proveedor = c.id_proveedor where c.Por_pagar is null order by c.id_compra ASC", dtm1);
        }

        // Ordenar Costo
        if (rbton_montoContado.isSelected() == true) {
            limpiarTabla(dtm1);
            filtrarBusqueda("select c.id_compra, p.nombreEmpresa,c.fecha_compra, c.total_costo from compra c inner join proveedor p on p.id_proveedor = c.id_proveedor where c.Por_pagar is null order by c.total_costo DESC", dtm1);
        }

        //Facturas a credito
        // Ordenar por Proveedor
        if (rbton_proveedorCredito.isSelected() == true) {
            limpiarTabla(dtm2);
            filtrarBusqueda("select c.id_compra, p.nombreEmpresa,c.fecha_compra, c.total_costo, c.Por_pagar from compra c inner join proveedor p on p.id_proveedor = c.id_proveedor where c.Por_pagar is not null order by p.nombreEmpresa ASC ", dtm2);
        }

        // Ordenar por Fecha
        if (rbton_fechaCredito.isSelected() == true) {
            limpiarTabla(dtm2);
            filtrarBusqueda("select c.id_compra, p.nombreEmpresa,c.fecha_compra, c.total_costo, c.Por_pagar from compra c inner join proveedor p on p.id_proveedor = c.id_proveedor where c.Por_pagar is not null order by c.fecha_compra ASC", dtm2);
        }

        // Ordenar por id
        if (rbton_idCredito.isSelected() == true) {
            limpiarTabla(dtm2);
            filtrarBusqueda("select c.id_compra, p.nombreEmpresa,c.fecha_compra, c.total_costo, c.Por_pagar from compra c inner join proveedor p on p.id_proveedor = c.id_proveedor where c.Por_pagar is not null order by c.id_compra ASC", dtm2);
        }

        // Ordenar Costo
        if (rbton_montoCredito.isSelected() == true) {
            limpiarTabla(dtm2);
            filtrarBusqueda("select c.id_compra, p.nombreEmpresa,c.fecha_compra, c.total_costo, c.Por_pagar from compra c inner join proveedor p on p.id_proveedor = c.id_proveedor where c.Por_pagar is not null order by c.total_costo DESC ", dtm2);
        }
    }

    private void filtrarBusqueda(String filtro, DefaultTableModel dtm) {
        Venta v = new Venta();
        ResultSet rs = v.getTable(filtro);
        try {
            while (rs.next()) {
                if (dtm == dtm2) {
                    dtm.addRow(new Object[]{rs.getString("c.id_compra"), rs.getString("p.nombreEmpresa"), rs.getString("c.fecha_compra"), rs.getString("c.total_costo"), rs.getString("c.Por_pagar")});

                } else {
                    dtm.addRow(new Object[]{rs.getString("c.id_compra"), rs.getString("p.nombreEmpresa"), rs.getString("c.fecha_compra"), rs.getString("c.total_costo")});
                }
            }
        } catch (SQLException c) {
        }
    }

    private void limpiarTabla(DefaultTableModel dtm) {
        int a = dtm.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            dtm.removeRow(i);
        }
    }

    private void btn_buscarCompras(JTextField factura, JTable tabla) {
        boolean bandera = true;
        String busqueda = factura.getText();
        if (busqueda.equals("")) {
            JOptionPane.showMessageDialog(null, "Introducir Fecha o ID de la Compra");
        } else {
            //Seleccionar la fila dentro del jtable1
            for (int i = 0; i < tabla.getRowCount(); i++) {

                //Buscamos por Fecha Venta
                if (String.valueOf(tabla.getValueAt(i, 2)).trim().equals(busqueda)) {
                    tabla.changeSelection(i, 1, false, false);
                    bandera = true;

                    factura.setText("");
                    break;

                } //Buscamos por ID venta
                else if (String.valueOf(tabla.getValueAt(i, 0)).trim().equals(busqueda)) {
                    tabla.changeSelection(i, 0, false, false);
                    bandera = true;

                    factura.setText("");
                    break;
                }
                bandera = false;
            }
            if (!bandera) {
                JOptionPane.showMessageDialog(null, "Esta Compra no existe");
            }
        }
    }

    private void exportarAllCompras(String factura) {
        try {
            Conexion con = new Conexion();
            Connection conn = (Connection) con.getConection();
            String nombreReporte = factura + ".jasper";
            String path = "src/reportes/" + nombreReporte;
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn);
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(PantallaCompras.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    private void exportarCompra(String idCompra, String factura) {
        try {
            Conexion con = new Conexion();
            Connection conn = (Connection) con.getConection();
            String nombreReporte = factura + ".jasper";
            String path = "src/reportes/" + nombreReporte;
            JasperReport reporte = null;
            Map parametro = new HashMap();
            parametro.put("id_compra", Integer.parseInt(idCompra));
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn);
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(PantallaCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void opcionesCompra() {
        String[] opciones = {"Ver", "Pagar"};
        int op = JOptionPane.showOptionDialog(
                null //componente
                ,
                 "¿Que quieres hacer con la Factura?" // Mensaje
                ,
                 "Compra" // Titulo en la barra del cuadro
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
                verCompra();
                break;
            case "Pagar":
                pagarCompra();
                break;
            default:
                break;
        }
    }

    private void verCompra() {
        String id = String.valueOf(dtm2.getValueAt(tabla_facturasCredito.getSelectedRow(), 0));
        exportarCompra(id, "compraCredito");
    }

    private void pagarCompra() {
        Compra c = new Compra();
        String id = String.valueOf(dtm2.getValueAt(tabla_facturasCredito.getSelectedRow(), 0));
        c.setIdCompra(Integer.parseInt(id));
        String porPagar = String.valueOf(dtm2.getValueAt(tabla_facturasCredito.getSelectedRow(), 4));
        String pago = JOptionPane.showInputDialog(null, "Pagar la Cuenta", porPagar);
        
        while (pago.equals("") || !isDecimal(pago) || Double.parseDouble(pago) > Double.parseDouble(porPagar) || Double.parseDouble(pago) < 0) {
            JOptionPane.showMessageDialog(null, "Introduce un pago correcto");
            pago = JOptionPane.showInputDialog("Pagar: " + porPagar, porPagar);
        }
        int input = JOptionPane.showConfirmDialog(null, "¿Desea Realizar el pago?", "Pagar Factura", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (input == 0) {
            c.PagarFacturaCredito(pago);
        }
    }
    
    private static boolean isDecimal(String cadena) {
        String patron = "^[0-9]+([.][0-9]+)?$";
        Pattern pat = Pattern.compile(patron);
        Matcher mat = pat.matcher(cadena);

        return mat.matches();

    }

    private void btn_exportarAllCredito(ActionEvent e) {
        int input = JOptionPane.showConfirmDialog(null, "¿Desea exportar todas las Compras?", "Exportar Compras", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (input == 0) {
            exportarAllCompras("compraAllCredito");
        }
    }

    private void btn_exportarCredito(ActionEvent e) {
        int fila = tabla_facturasCredito.getSelectedRow();
        if (fila >= 0) {
            int input = JOptionPane.showConfirmDialog(null, "¿Desea exportar la compra?", "Exportar Comprar", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (input == 0) {
                String id = String.valueOf(dtm2.getValueAt(tabla_facturasCredito.getSelectedRow(), 0));
                exportarCompra(id, "compraCredito");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una Compra para Exportar");
        }
    }

}
