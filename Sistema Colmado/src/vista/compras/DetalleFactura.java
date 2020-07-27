
package vista.compras;

import bd_logica.DetalleCompra;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lisito
 */
public class DetalleFactura extends javax.swing.JDialog {

    DetalleCompra dc = new DetalleCompra();
    String idCompra = AgregarFactura.idCompra;
    public DefaultTableModel dtm;

    public DetalleFactura(JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        String[] columnNames = {"ID Producto", "Nombre ", "Costo Unidad", "Cantidad", "Costo Total"};
        Object[][] datos = {};
        dtm = new DefaultTableModel(datos, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new JTable(dtm);
        btn_agregarProducto = new javax.swing.JButton();
        btn_editarProducto = new javax.swing.JButton();
        btn_finalizarCompra = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Creando Compra");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }
                jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
                jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
                jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
                jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);


        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 520, 250));

        btn_agregarProducto.setBackground(new java.awt.Color(0, 102, 153));
        btn_agregarProducto.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_agregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregarProducto.setText("Agregar Producto");
        btn_agregarProducto.setBorderPainted(false);
        btn_agregarProducto.setFocusPainted(false);
        btn_agregarProducto.addActionListener(this::btn_añadirProducto);

        getContentPane().add(btn_agregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        btn_editarProducto.setBackground(new java.awt.Color(0, 102, 153));
        btn_editarProducto.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_editarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btn_editarProducto.setText("Editar Producto");
        btn_editarProducto.setBorderPainted(false);
        btn_editarProducto.setFocusPainted(false);
        btn_editarProducto.addActionListener(this::btn_editarProducto);

        getContentPane().add(btn_editarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        btn_finalizarCompra.setBackground(new java.awt.Color(102, 102, 0));
        btn_finalizarCompra.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_finalizarCompra.setForeground(new java.awt.Color(255, 255, 255));
        btn_finalizarCompra.setText("Finalizar Compra");
        btn_finalizarCompra.setBorderPainted(false);
        btn_finalizarCompra.setFocusPainted(false);
        btn_finalizarCompra.addActionListener(this::btn_Finalizar);
        getContentPane().add(btn_finalizarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        btn_atras.setBackground(new java.awt.Color(255, 0, 51));
        btn_atras.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_atras.setForeground(new java.awt.Color(255, 255, 255));
        btn_atras.setText("Atras");
        btn_atras.setBorderPainted(false);
        btn_atras.setFocusPainted(false);
        btn_atras.addActionListener(this::btn_Atras);

        getContentPane().add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("© 2020 Colmado El Viejillo. Todos los derechos reservados.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 400));

        pack();
    }

    private void btn_añadirProducto(ActionEvent e) {
        try {
            String idproducto = JOptionPane.showInputDialog("Introduzca el ID del producto");
            while (idproducto.equals("") || !dc.VerificarProducto(idproducto)) {
                JOptionPane.showMessageDialog(null, "Introduce un ID de producto valido");
                idproducto = JOptionPane.showInputDialog("Introduzca el ID del producto");
            }

            String costoUnidad = JOptionPane.showInputDialog("Introduzca el costo del producto");
            while (costoUnidad.equals("") || !isDecimal(costoUnidad)) {
                JOptionPane.showMessageDialog(null, "Introduzca un costo valido");
                costoUnidad = JOptionPane.showInputDialog("Introduzca el costo del producto");
            }

            String cantidad = JOptionPane.showInputDialog("Introduzca la cantidad del producto");
            while (cantidad.equals("") || !ValidarCantidad(cantidad) || Integer.parseInt(cantidad) < 0) {
                JOptionPane.showMessageDialog(null, "Introduce una cantidad valida");
                cantidad = JOptionPane.showInputDialog("Introduzca la cantidad del producto");
            }

            double cu = Double.parseDouble(costoUnidad);
            int c = Integer.parseInt(cantidad);
            String costoTotal = String.valueOf(c * cu);

            //PENDIENTE AGREGAR PRODUCTO 
            dc.setIdCompra(Integer.parseInt(idCompra));
            dc.setIdProducto(idproducto);
            dc.setCostoUnidad(costoUnidad);
            dc.setCantidad(Integer.parseInt(cantidad));
            ResultSet rs = dc.getNombreProducto();
            String nombre = "";
            if (rs.next()) {
                nombre = rs.getString("nombre");
                System.out.println(nombre);
            }
            if (dc.Agregar()) {
                setFila(idproducto, nombre, costoUnidad, cantidad, costoTotal);
                JOptionPane.showMessageDialog(null, "Producto Agregado Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error ");
            }
        } catch (SQLException eq) {
            System.out.println(eq);
        }
    }

    private void btn_editarProducto(ActionEvent e) {

    }

    private void btn_Finalizar(ActionEvent e) {

    }

    private void btn_Atras(ActionEvent e) {
        int input = JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres irte?", "Regresar", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (input == 0) {
            setVisible(false);
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

    private static boolean isDecimal(String cadena) {
        String patron = "^[0-9]+([.][0-9]+)?$";
        Pattern pat = Pattern.compile(patron);
        Matcher mat = pat.matcher(cadena);

        return mat.matches();

    }

    public void setFila(String a, String b, String c, String d, String e) {
        Object[] newRow = {a, b, c, d, e};
        dtm.addRow(newRow);
    }
    private void opcionesVenta(String idVenta) {
        String[] opciones = {"Editar", "Eliminar"};
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
            case "Editar":
                break;
            case "Eliminar":
                jTable1.getSelectedRow();
                String id = String.valueOf(dtm.getValueAt(jTable1.getSelectedRow(), 0));
                EliminarProducto(id);
                break;
            default:
                break;
        }
        
    }
    private javax.swing.JButton btn_agregarProducto;
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_editarProducto;
    private javax.swing.JButton btn_finalizarCompra;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}
