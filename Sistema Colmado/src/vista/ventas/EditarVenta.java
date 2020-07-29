package vista.ventas;

import bd_logica.DetalleVenta;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lisito
 */
public class EditarVenta extends javax.swing.JDialog {

    DetalleVenta dv = new DetalleVenta();
    String idVenta = PantallaVentas.idVenta;

    public EditarVenta(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarProductos();
    }

    public javax.swing.JButton btn_añadirProducto;
    public javax.swing.JButton btn_finalizarVenta;
    public javax.swing.JButton btn_quitarProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public DefaultTableModel dtm;


    @SuppressWarnings("unchecked")
    private void initComponents() {
        String[] columnNames = {"ID del Producto", "Hora de la venta", "Cantidad"};
        Object[][] datos = {};
        dtm = new DefaultTableModel(datos, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jLabel1 = new javax.swing.JLabel();
        btn_finalizarVenta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new JTable(dtm);
        btn_añadirProducto = new javax.swing.JButton();
        btn_quitarProducto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        setTitle("Editar Venta");
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Editando productos de la venta");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        btn_finalizarVenta.setBackground(new java.awt.Color(153, 153, 0));
        btn_finalizarVenta.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_finalizarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btn_finalizarVenta.setText("Finalizar Venta");
        btn_finalizarVenta.addActionListener(this::btn_finalizarVenta);
        getContentPane().add(btn_finalizarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 140, -1));

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

        btn_añadirProducto.setBackground(new java.awt.Color(0, 102, 153));
        btn_añadirProducto.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_añadirProducto.setForeground(new java.awt.Color(255, 255, 255));
        btn_añadirProducto.setText("Añadir Producto");
        btn_añadirProducto.addActionListener(this::btn_añadirProducto);

        getContentPane().add(btn_añadirProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 150, -1));

        btn_quitarProducto.setBackground(new java.awt.Color(0, 102, 153));
        btn_quitarProducto.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_quitarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btn_quitarProducto.setText("Quitar Producto");
        btn_quitarProducto.addActionListener(this::btn_quitarProducto);
        getContentPane().add(btn_quitarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 150, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 360));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JOptionPane.showMessageDialog(null, "No esta permitido editar el productoF");
                }
            }
        });
        pack();
    }

//------------------------------------------------------------------------------    
    /* Acciones de los botones principales
    *  
    *  Añadir Producto
    *  Quitar Producto
    *  Finalizar Venta
    *  
     */
    // Metodo - Añadir Producto
    private void btn_añadirProducto(ActionEvent e) {

        String idproducto = JOptionPane.showInputDialog("Introduzca el ID del producto");

        //Validando id producto
        while (idproducto.equals("") || !dv.VerificarProducto(idproducto)) {
            JOptionPane.showMessageDialog(null, "Introduce un ID de producto valido");
            idproducto = JOptionPane.showInputDialog("Introduzca el ID del producto");
        }

        //Validando la hora de entrada del producto
        String hora = JOptionPane.showInputDialog("Introduzca el hora del producto");
        while (hora.equals("") || !ValidarHora(hora)) {
            JOptionPane.showMessageDialog(null, "Introduce una hora valida (hh:mm)");
            hora = JOptionPane.showInputDialog("Introduzca el hora del producto");
        }

        //Validando la cantidad introducida del producto
        String cantidad = JOptionPane.showInputDialog("Introduzca la cantidad del producto");
        while (cantidad.equals("") || !ValidarCantidad(cantidad) || Integer.parseInt(cantidad) < 0) {
            JOptionPane.showMessageDialog(null, "Introduce una cantidad valida");
            cantidad = JOptionPane.showInputDialog("Introduzca la cantidad del producto");
        }

        setFila(idproducto, hora, cantidad);

        System.out.println(idproducto);
        System.out.println(hora);
        System.out.println(cantidad);

    }

    // Metodo - Quitar Producto
    private void btn_quitarProducto(ActionEvent e) {
        int fila = jTable1.getSelectedRow();
        if (fila >= 0) {
            String nombre = String.valueOf(dtm.getValueAt(jTable1.getSelectedRow(), 0));
            String hora = String.valueOf(dtm.getValueAt(jTable1.getSelectedRow(), 1));
            int cantidad = Integer.parseInt(String.valueOf(dtm.getValueAt(jTable1.getSelectedRow(), 2)));

            //AQUI VA LA PARTE DE QUITAR UN PRODUCTO A LA BASE DE DATOS
            dv.editarFacturaEliminarProducto(nombre, cantidad, hora, idVenta);
            dtm.removeRow(fila);

            System.out.println(nombre);
            System.out.println(hora);
            System.out.println(cantidad);
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un producto para Eliminar");
        }

    }

    // Metodo - Finalizar Venta
    private void btn_finalizarVenta(ActionEvent e) {
        String id;
        String hora;
        String cantidad;

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            id = (String) jTable1.getValueAt(i, 0);
            hora = (String) jTable1.getValueAt(i, 1);
            cantidad = (String) jTable1.getValueAt(i, 2);

            if (!dv.editarFacturaVerificarProducto(id, hora, cantidad)) {
                if (dv.editarFacturaAñadirProducto(id, cantidad, hora, idVenta)) {
                    System.out.println("Producto Añadido ---  " + id + " " + hora + " " + cantidad);
                }
            } else {
                System.out.println("El producto existe --- " + id + " " + hora + " " + cantidad);
            }
        }

        setVisible(false);
        
    }

