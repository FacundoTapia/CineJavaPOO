package gui;

import ar.org.centro8.curso.java.utils.swing.Table;
import ar.org.centro8.curso.java.utils.swing.Validator;
import connectors.Connector;
import entidades.Cartelera;
import entidades.Cliente;
import entidades.Detalle;
import entidades.Entrada;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import repositories.interfaces.I_CarteleraRepository;
import repositories.interfaces.I_ClienteRepository;
import repositories.interfaces.I_DetalleRepository;
import repositories.interfaces.I_EntradaRepository;
import repositories.jdbc.CarteleraRepository;
import repositories.jdbc.ClienteRepository;
import repositories.jdbc.DetalleRepository;
import repositories.jdbc.EntradaRepository;

public class Entradas extends javax.swing.JFrame {
    private I_EntradaRepository er = new EntradaRepository(Connector.getConnection());
    
    public Entradas() {
        initComponents();
        this.setLocationRelativeTo(this);
        cargarElementos();
    }

    private void cargarElementos(){
        new Table<Entrada>().cargar(tblEntradas, er.getAll());
    }
    
    private boolean comprobarExistencia(int idCliente, int codDetalle) {
        I_ClienteRepository cr = new ClienteRepository(Connector.getConnection());
        I_DetalleRepository dr = new DetalleRepository(Connector.getConnection());
        
        boolean clienteExiste = false;
        boolean detExiste = false;
        
        for(Cliente c : cr.getAll()){
            if (c.getId() == idCliente) {
                clienteExiste = true;
                break;
            }
        }
        
        for(Detalle d : dr.getAll()){
            if (d.getCodDetalle() == codDetalle) {
                detExiste = true;
                break;
            }
        }
        
        return clienteExiste && detExiste;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEntradas = new javax.swing.JTable();
        btnBorrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCodDetalle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        lblErrorCodDetalle = new javax.swing.JLabel();
        lblErrorIdCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(tblEntradas);

        btnBorrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("codDetalle");

        txtCodDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodDetalleKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("idCliente");

        txtIdCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdClienteKeyTyped(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        lblErrorCodDetalle.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblErrorCodDetalle.setForeground(new java.awt.Color(255, 0, 0));

        lblErrorIdCliente.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblErrorIdCliente.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtCodDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnAdmin))
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblErrorCodDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblErrorIdCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorCodDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnAdmin)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Evento Crear Entrada
        if (txtCodDetalle.getText().isEmpty() ||
            txtIdCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos");
            return;
        }
        
        Validator validator = new Validator(txtCodDetalle);
        if (!validator.isInteger()) {
            JOptionPane.showMessageDialog(this, "codDetalle no es un numero");
            return;
        }
        
        validator = new Validator(txtIdCliente);
        if (!validator.isInteger()) {
            JOptionPane.showMessageDialog(this, "idCliente no es un numero");
            return;
        }
        
        if (!comprobarExistencia(Integer.parseInt(txtCodDetalle.getText()), Integer.parseInt(txtIdCliente.getText()))) {
            JOptionPane.showMessageDialog(this, "Estas haciendo referencia a un objeto que no existe");
            return;
        }
        
        Entrada entrada = new Entrada(
            Integer.parseInt(txtIdCliente.getText()), 
            Integer.parseInt(txtCodDetalle.getText())
        );

        er.crear(entrada);
        
        if (entrada.getNroEntrada() != 0) {
            txtCodDetalle.setText("");
            txtIdCliente.setText("");
            txtCodDetalle.requestFocus();
            
            cargarElementos();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo crear la entrada");
        }

        
        cargarElementos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        // Evento volver a admin
        Admin admin = new Admin();
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // Evento Borrar
        int fila = tblEntradas.getSelectedRow();
        
        if (fila == -1) return;
        
        int id = (int)tblEntradas.getValueAt(fila, 0);
        
        if (JOptionPane.showConfirmDialog(null, "Seguro desea eliminar la entrada con id "+id+" ?") != 0) return;
        
        er.borrar(er.getById(id));
        
        cargarElementos();
    }//GEN-LAST:event_btnBorrarActionPerformed

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

    private void txtIdClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdClienteKeyTyped
        // Evento validar numeros
        // Validacion de la entrada de datos
        char caracterIngresado = evt.getKeyChar();
        
        if (caracterIngresado < '0' || caracterIngresado > '9' && caracterIngresado != KeyEvent.VK_BACK_SPACE /*BACK_SPACE*/)  {
            evt.consume();
            lblErrorIdCliente.setText("Ingresar solo numeros");
        } else {
            lblErrorIdCliente.setText("");
        }
    }//GEN-LAST:event_txtIdClienteKeyTyped

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
            java.util.logging.Logger.getLogger(Entradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Entradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Entradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Entradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Entradas().setVisible(true);
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
    private javax.swing.JLabel lblErrorCodDetalle;
    private javax.swing.JLabel lblErrorIdCliente;
    private javax.swing.JTable tblEntradas;
    private javax.swing.JTextField txtCodDetalle;
    private javax.swing.JTextField txtIdCliente;
    // End of variables declaration//GEN-END:variables
}
