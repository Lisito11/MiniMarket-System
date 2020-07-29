package vista;

import vista.compras.PantallaCompras;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import vista.productos.PantallaProductos;
import vista.ventas.PantallaVentas;

/**
 *
 * @author Lisito
 */
public class PantallaPrincipal extends javax.swing.JFrame implements ActionListener {

    public PantallaPrincipal() {
        initComponents();
        mostrarFondos();
        setResizable(false);
        setLocationRelativeTo(null);
        benvenida_txt.setText("Bienvenido " + nombre);

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        img_compra = new javax.swing.JLabel();
        btn_entrarCompras = new javax.swing.JButton();
        fondo_compras = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fondo_productos = new javax.swing.JLabel();
        btn_entrarProductos = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        img_ventas = new javax.swing.JLabel();
        btn_entrarVentas = new javax.swing.JButton();
        fondo_facturasv = new javax.swing.JLabel();
        benvenida_txt = new javax.swing.JLabel();
        btn_agregarProovedor = new javax.swing.JButton();
        btn_agregarUsuario = new javax.swing.JButton();
        autor = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        irProductos = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        irVentas = new javax.swing.JMenuItem();
        cerrar_sistema = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        creador = new javax.swing.JMenuItem();
        sistema = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Minimarket - System");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 51, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Facturas Compra");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 270, 50));
        jPanel1.add(img_compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 210, 190));

        btn_entrarCompras.setBackground(new java.awt.Color(0, 153, 102));
        btn_entrarCompras.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        btn_entrarCompras.setForeground(new java.awt.Color(255, 255, 255));
        btn_entrarCompras.setText("Entrar");
        btn_entrarCompras.setBorderPainted(false);
        btn_entrarCompras.setFocusPainted(false);
        btn_entrarCompras.addActionListener(this::btn_entrarComprasActionPerformed);
        jPanel1.add(btn_entrarCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 210, 80));

        fondo_compras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tarjetas_img.jpg"))); // NOI18N
        jPanel1.add(fondo_compras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -80, 310, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 310, 460));

        jPanel2.setBackground(new java.awt.Color(255, 51, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Productos");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));
        jPanel2.add(fondo_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 210, 190));

        btn_entrarProductos.setBackground(new java.awt.Color(0, 153, 102));
        btn_entrarProductos.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        btn_entrarProductos.setForeground(new java.awt.Color(255, 255, 255));
        btn_entrarProductos.setText("Entrar");
        btn_entrarProductos.setFocusPainted(false);
        btn_entrarProductos.addActionListener(this::btn_entrarProductosActionPerformed);
        jPanel2.add(btn_entrarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 210, 80));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tarjetas_img.jpg"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 460));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 310, 460));

        jPanel3.setBackground(new java.awt.Color(255, 51, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Facturas ventas");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));
        jPanel3.add(img_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 210, 190));

        btn_entrarVentas.setBackground(new java.awt.Color(0, 153, 102));
        btn_entrarVentas.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        btn_entrarVentas.setForeground(new java.awt.Color(255, 255, 255));
        btn_entrarVentas.setText("Entrar");
        btn_entrarVentas.addActionListener(this::btn_entrarVentasActionPerformed);
        jPanel3.add(btn_entrarVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 210, 80));

        fondo_facturasv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tarjetas_img.jpg"))); // NOI18N
        jPanel3.add(fondo_facturasv, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 460));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 330, 460));

        benvenida_txt.setBackground(new java.awt.Color(255, 255, 255));
        benvenida_txt.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        benvenida_txt.setForeground(new java.awt.Color(255, 255, 255));
        benvenida_txt.setText("Bienvenido ");
        getContentPane().add(benvenida_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        btn_agregarProovedor.setBackground(new java.awt.Color(255, 51, 0));
        btn_agregarProovedor.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_agregarProovedor.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregarProovedor.setText("Agregar Proveedor");
        btn_agregarProovedor.setFocusPainted(false);
        btn_agregarProovedor.addActionListener(this::btn_agregarProovedorActionPerformed);
        getContentPane().add(btn_agregarProovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, 190, 40));

        btn_agregarUsuario.setBackground(new java.awt.Color(255, 51, 0));
        btn_agregarUsuario.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_agregarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregarUsuario.setText("Agregar Usuario");
        btn_agregarUsuario.setFocusPainted(false);
        btn_agregarUsuario.addActionListener(this::btn_agregarUsuarioActionPerformed);
        getContentPane().add(btn_agregarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 190, 40));

        autor.setForeground(new java.awt.Color(204, 204, 204));
        autor.setText("© 2020 Colmado El Viejillo. Todos los derechos reservados. ");
        getContentPane().add(autor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 550, -1, -1));

        fondo.setBackground(new java.awt.Color(0, 255, 102));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 990, 600));

        jMenu1.setText("Inicio");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Compras");

        jMenuItem5.setText("Ir a Compras");
        jMenuItem5.addActionListener(this);

        jMenu2.add(jMenuItem5);
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Productos");

        irProductos.setText("Ir a Productos");
        irProductos.addActionListener(this);

        jMenu3.add(irProductos);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Ventas");

        irVentas.setText("Ir a Ventas");
        irVentas.addActionListener(this);

        jMenu4.add(irVentas);

        jMenuBar1.add(jMenu4);

        cerrar_sistema.setText("Opciones");

        jMenuItem6.setText("Cerrar Sistema");
        jMenuItem6.addActionListener(this);

        cerrar_sistema.add(jMenuItem6);

        jMenuBar1.add(cerrar_sistema);

        jMenu6.setText("Acerca de");

        creador.setText("Creador");
        creador.addActionListener(this);

        jMenu6.add(creador);

        sistema.setText("Sistema");
        sistema.addActionListener(this);

        jMenu6.add(sistema);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        pack();
    }

    private void btn_entrarProductosActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaProductos pp = new PantallaProductos(new PantallaPrincipal(), false);
        pp.setVisible(true);
    }

    private void btn_entrarComprasActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaCompras pc = new PantallaCompras(new PantallaPrincipal(), false);
        pc.setVisible(true);
    }

    private void btn_entrarVentasActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaVentas pv = new PantallaVentas(new PantallaPrincipal(), false);
        pv.setVisible(true);

    }

    private void btn_agregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//EN-FIR:event_btn_agregarUsuarioActionPerformed
        AgregarUsuario au = new AgregarUsuario(new PantallaPrincipal(), true);
        au.setVisible(true);

    }

    private void btn_agregarProovedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIT:event_btn_agregarProovedorActionPerformed
        AgregarProveedor ap = new AgregarProveedor(new PantallaPrincipal(), true);
        ap.setVisible(true);
    }

    public static void iniciar() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new PantallaPrincipal().setVisible(true);
        });
    }

    private javax.swing.JLabel autor;
    public static javax.swing.JLabel benvenida_txt;
    private javax.swing.JButton btn_agregarProovedor;
    private javax.swing.JButton btn_agregarUsuario;
    private javax.swing.JButton btn_entrarCompras;
    private javax.swing.JButton btn_entrarProductos;
    private javax.swing.JButton btn_entrarVentas;
    private javax.swing.JMenu cerrar_sistema;
    private javax.swing.JMenuItem creador;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel fondo_compras;
    private javax.swing.JLabel fondo_facturasv;
    private javax.swing.JLabel fondo_productos;
    private javax.swing.JLabel img_compra;
    private javax.swing.JLabel img_ventas;
    private javax.swing.JMenuItem irProductos;
    private javax.swing.JMenuItem irVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JMenuItem sistema;

    String nombre = Login.texto;
    ImageIcon icono_principal;
    private ImageIcon img, img2, img3;
    private Icon icono, icono2, icono3;

    public void mostrarFondos() {
        img = new ImageIcon("src/imagenes/productos_img.png");
        img2 = new ImageIcon("src/imagenes/ventas_img.png");
        img3 = new ImageIcon("src/imagenes/compras_img.png");

        icono = new ImageIcon(img.getImage().getScaledInstance(fondo_productos.getWidth(), fondo_productos.getHeight(), Image.SCALE_DEFAULT));
        icono2 = new ImageIcon(img2.getImage().getScaledInstance(img_ventas.getWidth(), img_ventas.getHeight(), Image.SCALE_DEFAULT));
        icono3 = new ImageIcon(img3.getImage().getScaledInstance(img_compra.getWidth(), img_compra.getHeight(), Image.SCALE_DEFAULT));
        icono_principal = new ImageIcon("src/imagenes/icono.png");
        setIconImage(icono_principal.getImage());
        img_compra.setIcon(icono3);
        fondo_productos.setIcon(icono);
        img_ventas.setIcon(icono2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == creador) {
            JOptionPane.showMessageDialog(null, "El creador es: Lisanny A. Peña G.\nEmail: l.andrespg11@gmail.com");
        }
        if (e.getSource() == sistema) {
            JOptionPane.showMessageDialog(null, "Este sistema es adecuado para:\nColmados - MiniMarkets - Regueras");
        }

        if (e.getSource() == jMenuItem5) {
            PantallaCompras pc = new PantallaCompras(new PantallaPrincipal(), false);
            pc.setVisible(true);
        }

        if (e.getSource() == irVentas) {
            PantallaVentas pv = new PantallaVentas(new PantallaPrincipal(), false);
            pv.setVisible(true);
        }

        if (e.getSource() == irProductos) {
            PantallaProductos pp = new PantallaProductos(new PantallaPrincipal(), false);
            pp.setVisible(true);
        }

        if (e.getSource() == jMenuItem6) {
            System.exit(-1);
        }

    }
}
