/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.compras;

import bd_logica.Compra;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import java.sql.SQLException;

/**
 *
 * @author Lisito
 */
public class AgregarFactura extends javax.swing.JDialog {

    private ArrayList<String> proveedores;
    private ArrayList<String> idproveedores;
    public static String idCompra = "";
    Compra compra = new Compra();

    public AgregarFactura(JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public AgregarFactura() {
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        input_idcompra = new javax.swing.JTextField();
        jlb_idcompra = new javax.swing.JLabel();
        input_fechacompra = new javax.swing.JTextField();
        btn_agregarCompra = new javax.swing.JButton();
        jcombox_proveedor = new javax.swing.JComboBox<>();
        jlb_fechacompra = new javax.swing.JLabel();
        jlb_proveedor = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Factura");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        input_idcompra.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        getContentPane().add(input_idcompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 90, 25));

        jlb_idcompra.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlb_idcompra.setForeground(new java.awt.Color(255, 255, 255));
        jlb_idcompra.setText("ID Compra");
        getContentPane().add(jlb_idcompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        input_fechacompra.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        getContentPane().add(input_fechacompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 110, 25));

        btn_agregarCompra.setBackground(new java.awt.Color(102, 102, 0));
        btn_agregarCompra.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_agregarCompra.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregarCompra.setText("Agregar Compra");
        btn_agregarCompra.setFocusPainted(false);
        btn_agregarCompra.addActionListener(this::btn_agregarCompra);
        getContentPane().add(btn_agregarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 190, -1));

        jcombox_proveedor.setBackground(new java.awt.Color(255, 255, 255));
        jcombox_proveedor.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jcombox_proveedor.setForeground(new java.awt.Color(0, 0, 0));
        jcombox_proveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Proveedores"}));
        setProveedores();
        getContentPane().add(jcombox_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 190, -1));

        jlb_fechacompra.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlb_fechacompra.setForeground(new java.awt.Color(255, 255, 255));
        jlb_fechacompra.setText("Fecha Compra");
        getContentPane().add(jlb_fechacompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jlb_proveedor.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlb_proveedor.setForeground(new java.awt.Color(255, 255, 255));
        jlb_proveedor.setText("Seleccione el proveedor");
        getContentPane().add(jlb_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 258, 350));

        pack();
    }

    private void btn_agregarCompra(ActionEvent e) {
        if (!input_idcompra.getText().equals("") && !input_fechacompra.getText().equals("")) {
            int input = JOptionPane.showConfirmDialog(null, "¿Desea agregar una Factura?", "Agregar Factura", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (input == 0) {
                if (isNumeric(input_idcompra.getText())) {
                    int id = Integer.parseInt(input_idcompra.getText());
                    String proveedor = (String) jcombox_proveedor.getSelectedItem();
                    if (proveedor != null && !proveedor.equals("Proveedores")) {
                        proveedor = (String) jcombox_proveedor.getSelectedItem();
                        int p = proveedores.indexOf(proveedor);
                        String idp = idproveedores.get(p);
                        compra.setIdCompra(id);
                        compra.setFechaCompra(input_fechacompra.getText());
                        compra.setProveedor(idp);
                        if (compra.Agregar()) {
                            idCompra = input_idcompra.getText();
                            setVisible(false);
                            DetalleFactura df = new DetalleFactura(new AgregarFactura(), true);
                            df.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema, ¡Verificar Datos!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar un proveedor");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El ID de la Compra debe ser un numero");
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Rellenar todos los campos");
        }
    }

    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    private void setProveedores() {
        Compra c = new Compra();
        ResultSet rs = c.getProveedores();
        proveedores = new ArrayList<>();
        idproveedores = new ArrayList<>();

        try {
            while (rs.next()) {
                jcombox_proveedor.addItem(rs.getString("nombreEmpresa"));
                proveedores.add(rs.getString("nombreEmpresa"));
                idproveedores.add(rs.getString("id_proveedor"));
            }
        } catch (SQLException e) {
        }
    }
    private javax.swing.JButton btn_agregarCompra;
    private javax.swing.JLabel fondo;
    private javax.swing.JTextField input_fechacompra;
    private javax.swing.JTextField input_idcompra;
    private javax.swing.JComboBox<String> jcombox_proveedor;
    private javax.swing.JLabel jlb_fechacompra;
    private javax.swing.JLabel jlb_idcompra;
    private javax.swing.JLabel jlb_proveedor;

}
