package vista;

import bd_logica.Proveedor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Lisito
 */
public class AgregarProveedor extends javax.swing.JDialog {

    public AgregarProveedor(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_atras = new javax.swing.JButton();
        btn_agregarProveedor = new javax.swing.JButton();
        input_idProveedor = new javax.swing.JTextField();
        input_nameEmpresa = new javax.swing.JTextField();
        input_telEmpresa = new javax.swing.JTextField();
        input_nameContacto = new javax.swing.JTextField();
        input_telContacto = new javax.swing.JTextField();
        input_direccion = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Proveedor");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Agregar Proveedor");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Proveedor");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 80, -1, 25));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre Empresa");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 120, -1, 25));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre Contacto");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 200, 140, 25));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telefono Contacto");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 25));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Telefono Empresa");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 25));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Direccion");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, 25));

        btn_atras.setBackground(new java.awt.Color(255, 0, 51));
        btn_atras.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_atras.setForeground(new java.awt.Color(255, 255, 255));
        btn_atras.setText("Atras");
        btn_atras.setBorderPainted(false);
        btn_atras.setFocusPainted(false);
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btn_agregarProveedor.setBackground(new java.awt.Color(0, 102, 153));
        btn_agregarProveedor.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_agregarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregarProveedor.setText("Agregar Proveedor");
        btn_agregarProveedor.setBorderPainted(false);
        btn_agregarProveedor.setFocusPainted(false);
        btn_agregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(btn_agregarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, -1, -1));
        getContentPane().add(input_idProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 200, 27));
        getContentPane().add(input_nameEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 200, 27));
        getContentPane().add(input_telEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 200, 27));
        getContentPane().add(input_nameContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 200, 27));
        getContentPane().add(input_telContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 200, 27));
        getContentPane().add(input_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 200, 27));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btn_atrasActionPerformed

    private void btn_agregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarProveedorActionPerformed
        if (!input_idProveedor.getText().equals("") && !input_nameEmpresa.getText().equals("")
                && !input_telEmpresa.getText().equals("") && !input_direccion.getText().equals("")) {
            Proveedor p = new Proveedor();
            p.setIdProveedor(input_idProveedor.getText());
            p.setNombreEmpresa(input_nameEmpresa.getText());
            p.setNombreContacto(input_nameContacto.getText());
            p.setTelefonoContacto(input_telContacto.getText());
            p.setTelefonoEmpresa(input_telEmpresa.getText());
            p.setDireccion(input_direccion.getText());

            if (p.Agregar()) {
                JOptionPane.showMessageDialog(null, "Proveedor Agregado Correctamente");
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Error al Agregar Proveedor");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Rellene Todos los campos");

        }

    }//GEN-LAST:event_btn_agregarProveedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregarProveedor;
    private javax.swing.JButton btn_atras;
    private javax.swing.JLabel fondo;
    private javax.swing.JTextField input_direccion;
    private javax.swing.JTextField input_idProveedor;
    private javax.swing.JTextField input_nameContacto;
    private javax.swing.JTextField input_nameEmpresa;
    private javax.swing.JTextField input_telContacto;
    private javax.swing.JTextField input_telEmpresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
