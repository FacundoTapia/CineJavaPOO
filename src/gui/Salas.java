package gui;

import ar.org.centro8.curso.java.utils.swing.Table;
import ar.org.centro8.curso.java.utils.swing.Validator;
import connectors.Connector;
import entidades.Sala;
import enums.TipoSala;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import repositories.interfaces.I_SalaRepository;
import repositories.jdbc.SalaRepository;

public class Salas extends javax.swing.JFrame {

    public Salas() {
        initComponents();
        this.setLocationRelativeTo(this);
        cargarElementos();
    }

    private void cargarElementos(){
        cargarCmbTipo();
        cargarTabla();
    }
    
    private void cargarCmbTipo() {
        cmbTipoSala.removeAllItems();
        
        for(TipoSala ts: TipoSala.values()){
            cmbTipoSala.addItem(ts);
        }
    }
    
    private void cargarTabla(){
        I_SalaRepository sr = new SalaRepository(Connector.getConnection());
        
        new Table<Sala>().cargar(tblSalas, sr.getAll());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCapacidad = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        cmbTipoSala = new javax.swing.JComboBox<>();
        btnVolverAdmin = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSalas = new javax.swing.JTable();
        btnBorrar = new javax.swing.JButton();
        lblErrorNumero = new javax.swing.JLabel();
        lblErrorCapacidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("Numero");

        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setText("Tipo");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("Capacidad");

        txtCapacidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCapacidadKeyTyped(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnVolverAdmin.setText("Volver a Admin");
        btnVolverAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverAdminActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(tblSalas);

        btnBorrar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        lblErrorNumero.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblErrorNumero.setForeground(new java.awt.Color(255, 0, 0));

        lblErrorCapacidad.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblErrorCapacidad.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnVolverAdmin)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCapacidad))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbTipoSala, 0, 89, Short.MAX_VALUE)
                            .addComponent(txtNumero)))
                    .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblErrorNumero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblErrorCapacidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbTipoSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnVolverAdmin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Evento Guardar Sala
        if (txtNumero.getText().isEmpty() || 
            txtCapacidad.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Rellene todos los campos");
            return;
        }
        
        Validator validator = new Validator(txtNumero);
        if (!validator.isInteger()) {
            JOptionPane.showMessageDialog(this, "Numero de Sala no es un numero");
            return;
        }
        
        validator = new Validator(txtCapacidad);
        
        if (!validator.isInteger()) {
        JOptionPane.showMessageDialog(this, "Capacidad no es un numero");
            return;
        }
        
        I_SalaRepository sr = new SalaRepository(Connector.getConnection());
        
        Sala sala = new Sala(
                Integer.parseInt(txtNumero.getText()),
                cmbTipoSala.getItemAt(cmbTipoSala.getSelectedIndex()), 
                Integer.parseInt(txtCapacidad.getText())
        );
        
        sr.crear(sala);
        
        txtNumero.setText("");
        txtCapacidad.setText("");
        cmbTipoSala.setSelectedIndex(0);
        
        txtNumero.requestFocus();
        
        cargarElementos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVolverAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverAdminActionPerformed
        // Evento Volver a Admin
        Admin admin = new Admin();
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverAdminActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // Evento Borrar
        int fila = tblSalas.getSelectedRow();
        if (fila == -1) return;
        
        int id = (int)tblSalas.getValueAt(fila, 0);
        
        if (JOptionPane.showConfirmDialog(this, "Desea borrar la sala id:"+id+"?")!=0) return;
        
        I_SalaRepository sr = new SalaRepository(Connector.getConnection());
        sr.borrar(sr.getByNumero(id));
        
        cargarElementos();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyTyped
        // Evento validar numeros
        // Validacion de la entrada de datos
        char caracterIngresado = evt.getKeyChar();
        
        if (caracterIngresado < '0' || caracterIngresado > '9' && caracterIngresado != KeyEvent.VK_BACK_SPACE /*BACK_SPACE*/)  {
            evt.consume();
            lblErrorNumero.setText("Ingresar solo numeros");
        } else {
            lblErrorNumero.setText("");
        }
    }//GEN-LAST:event_txtNumeroKeyTyped

    private void txtCapacidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCapacidadKeyTyped
                // Evento validar numeros
        // Validacion de la entrada de datos
        char caracterIngresado = evt.getKeyChar();
        
        if (caracterIngresado < '0' || caracterIngresado > '9' && caracterIngresado != KeyEvent.VK_BACK_SPACE /*BACK_SPACE*/)  {
            evt.consume();
            lblErrorCapacidad.setText("Ingresar solo numeros");
        } else {
            lblErrorCapacidad.setText("");
        }
    }//GEN-LAST:event_txtCapacidadKeyTyped

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
            java.util.logging.Logger.getLogger(Salas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Salas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Salas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Salas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Salas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolverAdmin;
    private javax.swing.JComboBox<TipoSala> cmbTipoSala;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErrorCapacidad;
    private javax.swing.JLabel lblErrorNumero;
    private javax.swing.JTable tblSalas;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