//------------------------------------------------------------------------------  
    /* Metodos Auxiliares de los botones Principales
     *
     * Auxiliar Validar Hora
     * Auxiliar Validar Cantidad
     * Auxiliar Agregar Fila
     * Auxiliar Mostrar Productos
     *
     */
    // Metodo - Auxiliar Validar Hora
    public boolean ValidarHora(String h) {
        String hora = h;
        if (hora.length() > 5) {
            return false;
        } else if (hora.length() == 5) {
            char pos1 = hora.charAt(0);
            char pos2 = hora.charAt(1);
            char pos3 = hora.charAt(3);
            char pos4 = hora.charAt(4);
            char pos5 = hora.charAt(2);

            if (!String.valueOf(pos5).equals(":")) {
                return false;
            }
            int suma1 = Integer.parseInt(String.valueOf(pos1) + String.valueOf(pos2));
            int suma2 = Integer.parseInt(String.valueOf(pos3) + String.valueOf(pos4));

            return !(suma1 >= 24 || suma2 > 59);

        } else {
            return false;
        }
    }

    // Metodo - Auxiliar Validar Cantidad
    public boolean ValidarCantidad(String c) {
        String numCuenta = c;
        int NOnum = 0;
        for (int i = 0; i < numCuenta.length(); i++) {
            if (!Character.isDigit(numCuenta.charAt(i))) {
                NOnum++;
            }
        }
        return NOnum == 0;
    }

    // Metodo - Auxiliar Agregar Fila
    public void setFila(String a, String b, String c) {
        Object[] newRow = {a, b, c};
        dtm.addRow(newRow);
    }

    // Metodo - Auxiliar Mostrar Productos
    private void mostrarProductos() {
        System.out.println(idVenta);
        ResultSet rs = dv.getTable("select id_producto, hora_producto, cantidad from detalle_venta where id_venta =" + idVenta);
        try {
            while (rs.next()) {
                System.out.println(rs.getString("id_producto"));
                System.out.println(String.valueOf(rs.getTime("hora_producto")));
                System.out.println(String.valueOf(rs.getInt("cantidad")));
                Object[] dt = {rs.getString("id_producto"), String.valueOf(rs.getTime("hora_producto")), String.valueOf(rs.getInt("cantidad"))};
                dtm.addRow(dt);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}
