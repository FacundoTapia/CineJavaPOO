package gui;

import ar.org.centro8.curso.java.utils.swing.Validator;
import connectors.Connector;
import entidades.Cliente;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import repositories.jdbc.ClienteRepository;

public class Login extends javax.swing.JFrame {
    public static Cliente clienteAcceso;
    
    public Login() {
        initComponents();
        this.setLocationRelativeTo(this);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnLogIn = new javax.swing.JButton();
        btnRegistro = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        btnAdmin = new javax.swing.JButton();
        btnRecuperarContraseña = new javax.swing.JButton();
        lblErrorUsuario = new javax.swing.JLabel();
        lblErrorPass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel2.setText("Password");

        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        btnLogIn.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnLogIn.setText("Iniciar Sesión");
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });

        btnRegistro.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnRegistro.setText("Registrarse");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        btnAdmin.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnAdmin.setText("Admin");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        btnRecuperarContraseña.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnRecuperarContraseña.setText("Recuperar Contraseña");
        btnRecuperarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecuperarContraseñaActionPerformed(evt);
            }
        });

        lblErrorUsuario.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblErrorUsuario.setForeground(new java.awt.Color(255, 0, 51));

        lblErrorPass.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblErrorPass.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jLabel2)))
                        .addGap(0, 105, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdmin)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRecuperarContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblErrorUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsuario)
                    .addComponent(lblErrorPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPass))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorPass, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecuperarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnAdmin)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        // Evento Registrarse
        Registro registro = new Registro();
        registro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        // Evento Logeo
        //Compruebo que los campos esten completos
        if (txtUsuario.getText().isEmpty() || txtPass.getPassword().length<=0) {
            JOptionPane.showMessageDialog(this, "Rellene los campos");
            return;
        }
        
        //Compruebo la longitud de la contraseña entre 8 y 20 caracteres
        Validator validator = new Validator(txtPass);
        if (!validator.lenght(8, 20)){
            lblErrorPass.setText("Debe tener entre 8 y 20 caracteres");
            txtPass.requestFocus();
            return;
        }
        
        //Obtengo los datos de login de los txt
        String pass = String.valueOf(txtPass.getPassword());
        String usuario = txtUsuario.getText().trim();
        
        ClienteRepository cr = new ClienteRepository(Connector.getConnection());
        
        boolean usuarioCorrecto = false;
        boolean passCorrecta = false;
        
        //Si la lista esta vacia
        if (cr.getAll().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun cliente registrado");
        } else {
            //Sino recorro la lista de todos los clientes y comparo los usuarios
            //de los mismos con el ingresado
            for(Cliente c : cr.getAll()){
                if (c.getUsuario().equalsIgnoreCase(usuario)) {
                    //Si coincide me traigo el Cliente entero a partir del usuario
                    usuarioCorrecto = true;
                    
                    Cliente cl = cr.getByUsuario(usuario);
                    
                    //Consulto si la pass ingresada es correcta
                    if (cl.getPassword().equalsIgnoreCase(pass)) {
                        passCorrecta = true;
                        
                        clienteAcceso = cl;
                        //Abro la ventana principal y seteo su atributo para que 
                        //tenga los datos del Cliente que inicio sesion
                        Index index = new Index();
                        index.setVisible(true);
                        this.dispose();
                        return;
                    }
                }
            }
            
            if (usuarioCorrecto) {
                JOptionPane.showMessageDialog(this, "Contraseña incorrecta");
            } else {
                JOptionPane.showMessageDialog(this, "El usuario no existe");
            }
        }
    }//GEN-LAST:event_btnLogInActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        // Evento Admin
        AdminLogin admin = new AdminLogin();
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnRecuperarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperarContraseñaActionPerformed
        // Evento recuperar contraseña
        RecuperacionContraseña rc = new RecuperacionContraseña();
        rc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRecuperarContraseñaActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        // Compruebo que no hayan espacios
        if (evt.getKeyChar() == KeyEvent.VK_SPACE) {
            evt.consume();
            lblErrorUsuario.setText("No se admiten espacios");
        } else {
            lblErrorUsuario.setText("");
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    public Cliente getClienteAcceso() {
        return clienteAcceso;
    }

    private void setClienteAcceso(Cliente clienteAcceso) {
        this.clienteAcceso = clienteAcceso;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnLogIn;
    private javax.swing.JButton btnRecuperarContraseña;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblErrorPass;
    private javax.swing.JLabel lblErrorUsuario;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
