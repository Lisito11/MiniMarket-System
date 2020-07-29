package vista;

import bd_logica.Usuario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Lisito
 */
public class AgregarUsuario extends javax.swing.JDialog {

    public AgregarUsuario(JFrame parent, boolean modal) {
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
        input_idUsuario = new javax.swing.JTextField();
        input_nombre = new javax.swing.JTextField();
        input_email = new javax.swing.JTextField();
        input_contraseña = new javax.swing.JTextField();
        btn_agregarUsuario = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Usuario");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Agregar Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Usuario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contraseña");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        input_idUsuario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        getContentPane().add(input_idUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 160, -1));

        input_nombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        getContentPane().add(input_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 160, -1));

        input_email.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        getContentPane().add(input_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 160, -1));

        input_contraseña.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        getContentPane().add(input_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 160, -1));

        btn_agregarUsuario.setBackground(new java.awt.Color(0, 102, 153));
        btn_agregarUsuario.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_agregarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregarUsuario.setText("Agregar Usuario");
        btn_agregarUsuario.setBorderPainted(false);
        btn_agregarUsuario.setFocusPainted(false);
        btn_agregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(btn_agregarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

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

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarUsuarioActionPerformed
        if (!input_idUsuario.getText().equals("") && !input_contraseña.getText().equals("")
                && !input_email.getText().equals("") && !input_nombre.getText().equals("")) {

            Usuario u = new Usuario();
            u.setUsuario(input_idUsuario.getText());
            u.setNombre(input_nombre.getText());
            u.setPassword(input_contraseña.getText());
            u.setEmail(input_email.getText());

            if (u.Agregar()) {
                JOptionPane.showMessageDialog(null, "Usuario Agregado Correctamente");
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Error al Agregar Usuario");

            }

        } else {
            JOptionPane.showMessageDialog(null, "Rellene Todos los campos");
        }


    }//GEN-LAST:event_btn_agregarUsuarioActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        setVisible(false);
        
    }//GEN-LAST:event_btn_atrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregarUsuario;
    private javax.swing.JButton btn_atras;
    private javax.swing.JTextField input_contraseña;
    private javax.swing.JTextField input_email;
    private javax.swing.JTextField input_idUsuario;
    private javax.swing.JTextField input_nombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
