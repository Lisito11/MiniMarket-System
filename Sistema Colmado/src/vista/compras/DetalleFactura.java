
package vista.compras;

import javax.swing.JDialog;

/**
 *
 * @author Lisito
 */
public class DetalleFactura extends javax.swing.JDialog {
    public DetalleFactura(JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Nombre ", "Costo Unidad", "Cantidad", "Costo Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 520, 250));

        btn_agregarProducto.setBackground(new java.awt.Color(0, 102, 153));
        btn_agregarProducto.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_agregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregarProducto.setText("Agregar Producto");
        btn_agregarProducto.setBorderPainted(false);
        btn_agregarProducto.setFocusPainted(false);
        getContentPane().add(btn_agregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        btn_editarProducto.setBackground(new java.awt.Color(0, 102, 153));
        btn_editarProducto.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_editarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btn_editarProducto.setText("Editar Producto");
        btn_editarProducto.setBorderPainted(false);
        btn_editarProducto.setFocusPainted(false);
        getContentPane().add(btn_editarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        btn_finalizarCompra.setBackground(new java.awt.Color(102, 102, 0));
        btn_finalizarCompra.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_finalizarCompra.setForeground(new java.awt.Color(255, 255, 255));
        btn_finalizarCompra.setText("Finalizar Compra");
        btn_finalizarCompra.setBorderPainted(false);
        btn_finalizarCompra.setFocusPainted(false);
        getContentPane().add(btn_finalizarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        btn_atras.setBackground(new java.awt.Color(255, 0, 51));
        btn_atras.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_atras.setForeground(new java.awt.Color(255, 255, 255));
        btn_atras.setText("Atras");
        btn_atras.setBorderPainted(false);
        btn_atras.setFocusPainted(false);
        getContentPane().add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("© 2020 Colmado El Viejillo. Todos los derechos reservados.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregarProducto;
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_editarProducto;
    private javax.swing.JButton btn_finalizarCompra;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
