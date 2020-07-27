package vista.productos;

import bd_logica.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lisito
 */
public class FormAgregarProducto extends javax.swing.JDialog {

    public FormAgregarProducto(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private javax.swing.JButton btn_agregarProducto;
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_calcularGanancia;
    private javax.swing.JLabel fondo;
    private javax.swing.JTextField input_idProducto;
    private javax.swing.JTextField input_nombreProducto;
    private javax.swing.JTextField input_precioCosto;
    private javax.swing.JTextField input_precioVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> jcb_categoria;
    private javax.swing.JLabel jlb_agregarProducto;
    private javax.swing.JLabel jlb_cantidad;
    private javax.swing.JLabel jlb_categoria;
    private javax.swing.JLabel jlb_ganancia;
    private javax.swing.JLabel jlb_idProducto;
    private javax.swing.JLabel jlb_nombreProducto;
    private javax.swing.JLabel jlb_precioCosto;
    private javax.swing.JLabel jlb_precioVenta;
    private javax.swing.JLabel jlb_showGanancia;
    private javax.swing.JSpinner jsp_cantidad;
    public DefaultTableModel dtm;
    private ArrayList<String> categorias;
    private ArrayList<String> idcategorias;

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jlb_agregarProducto = new javax.swing.JLabel();
        input_idProducto = new javax.swing.JTextField();
        jlb_nombreProducto = new javax.swing.JLabel();
        jlb_idProducto = new javax.swing.JLabel();
        jlb_categoria = new javax.swing.JLabel();
        jlb_cantidad = new javax.swing.JLabel();
        jlb_precioCosto = new javax.swing.JLabel();
        jlb_precioVenta = new javax.swing.JLabel();
        btn_agregarProducto = new javax.swing.JButton();
        jcb_categoria = new javax.swing.JComboBox<>();
        input_nombreProducto = new javax.swing.JTextField();
        jsp_cantidad = new javax.swing.JSpinner();
        jlb_ganancia = new javax.swing.JLabel();
        jlb_showGanancia = new javax.swing.JLabel();
        btn_calcularGanancia = new javax.swing.JButton();
        input_precioVenta = new javax.swing.JTextField();
        input_precioCosto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_atras = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Producto");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlb_agregarProducto.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jlb_agregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        jlb_agregarProducto.setText("Agregar Producto");
        getContentPane().add(jlb_agregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));
        getContentPane().add(input_idProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 150, 25));

        jlb_nombreProducto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlb_nombreProducto.setForeground(new java.awt.Color(255, 255, 255));
        jlb_nombreProducto.setText("Nombre Producto");
        getContentPane().add(jlb_nombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        jlb_idProducto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlb_idProducto.setForeground(new java.awt.Color(255, 255, 255));
        jlb_idProducto.setText("ID Producto");
        getContentPane().add(jlb_idProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jlb_categoria.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlb_categoria.setForeground(new java.awt.Color(255, 255, 255));
        jlb_categoria.setText("Categoria");
        getContentPane().add(jlb_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        jlb_cantidad.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlb_cantidad.setForeground(new java.awt.Color(255, 255, 255));
        jlb_cantidad.setText("Cantidad Actual");
        getContentPane().add(jlb_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jlb_precioCosto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlb_precioCosto.setForeground(new java.awt.Color(255, 255, 255));
        jlb_precioCosto.setText("Precio Costo");
        getContentPane().add(jlb_precioCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, -1, -1));

        jlb_precioVenta.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlb_precioVenta.setForeground(new java.awt.Color(255, 255, 255));
        jlb_precioVenta.setText("Precio Venta");
        getContentPane().add(jlb_precioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, -1, -1));

        btn_agregarProducto.setBackground(new java.awt.Color(0, 102, 153));
        btn_agregarProducto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_agregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregarProducto.setText("Agregar Producto");
        btn_agregarProducto.setFocusPainted(false);
        btn_agregarProducto.addActionListener(this::agregarProducto);
        getContentPane().add(btn_agregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, -1, -1));

        jcb_categoria.setBackground(new java.awt.Color(255, 255, 255));
        jcb_categoria.setForeground(new java.awt.Color(0, 0, 0));
        jcb_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Categorias"}));
        setCategorias();
        getContentPane().add(jcb_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 150, 25));
        getContentPane().add(input_nombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 150, 25));
        getContentPane().add(jsp_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 130, -1));

        jlb_ganancia.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlb_ganancia.setForeground(new java.awt.Color(255, 255, 255));
        jlb_ganancia.setText("Ganancia Producto");
        getContentPane().add(jlb_ganancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        jlb_showGanancia.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlb_showGanancia.setForeground(new java.awt.Color(204, 204, 255));
        jlb_showGanancia.setText("RD$ 00.00");
        getContentPane().add(jlb_showGanancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 405, -1, -1));

        btn_calcularGanancia.setBackground(new java.awt.Color(153, 153, 0));
        btn_calcularGanancia.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_calcularGanancia.setForeground(new java.awt.Color(255, 255, 255));
        btn_calcularGanancia.setText("Calcular");
        btn_calcularGanancia.setFocusPainted(false);
        btn_calcularGanancia.addActionListener(this::calcularGanancia);
        getContentPane().add(btn_calcularGanancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 85, -1));
        getContentPane().add(input_precioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 100, -1));
        getContentPane().add(input_precioCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 100, -1));

        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("© 2020 Colmado El Viejillo. Todos los derechos reservados. ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, -1, -1));

        btn_atras.setBackground(new java.awt.Color(255, 0, 51));
        btn_atras.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_atras.setForeground(new java.awt.Color(255, 255, 255));
        btn_atras.setText("Atras");
        btn_atras.setFocusPainted(false);
        btn_atras.addActionListener(this::btn_atras);

        getContentPane().add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 560));

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    //Metodos Principales
    private void agregarProducto(ActionEvent e) {
            if (!input_idProducto.getText().equals("")
                    && !input_nombreProducto.getText().equals("")
                    && !input_precioVenta.getText().equals("")
                    && !input_precioCosto.getText().equals("")) {
                if ((int) jsp_cantidad.getValue() > 0) {
                    String venta = input_precioVenta.getText().trim();
                    String costo = input_precioCosto.getText().trim();

                    if (isDecimal(venta) && isDecimal(costo) && (Double.parseDouble(venta) > Double.parseDouble(costo))) {
                        String categoria = (String) jcb_categoria.getSelectedItem();
                        if (categoria != null && !categoria.equals("Categorias")) {
                            categoria = (String) jcb_categoria.getSelectedItem();
                            int c = categorias.indexOf(categoria);
                            Producto p = new Producto();

                            String id_producto = input_idProducto.getText().trim();
                            String nombre = input_nombreProducto.getText().trim();
                            venta = input_precioVenta.getText();
                            costo = input_precioCosto.getText();
                            int cantidad = (int) jsp_cantidad.getValue();
                            String idc = idcategorias.get(c);
                            
                            p.setId_producto(id_producto);
                            p.setNombre(nombre);
                            p.setPrecioVenta(Double.parseDouble(venta));
                            p.setPrecioCompra(Double.parseDouble(costo));
                            p.setCantidad(cantidad);
                            p.setIdcategoria(idc);
                            int input = JOptionPane.showConfirmDialog(null, "Estas seguro de agregar este producto?", "Agregar Producto", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (input == 0) {
                                if (p.Agregar()) {
                                    JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
                                    setVisible(false);

                                } else {
                                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agrergar producto");
                                }
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione una categoria");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Costo o Venta incorrecto");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "La cantidad del producto debe de ser mayor que 0");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rellenar todos los campos");
            }
        

    }

    private void calcularGanancia(ActionEvent e) {
        String venta = input_precioVenta.getText().trim();
        String costo = input_precioCosto.getText().trim();
        Double ganancia;
        if (!venta.equals("") && !costo.equals("")) {
            if (isDecimal(venta) && isDecimal(costo) && (Double.parseDouble(venta) > Double.parseDouble(costo))) {
                ganancia = Double.parseDouble(venta) - Double.parseDouble(costo);
                System.out.println(ganancia);
                jlb_showGanancia.setText("RD$ " + String.valueOf(redondeoDecimales(ganancia)));
            } else {
                JOptionPane.showMessageDialog(null, "Costo o Venta incorrecto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Digite el costo y venta");
        }

    }

    private void btn_atras(ActionEvent e ) {
        setVisible(false);
    }

    //Metodos auxiliares
    private static boolean isDecimal(String cadena) {
        String patron = "^[0-9]+([.][0-9]+)?$";
        Pattern pat = Pattern.compile(patron);
        Matcher mat = pat.matcher(cadena);

        return mat.matches();

    }

    public static double redondeoDecimales(double numero) {
        BigDecimal redondeado = new BigDecimal(numero).setScale(2, RoundingMode.HALF_EVEN);
        return redondeado.doubleValue();
    }

    private void setCategorias() {
        Producto p = new Producto();
        ResultSet rs = p.getCategoria();
        categorias = new ArrayList<>();
        idcategorias = new ArrayList<>();

        try {
            while (rs.next()) {
                jcb_categoria.addItem(rs.getString("nombre"));
                categorias.add(rs.getString("nombre"));
                idcategorias.add(rs.getString("id_categoria"));
            }
        } catch (SQLException e) {
        }
    }

}
