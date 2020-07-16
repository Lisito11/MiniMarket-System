package vista.compras;

import vista.PantallaPrincipal;

/**
 *
 * @author Lisito
 */
public class PantallaCompras extends javax.swing.JFrame {

    public PantallaCompras() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_buscarFacturasContado = new javax.swing.JButton();
        btn_exportarFacturaContado = new javax.swing.JButton();
        input_facturaContado = new javax.swing.JTextField();
        rbton_proveedorContado = new javax.swing.JRadioButton();
        rbton_fechaContado = new javax.swing.JRadioButton();
        rbton_idContado = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        btn_agregarFacturaContado = new javax.swing.JButton();
        rbton_montoContado = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_facturasContado = new javax.swing.JTable();
        btn_avanzadoContado = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        background_contado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_facturasCredito = new javax.swing.JTable();
        btn_agregarFacturaCredito = new javax.swing.JButton();
        btn_exportarFacturaCredito = new javax.swing.JButton();
        btn_buscarFacturasCredito = new javax.swing.JButton();
        input_facturaCredito = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rbton_proveedorCredito = new javax.swing.JRadioButton();
        rbton_montoCredito = new javax.swing.JRadioButton();
        rbton_fechaCredito = new javax.swing.JRadioButton();
        rbton_idCredito = new javax.swing.JRadioButton();
        btn_avanzadoCredito = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Facturas al contado");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        btn_buscarFacturasContado.setBackground(new java.awt.Color(102, 102, 0));
        btn_buscarFacturasContado.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_buscarFacturasContado.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscarFacturasContado.setText("Buscar");
        btn_buscarFacturasContado.setFocusPainted(false);
        btn_buscarFacturasContado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarFacturasContadoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_buscarFacturasContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 77, -1));

        btn_exportarFacturaContado.setBackground(new java.awt.Color(0, 102, 153));
        btn_exportarFacturaContado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_exportarFacturaContado.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportarFacturaContado.setText("Exportar Factura");
        btn_exportarFacturaContado.setFocusPainted(false);
        jPanel1.add(btn_exportarFacturaContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 280, -1));
        jPanel1.add(input_facturaContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 130, 30));

        rbton_proveedorContado.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        rbton_proveedorContado.setForeground(new java.awt.Color(255, 255, 255));
        rbton_proveedorContado.setText("Por proveedor");
        jPanel1.add(rbton_proveedorContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 170, 30));

        rbton_fechaContado.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        rbton_fechaContado.setForeground(new java.awt.Color(255, 255, 255));
        rbton_fechaContado.setText("Por fecha");
        jPanel1.add(rbton_fechaContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 170, 30));

        rbton_idContado.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        rbton_idContado.setForeground(new java.awt.Color(255, 255, 255));
        rbton_idContado.setText("Por ID");
        jPanel1.add(rbton_idContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 170, 30));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ordenar Facturas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 180, 20));

        btn_agregarFacturaContado.setBackground(new java.awt.Color(0, 102, 153));
        btn_agregarFacturaContado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_agregarFacturaContado.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregarFacturaContado.setText("Agregar Factura");
        btn_agregarFacturaContado.setFocusPainted(false);
        jPanel1.add(btn_agregarFacturaContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 270, -1));

        rbton_montoContado.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        rbton_montoContado.setForeground(new java.awt.Color(255, 255, 255));
        rbton_montoContado.setText("Por monto");
        rbton_montoContado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbton_montoContadoActionPerformed(evt);
            }
        });
        jPanel1.add(rbton_montoContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 170, 30));

        tabla_facturasContado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabla_facturasContado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tabla_facturasContado.setForeground(new java.awt.Color(255, 255, 255));
        tabla_facturasContado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Factura", "Proveedor", "Fecha", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_facturasContado.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla_facturasContado);
        if (tabla_facturasContado.getColumnModel().getColumnCount() > 0) {
            tabla_facturasContado.getColumnModel().getColumn(0).setResizable(false);
            tabla_facturasContado.getColumnModel().getColumn(1).setResizable(false);
            tabla_facturasContado.getColumnModel().getColumn(2).setResizable(false);
            tabla_facturasContado.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 560, 200));

        btn_avanzadoContado.setBackground(new java.awt.Color(102, 102, 0));
        btn_avanzadoContado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_avanzadoContado.setForeground(new java.awt.Color(255, 255, 255));
        btn_avanzadoContado.setText("Busqueda Avanzada");
        btn_avanzadoContado.setFocusPainted(false);
        jPanel1.add(btn_avanzadoContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 200, -1));

        btn_atras.setBackground(new java.awt.Color(255, 0, 51));
        btn_atras.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_atras.setForeground(new java.awt.Color(255, 255, 255));
        btn_atras.setText("Atras");
        btn_atras.setFocusPainted(false);
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });
        jPanel1.add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        background_contado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        jPanel1.add(background_contado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 290));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 795, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Facturas a crédito");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        tabla_facturasCredito.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabla_facturasCredito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Factura", "Proveedor", "Fecha", "Total"
            }
        ));
        tabla_facturasCredito.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabla_facturasCredito);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 560, 210));

        btn_agregarFacturaCredito.setBackground(new java.awt.Color(0, 102, 153));
        btn_agregarFacturaCredito.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_agregarFacturaCredito.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregarFacturaCredito.setText("Agregar Factura");
        btn_agregarFacturaCredito.setFocusPainted(false);
        jPanel2.add(btn_agregarFacturaCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 270, -1));

        btn_exportarFacturaCredito.setBackground(new java.awt.Color(0, 102, 153));
        btn_exportarFacturaCredito.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_exportarFacturaCredito.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportarFacturaCredito.setText("Exportar Factura");
        btn_exportarFacturaCredito.setFocusPainted(false);
        jPanel2.add(btn_exportarFacturaCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 280, -1));

        btn_buscarFacturasCredito.setBackground(new java.awt.Color(102, 102, 0));
        btn_buscarFacturasCredito.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_buscarFacturasCredito.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscarFacturasCredito.setText("Buscar");
        btn_buscarFacturasCredito.setFocusPainted(false);
        jPanel2.add(btn_buscarFacturasCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, -1, -1));
        jPanel2.add(input_facturaCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 130, 30));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ordenar Facturas");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, -1, -1));

        rbton_proveedorCredito.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        rbton_proveedorCredito.setForeground(new java.awt.Color(255, 255, 255));
        rbton_proveedorCredito.setText("Por proveedor");
        jPanel2.add(rbton_proveedorCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 150, 30));

        rbton_montoCredito.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        rbton_montoCredito.setForeground(new java.awt.Color(255, 255, 255));
        rbton_montoCredito.setText("Por monto");
        jPanel2.add(rbton_montoCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 150, 30));

        rbton_fechaCredito.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        rbton_fechaCredito.setForeground(new java.awt.Color(255, 255, 255));
        rbton_fechaCredito.setText("Por fecha");
        jPanel2.add(rbton_fechaCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 150, 30));

        rbton_idCredito.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        rbton_idCredito.setForeground(new java.awt.Color(255, 255, 255));
        rbton_idCredito.setText("Por ID");
        jPanel2.add(rbton_idCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 150, 30));

        btn_avanzadoCredito.setBackground(new java.awt.Color(102, 102, 0));
        btn_avanzadoCredito.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_avanzadoCredito.setForeground(new java.awt.Color(255, 255, 255));
        btn_avanzadoCredito.setText("Busqueda Avanzada");
        btn_avanzadoCredito.setFocusPainted(false);
        jPanel2.add(btn_avanzadoCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 200, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 310));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 337, 795, 302));

        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("© 2020 Colmado El Viejillo. Todos los derechos reservados. ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 640, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-9, -4, 820, 665));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbton_montoContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbton_montoContadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbton_montoContadoActionPerformed

    private void btn_buscarFacturasContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarFacturasContadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscarFacturasContadoActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        setVisible(false);
        PantallaPrincipal.iniciar();
    }//GEN-LAST:event_btn_atrasActionPerformed

    public static void iniciar() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new PantallaCompras().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel background_contado;
    private javax.swing.JButton btn_agregarFacturaContado;
    private javax.swing.JButton btn_agregarFacturaCredito;
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_avanzadoContado;
    private javax.swing.JButton btn_avanzadoCredito;
    private javax.swing.JButton btn_buscarFacturasContado;
    private javax.swing.JButton btn_buscarFacturasCredito;
    private javax.swing.JButton btn_exportarFacturaContado;
    private javax.swing.JButton btn_exportarFacturaCredito;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField input_facturaContado;
    private javax.swing.JTextField input_facturaCredito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbton_fechaContado;
    private javax.swing.JRadioButton rbton_fechaCredito;
    private javax.swing.JRadioButton rbton_idContado;
    private javax.swing.JRadioButton rbton_idCredito;
    private javax.swing.JRadioButton rbton_montoContado;
    private javax.swing.JRadioButton rbton_montoCredito;
    private javax.swing.JRadioButton rbton_proveedorContado;
    private javax.swing.JRadioButton rbton_proveedorCredito;
    private javax.swing.JTable tabla_facturasContado;
    private javax.swing.JTable tabla_facturasCredito;
    // End of variables declaration//GEN-END:variables
}
