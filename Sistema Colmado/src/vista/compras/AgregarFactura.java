/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.compras;

import javax.swing.JDialog;

/**
 *
 * @author Lisito
 */
public class AgregarFactura extends javax.swing.JDialog {

    public static String idCompra = ""; 
    public AgregarFactura(JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        getContentPane().add(btn_agregarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 190, -1));

        jcombox_proveedor.setBackground(new java.awt.Color(255, 255, 255));
        jcombox_proveedor.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jcombox_proveedor.setForeground(new java.awt.Color(0, 0, 0));
        jcombox_proveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregarCompra;
    private javax.swing.JLabel fondo;
    private javax.swing.JTextField input_fechacompra;
    private javax.swing.JTextField input_idcompra;
    private javax.swing.JComboBox<String> jcombox_proveedor;
    private javax.swing.JLabel jlb_fechacompra;
    private javax.swing.JLabel jlb_idcompra;
    private javax.swing.JLabel jlb_proveedor;
    // End of variables declaration//GEN-END:variables
}
