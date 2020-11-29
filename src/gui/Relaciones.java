package gui;

import ar.org.centro8.curso.java.utils.swing.Table;
import ar.org.centro8.curso.java.utils.swing.Validator;
import connectors.Connector;
import entidades.Cartelera;
import entidades.Detalle;
import entidades.Relacion;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import repositories.interfaces.I_CarteleraRepository;
import repositories.interfaces.I_DetalleRepository;
import repositories.interfaces.I_RelacionRepository;
import repositories.jdbc.CarteleraRepository;
import repositories.jdbc.DetalleRepository;
import repositories.jdbc.RelacionRepository;

public class Relaciones extends javax.swing.JFrame {

    public Relaciones() {
        initComponents();
        this.setLocationRelativeTo(this);
        cargarTabla();
    }

    private void cargarTabla(){
        I_RelacionRepository rr = new RelacionRepository(Connector.getConnection());
        
        new Table<Relacion>().cargar(tblRelaciones, rr.getAll());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodCartelera = new javax.swing.JTextField();
        txtCodDetalle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRelaciones = new javax.swing.JTable();
        btnBorrar = new javax.swing.JButton();
        lblErrorCodCartelera = new javax.swing.JLabel();
        lblErrorCodDetalle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("Codigo Cartelera");

        txtCodCartelera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodCarteleraKeyTyped(evt);
            }
        });

        txtCodDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodDetalleKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setText("Codigo Detalle");

        btnGuardar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAdmin.setText("Volver a Admin");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(tblRelaciones);

        btnBorrar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        lblErrorCodCartelera.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblErrorCodCartelera.setForeground(new java.awt.Color(255, 51, 0));

        lblErrorCodDetalle.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblErrorCodDetalle.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodCartelera))
                    .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(btnAdmin))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(txtCodDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblErrorCodCartelera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblErrorCodDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodCartelera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorCodCartelera, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCodDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorCodDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdmin)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        // Evento volver a admin
        Admin admin = new Admin();
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Evento Guardar Relacion
        if (txtCodCartelera.getText().isEmpty() ||
            txtCodDetalle.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos");
            return;
        }

        Validator validator = new Validator(txtCodCartelera);
        if (!validator.isInteger()) {
            JOptionPane.showMessageDialog(this, "codCartelera no es un numero");
        }
        
        validator = new Validator(txtCodDetalle);
        if (!validator.isInteger()) {
            JOptionPane.showMessageDialog(this, "codDetalle no es un numero");
        }
        
        I_RelacionRepository rr = new RelacionRepository(Connector.getConnection());
        
        if (!comprobarExistencia(Integer.parseInt(txtCodCartelera.getText()),Integer.parseInt(txtCodDetalle.getText()))) 
        {
            JOptionPane.showMessageDialog(this, "Datos invalidos. Alguno o los dos no existen");
            return;
        }
        
        Relacion relacion = new Relacion(
                Integer.parseInt(txtCodCartelera.getText()), 
                Integer.parseInt(txtCodDetalle.getText())
        );
        
        rr.crear(relacion);
        
        txtCodCartelera.setText("");
        txtCodDetalle.setText("");
        txtCodCartelera.requestFocus();
        
        cargarTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // Evento Borrar
        int fila = tblRelaciones.getSelectedRow();
        if(fila == -1) return;
        
        int id = (int)tblRelaciones.getValueAt(fila, 0);
        
        if (JOptionPane.showConfirmDialog(this, "Desea borrar la relacion id:"+id+"?")!=0) return;
        
        I_RelacionRepository rr = new RelacionRepository(Connector.getConnection());
        rr.borrar(rr.getByIdRelacion(id));
        
        cargarTabla();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtCodCarteleraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodCarteleraKeyTyped
        // Evento validar numeros
        // Validacion de la entrada de datos
        char caracterIngresado = evt.getKeyChar();
        
        if (caracterIngresado < '0' || caracterIngresado > '9' && caracterIngresado != KeyEvent.VK_BACK_SPACE /*BACK_SPACE*/)  {
            evt.consume();
            lblErrorCodCartelera.setText("Ingresar solo numeros");
        } else {
            lblErrorCodCartelera.setText("");
        }
    }//GEN-LAST:event_txtCodCarteleraKeyTyped

    private void txtCodDetalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodDetalleKeyTyped
        // Evento validar numeros
        // Validacion de la entrada de datos
        char caracterIngresado = evt.getKeyChar();
        
        if (caracterIngresado < '0' || caracterIngresado > '9' && caracterIngresado != KeyEvent.VK_BACK_SPACE /*BACK_SPACE*/)  {
            evt.consume();
            lblErrorCodDetalle.setText("Ingresar solo numeros");
        } else {
            lblErrorCodDetalle.setText("");
        }
    }//GEN-LAST:event_txtCodDetalleKeyTyped

    private boolean comprobarExistencia(int codCartelera, int codDetalle) {
        I_CarteleraRepository cr = new CarteleraRepository(Connector.getConnection());
        I_DetalleRepository dr = new DetalleRepository(Connector.getConnection());
        
        boolean carExiste = false;
        boolean detExiste = false;
        
        for(Cartelera c : cr.getAll()){
            if (c.getCodCartelera() == codCartelera) {
                carExiste = true;
                break;
            }
        }
        
        for(Detalle d : dr.getAll()){
            if (d.getCodDetalle() == codDetalle) {
                detExiste = true;
                break;
            }
        }
        
        if (carExiste && detExiste) {
            return true;
        } else {
            return false;
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Relaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Relaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Relaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Relaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Relaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErrorCodCartelera;
    private javax.swing.JLabel lblErrorCodDetalle;
    private javax.swing.JTable tblRelaciones;
    private javax.swing.JTextField txtCodCartelera;
    private javax.swing.JTextField txtCodDetalle;
    // End of variables declaration//GEN-END:variables
}
