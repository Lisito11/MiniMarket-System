package vista.ventas;

import vista.ventas.FormDetalleVenta;
import vista.ventas.PantallaVentas;
import bd_logica.Venta;
import javax.swing.JOptionPane;

/**
 *
 * @author Lisito
 */
public class FormVenta extends javax.swing.JFrame {

    public static String idVenta = "";

    public FormVenta() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_crearVenta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        input_idVenta = new javax.swing.JTextField();
        input_idAdministrador = new javax.swing.JTextField();
        input_fechaVenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_crearVenta.setBackground(new java.awt.Color(0, 102, 153));
        btn_crearVenta.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_crearVenta.setForeground(new java.awt.Color(255, 255, 255));
        btn_crearVenta.setText("Crear Venta");
        btn_crearVenta.setFocusPainted(false);
        btn_crearVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearVentaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_crearVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 150, 30));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrador:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 203, -1, 20));
        getContentPane().add(input_idVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 100, -1));

        input_idAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_idAdministradorActionPerformed(evt);
            }
        });
        getContentPane().add(input_idAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 100, -1));
        getContentPane().add(input_fechaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 100, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Venta:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 103, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha Venta:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 153, -1, -1));

        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("AAAA-MM-DD");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 153, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Creando Venta");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 0, 51));
        jButton3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Atras");
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void input_idAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_idAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_idAdministradorActionPerformed

    private void btn_crearVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearVentaActionPerformed
        if (!input_idVenta.getText().equals("") && !input_fechaVenta.getText().equals("") && !input_idAdministrador.getText().equals("")) {

            venta.setIdVenta(Integer.parseInt(input_idVenta.getText()));
            venta.setFechaVenta(input_fechaVenta.getText());
            venta.setIdAdministrador(input_idAdministrador.getText());
            if (venta.AgregarVenta(venta)) {
                idVenta = input_idVenta.getText();
                setVisible(false);
                FormDetalleVenta.iniciar();

            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un problema, ¡Verificar Datos!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Rellenar todos los campos");
        }
    }//GEN-LAST:event_btn_crearVentaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setVisible(false);
        PantallaVentas.iniciar();    }//GEN-LAST:event_jButton3ActionPerformed

    public static void iniciar() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FormVenta().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_crearVenta;
    public javax.swing.JTextField input_fechaVenta;
    public javax.swing.JTextField input_idAdministrador;
    public javax.swing.JTextField input_idVenta;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
    Venta venta = new Venta();

}
