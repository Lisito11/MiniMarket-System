package vista;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import bd_logica.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lisanny A. Peña G.
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    public javax.swing.JButton btn_login;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel logo;
    public javax.swing.JPasswordField txt_password;
    public javax.swing.JTextField txt_usuario;
    private ImageIcon img, img2;
    private Icon icono, icono2;
    public static String texto = "";
    private ImageIcon icono_principal;

    //Metodo donde se inicializan los componentes
    private void initComponents() {
        txt_usuario = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        logo = new javax.swing.JLabel();
        btn_login = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_usuario.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        txt_usuario.setForeground(new java.awt.Color(102, 102, 102));
        txt_usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_usuario.setText("lisanny11@hotmail.com");
        txt_usuario.setAutoscrolls(false);
        txt_usuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.green, java.awt.Color.green, null));
        txt_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 250, 30));

        txt_password.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setText("Lisito01");
        txt_password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.green, java.awt.Color.green, null));
        txt_password.setCaretColor(new java.awt.Color(0, 0, 0));
        txt_password.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 250, 30));

        logo.setBackground(new java.awt.Color(255, 255, 255));
        logo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logo.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        logo.setIconTextGap(10);
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 350, 300));

        btn_login.setBackground(new java.awt.Color(255, 106, 6));
        btn_login.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("Iniciar Sesión");
        btn_login.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_login.setBorderPainted(false);
        btn_login.addActionListener(this::btn_login);
        getContentPane().add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 250, 50));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("© 2020 Colmado El Viejillo. Todos los derechos reservados. ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 520, -1, -1));

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 550));
        setTitle("Login - MiniMarket System");
        pack();

        // Agregando la imagen del fondo y El logo
        img = new ImageIcon("src/imagenes/fondo_login.png");
        img2 = new ImageIcon("src/imagenes/logo.png");
        icono = new ImageIcon(img.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
        icono2 = new ImageIcon(img2.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_DEFAULT));
        logo.setIcon(icono2);
        fondo.setIcon(icono);
        icono_principal = new ImageIcon("src/imagenes/icono.png");
        setIconImage(icono_principal.getImage());
        setResizable(false);
        setLocationRelativeTo(null);

    }

    //Metodo para validar los datos de sesión y ingresar al programa principal
    private void btn_login(java.awt.event.ActionEvent evt) {
        Usuario user = new Usuario();
        String pass = txt_password.getText();
        if (!txt_usuario.getText().equals("") && !pass.equals("")) {
            try {
                user.setEmail(txt_usuario.getText().trim());
                user.setPassword(pass);
                ResultSet rs = user.getNombreUsuario();
                if (rs.next()) {
                    texto = rs.getString("nombre");
                }
                if (user.ComprobarUsuario()) {
                    txt_password.setText("");
                    setVisible(false);
                    PantallaPrincipal pp = new PantallaPrincipal();
                    pp.setVisible(true);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Datos incorrectos");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Rellene todos los campos");
        }

    }

    //METODO MAIN PARA INICIAR LA APLICACION
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

}
