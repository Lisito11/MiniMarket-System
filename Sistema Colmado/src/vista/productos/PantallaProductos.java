package vista.productos;

import bd_logica.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.ventas.PantallaVentas;
import java.sql.DriverManager;

/**
 *
 * @author Lisito
 */
public class PantallaProductos extends javax.swing.JDialog implements ActionListener {

    public PantallaProductos(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    public PantallaProductos() {
    }
    private java.sql.Connection conn;
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
    private javax.swing.JMenuItem regresar;
    private javax.swing.JMenuItem agregarProductoo;

    public DefaultTableModel dtm;

    @SuppressWarnings("unchecked")
    private void initComponents() {
        String[] columnNames = {"ID Producto", "Nombre ", "Cantidad", "Costo", "Venta", "Ganancia", "Categoria"};
        Object[][] datos = {};
        dtm = new DefaultTableModel(datos, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        regresar = new javax.swing.JMenuItem();
        agregarProductoo = new javax.swing.JMenuItem();
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
        setTitle("Pantalla Productos");
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
        tabla_listaProductos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabla_listaProductos.getColumnModel().getColumn(5).setPreferredWidth(50);
        tabla_listaProductos.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabla_listaProductos.getColumnModel().getColumn(3).setPreferredWidth(50);
        tabla_listaProductos.getColumnModel().getColumn(4).setPreferredWidth(50);

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
        btn_buscar.addActionListener(this::btn_buscar);
        getContentPane().add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 520, -1, -1));

        btn_exportarProductos.setBackground(new java.awt.Color(0, 102, 153));
        btn_exportarProductos.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_exportarProductos.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportarProductos.setText("Exportar Productos");
        btn_exportarProductos.setFocusPainted(false);
        btn_exportarProductos.addActionListener(this::btn_exportarProductos);
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

        buttonGroup1.add(rbtn_ordenarNombre);
        buttonGroup1.add(rbtn_ordenarPrecioVenta);
        buttonGroup1.add(rbtn_ordenarGanancias);
        buttonGroup1.add(rbtn_ordenarPrecioCompra);
        buttonGroup1.add(rbtn_ordenarCantidad);
        buttonGroup1.add(rbtn_ordenarCategoria);

        rbtn_ordenarCantidad.addActionListener(this::ordernarPor);
        rbtn_ordenarGanancias.addActionListener(this::ordernarPor);
        rbtn_ordenarPrecioCompra.addActionListener(this::ordernarPor);
        rbtn_ordenarPrecioVenta.addActionListener(this::ordernarPor);
        rbtn_ordenarCategoria.addActionListener(this::ordernarPor);
        rbtn_ordenarNombre.addActionListener(this::ordernarPor);

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("© 2020 Colmado El Viejillo. Todos los derechos reservados. ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 650, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 670));

        jMenu1.setText("Inicio");
        regresar.setText("Regresar");
        regresar.addActionListener(this);
        jMenu1.add(regresar);
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Productos");
        agregarProductoo.setText("Agregar Producto");
        agregarProductoo.addActionListener(this);

        jMenu2.add(agregarProductoo);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);

        mostrarProductos();
    }

    private void btn_atras(ActionEvent e) {
        setVisible(false);
    }

