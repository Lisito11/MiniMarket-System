package vista.productos;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lisito
 */
public class PantallaProductos extends javax.swing.JDialog {

    public PantallaProductos(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    public PantallaProductos() {
    }
    private javax.swing.JLabel background;
    public javax.swing.JButton btn_agregarProducto;
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_exportarProductos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField input_buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtn_ordenarCantidad;
    private javax.swing.JRadioButton rbtn_ordenarCategoria;
    private javax.swing.JRadioButton rbtn_ordenarGanancias;
    private javax.swing.JRadioButton rbtn_ordenarNombre;
    private javax.swing.JRadioButton rbtn_ordenarPrecioCompra;
    private javax.swing.JRadioButton rbtn_ordenarPrecioVenta;
    private javax.swing.JTable tabla_listaProductos;
    public DefaultTableModel dtm;

    @SuppressWarnings("unchecked")
    private void initComponents() {
        String[] columnNames = {"ID Producto", "Nombre ", "Categoria", "Cantidad", "Costo", "Venta", "Ganancia"};
        Object[][] datos = {};
        dtm = new DefaultTableModel(datos, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_listaProductos = new JTable(dtm);
        btn_agregarProducto = new javax.swing.JButton();
        input_buscar = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        btn_exportarProductos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_atras = new javax.swing.JButton();
        rbtn_ordenarCategoria = new javax.swing.JRadioButton();
        rbtn_ordenarCantidad = new javax.swing.JRadioButton();
        rbtn_ordenarPrecioCompra = new javax.swing.JRadioButton();
        rbtn_ordenarGanancias = new javax.swing.JRadioButton();
        rbtn_ordenarPrecioVenta = new javax.swing.JRadioButton();
        rbtn_ordenarNombre = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_listaProductos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabla_listaProductos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N 
        tabla_listaProductos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla_listaProductos);
        if (tabla_listaProductos.getColumnModel().getColumnCount() > 0) {
            tabla_listaProductos.getColumnModel().getColumn(0).setResizable(false);
            tabla_listaProductos.getColumnModel().getColumn(1).setResizable(false);
            tabla_listaProductos.getColumnModel().getColumn(2).setResizable(false);
            tabla_listaProductos.getColumnModel().getColumn(3).setResizable(false);
            tabla_listaProductos.getColumnModel().getColumn(4).setResizable(false);
            tabla_listaProductos.getColumnModel().getColumn(5).setResizable(false);
            tabla_listaProductos.getColumnModel().getColumn(6).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 740, 460));
        tabla_listaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    System.out.println("Se ha hecho doble click");
                    int fila = tabla_listaProductos.getSelectedRow();
                    if (fila >= 0) {

                    }
                }
            }
        });
        btn_agregarProducto.setBackground(new java.awt.Color(0, 102, 153));
        btn_agregarProducto.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_agregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregarProducto.setText("Agregar Producto");
        btn_agregarProducto.setFocusPainted(false);
        btn_agregarProducto.addActionListener(this::btn_agregarProducto);
        getContentPane().add(btn_agregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 210, -1));
        getContentPane().add(input_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 520, 200, 30));

        btn_buscar.setBackground(new java.awt.Color(102, 102, 0));
        btn_buscar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar.setText("Buscar");
        btn_buscar.setFocusPainted(false);
        getContentPane().add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 520, -1, -1));

        btn_exportarProductos.setBackground(new java.awt.Color(0, 102, 153));
        btn_exportarProductos.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_exportarProductos.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportarProductos.setText("Exportar Productos");
        btn_exportarProductos.setFocusPainted(false);
        getContentPane().add(btn_exportarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 520, 210, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lista de Productos ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        btn_atras.setBackground(new java.awt.Color(255, 0, 51));
        btn_atras.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_atras.setForeground(new java.awt.Color(255, 255, 255));
        btn_atras.setText("Atras");
        btn_atras.setFocusPainted(false);
        btn_atras.addActionListener(this::btn_atras);
        getContentPane().add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        rbtn_ordenarCategoria.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbtn_ordenarCategoria.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_ordenarCategoria.setText("Ordenar Por Categoria");
        getContentPane().add(rbtn_ordenarCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 570, -1, 30));

        rbtn_ordenarCantidad.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbtn_ordenarCantidad.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_ordenarCantidad.setText("Ordenar Por Cantidad");
        getContentPane().add(rbtn_ordenarCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 170, 30));

        rbtn_ordenarPrecioCompra.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbtn_ordenarPrecioCompra.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_ordenarPrecioCompra.setText("Ordenar Por Costo");
        getContentPane().add(rbtn_ordenarPrecioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 570, -1, 30));

        rbtn_ordenarGanancias.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbtn_ordenarGanancias.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_ordenarGanancias.setText("Ordenar Por Ganancia");
        getContentPane().add(rbtn_ordenarGanancias, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 170, 30));

        rbtn_ordenarPrecioVenta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbtn_ordenarPrecioVenta.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_ordenarPrecioVenta.setText("Ordenar Por Venta");
        getContentPane().add(rbtn_ordenarPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 610, -1, 30));

        rbtn_ordenarNombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbtn_ordenarNombre.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_ordenarNombre.setText("Ordenar Por Nombre");
        getContentPane().add(rbtn_ordenarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 610, 165, 30));

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("© 2020 Colmado El Viejillo. Todos los derechos reservados. ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 650, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 670));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void btn_atras(ActionEvent e) {
        setVisible(false);
    }

    private void btn_agregarProducto(ActionEvent e) {
        FormAgregarProducto agregarProducto = new FormAgregarProducto(new PantallaProductos(), true);
        agregarProducto.setVisible(true);

    }

}