    private void btn_agregarProducto(ActionEvent e) {
        int input = JOptionPane.showConfirmDialog(null, "Desea agregar un producto?", "Agregar Producto", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (input == 0) {
            FormAgregarProducto agregarProducto = new FormAgregarProducto(new PantallaProductos(), true);
            agregarProducto.setVisible(true);
        }

    }

    private void mostrarProductos() {
        Producto p = new Producto();
        ResultSet rs = p.getTable("select p.id_producto, p.nombre,p.cantidad,p.precioCompra, p.PrecioVenta, c.nombre, p.precioVenta - p.precioCompra as ganancia  from producto p inner join categoria c on c.id_categoria = p.id_categoria");
        try {
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("p.id_producto"), rs.getString("p.nombre"), rs.getString("p.cantidad"), rs.getString("p.precioCompra"), rs.getString("p.precioVenta"), rs.getString("ganancia"), rs.getString("c.nombre")});
            }
        } catch (SQLException e) {
        }

    }

    private void filtrarBusqueda(String filtro) {
        Producto p = new Producto();
        ResultSet rs = p.getTable(filtro);
        try {
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("p.id_producto"), rs.getString("p.nombre"), rs.getString("p.cantidad"), rs.getString("p.precioCompra"), rs.getString("p.precioVenta"), rs.getString("ganancia"), rs.getString("c.nombre")});
            }
        } catch (SQLException e) {
        }
    }

    private void limpiarTabla() {
        int a = dtm.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            dtm.removeRow(i);
        }
    }

    private void ordernarPor(ActionEvent e) {
        String sql = "select p.id_producto, p.nombre,p.cantidad,p.precioCompra, p.PrecioVenta, c.nombre, p.precioVenta - p.precioCompra as ganancia  from producto p inner join categoria c on c.id_categoria = p.id_categoria ";
        // Ordenar por Cantidad
        if (rbtn_ordenarCantidad.isSelected() == true) {
            limpiarTabla();
            filtrarBusqueda(sql + "order by p.cantidad DESC");
        }

        // Ordenar por Ganancia
        if (rbtn_ordenarGanancias.isSelected() == true) {
            limpiarTabla();
            filtrarBusqueda(sql + "order by ganancia DESC ");
        }

        // Ordenar por Costo
        if (rbtn_ordenarPrecioCompra.isSelected() == true) {
            limpiarTabla();
            filtrarBusqueda(sql + "order by p.precioCompra DESC");
        }

        // Ordenar por Venta
        if (rbtn_ordenarPrecioVenta.isSelected() == true) {
            limpiarTabla();
            filtrarBusqueda(sql + "order by p.precioVenta DESC");
        }
        // Ordenar por Categoria
        if (rbtn_ordenarCategoria.isSelected() == true) {
            limpiarTabla();
            filtrarBusqueda(sql + "order by c.nombre ASC");
        }
        // Ordenar por Nombre
        if (rbtn_ordenarNombre.isSelected() == true) {
            limpiarTabla();
            filtrarBusqueda(sql + "order by p.nombre ASC");
        }

    }

    private void btn_buscar(ActionEvent e) {
        boolean bandera = true;
        String nombre;
        String id;
        String busqueda = input_buscar.getText();
        if (busqueda.equals("")) {
            JOptionPane.showMessageDialog(null, "Introducir ID o Nombre");
        } else {
            //Seleccionar la fila dentro del jtable1
            for (int i = 0; i < tabla_listaProductos.getRowCount(); i++) {

                //Buscamos por ID producto
                if (String.valueOf(tabla_listaProductos.getValueAt(i, 0)).toLowerCase().equals(busqueda.trim().toLowerCase())) {
                    tabla_listaProductos.changeSelection(i, 0, false, false);
                    bandera = true;
                    id = (String) tabla_listaProductos.getValueAt(i, 0);
                    System.out.println(id);
                    input_buscar.setText("");

                    break;

                } //Buscamos por Nombre Producto
                else if (String.valueOf(tabla_listaProductos.getValueAt(i, 1)).toLowerCase().equals(busqueda.trim().toLowerCase())) {
                    tabla_listaProductos.changeSelection(i, 1, false, false);
                    bandera = true;
                    nombre = (String) tabla_listaProductos.getValueAt(i, 0);
                    System.out.println(nombre);
                    input_buscar.setText("");

                    break;
                }
                bandera = false;
            }
            if (!bandera) {
                JOptionPane.showMessageDialog(null, "Ese producto no existe");
            }
        }
    }

    private void btn_exportarProductos(ActionEvent e) {
        int input = JOptionPane.showConfirmDialog(null, "¿Desea exportar todos los productos?", "Exportar Productos", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (input == 0) {
            exportarProductos();
        }
    }

    private void exportarProductos() {
        try {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost/db_colmado", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(PantallaProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
            String nombreReporte = "productos_1.jasper";
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == regresar) {
            setVisible(false);
        }
        if (e.getSource() == agregarProductoo) {
            int input = JOptionPane.showConfirmDialog(null, "Desea agregar un producto?", "Agregar Producto", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (input == 0) {
                FormAgregarProducto agregarProducto = new FormAgregarProducto(new PantallaProductos(), true);
                agregarProducto.setVisible(true);
            }
        }
    }

}
