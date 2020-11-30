package gui;

import ar.org.centro8.curso.java.utils.files.FileText;
import ar.org.centro8.curso.java.utils.swing.Validator;
import connectors.Connector;
import entidades.Cliente;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import repositories.jdbc.ClienteRepository;

public class Registro extends javax.swing.JFrame {
    public Registro() {
        initComponents();
        this.setLocationRelativeTo(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnRegistro = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        lblErrorNombre = new javax.swing.JLabel();
        lblErrorApellido = new javax.swing.JLabel();
        lblErrorUsuario = new javax.swing.JLabel();
        lblErrorPassword = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de Cliente");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel1.setText("Nombre");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel2.setText("Apellido");

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel3.setText("Usuario");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel4.setText("Password");

        btnRegistro.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnRegistro.setText("Registrarse");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        txtPass.setMaximumSize(new java.awt.Dimension(7, 20));

        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        btnLogin.setText("Ir al Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblErrorNombre.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblErrorNombre.setForeground(new java.awt.Color(255, 0, 51));

        lblErrorApellido.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblErrorApellido.setForeground(new java.awt.Color(255, 0, 51));

        lblErrorUsuario.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblErrorUsuario.setForeground(new java.awt.Color(255, 0, 51));

        lblErrorPassword.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblErrorPassword.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(lblErrorNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtApellido)
                                    .addComponent(lblErrorApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtUsuario)
                                    .addComponent(lblErrorUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblErrorPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jLabel4)))
                        .addGap(0, 88, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblErrorPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnLogin)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        // Evento Registro
        if (txtNombre.getText().isEmpty() ||
            txtApellido.getText().isEmpty() ||
            txtUsuario.getText().isEmpty() ||
            txtPass.getPassword().length <= 0){
            JOptionPane.showMessageDialog(this, "Rellene todos los campos");
            return;
        }
        
        Validator validator = new Validator(txtPass);
        if (!validator.lenght(8, 20)){
            lblErrorPassword.setText("Entre 8 y 20 caracteres");
            txtPass.requestFocus();
            return;
        }
        
        ClienteRepository cr = new ClienteRepository(Connector.getConnection());

        Cliente cl = new Cliente(txtNombre.getText().trim(),
                                 txtApellido.getText().trim(),
                                 txtUsuario.getText().trim(),
                                 String.valueOf(txtPass.getPassword()));

        try {
            cr.registrar(cl);

            if (cl.getId() == 0) {
                JOptionPane.showMessageDialog(this, "Este usuario ya este registrado, inicie sesión o recupere la contraseña");
                return;
            }

            mostrarInfoLogin(cl);

            Login login = new Login();
            login.setVisible(true);
            this.dispose();

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Ocurrio un error con el registro");
        }
    }//GEN-LAST:event_btnRegistroActionPerformed

    public void mostrarInfoLogin(Cliente cl) throws HeadlessException {
        //pregunto si se desea guardar el codigo de recuperacion en una archivo txt
        int respuesta = JOptionPane.showConfirmDialog(this, "Registro exitoso!! \n"
                + "¡¡IMPORTANTE!!\n"
                + "Su codigo de recuperacion es " + cl.getCodigoRecuperacion() + "\n"
                + "Guardelo en un lugar seguro ya que esto le servira para cambiar la contraseña en un futuro\n",
                "CODIGO DE RECUPERACION",
                JOptionPane.YES_OPTION);
        
        //Dependiendo la respuesta procedo...
        switch(respuesta){
            case JOptionPane.YES_OPTION:
                String user = cl.getUsuario();
                String contra = cl.getPassword();
                String contenido = 
                        "Usuario: " + user + "\n"
                      + "Contraseña: " + contra + "\n"
                      + "Codigo de recuperacion: " + cl.getCodigoRecuperacion();
                guardarEntxt(contenido);
                break;
            case JOptionPane.NO_OPTION:
                //Si no se quiere guardar se sale directamnte
                break;
            case JOptionPane.CLOSED_OPTION:
                //si cierra la ventana no hace nada
                break;
            default:
                break;
        }
    }

    private boolean guardarEntxt(String contenido) throws HeadlessException {
        //abro un File Chooser, ventana para seleccionar el directorio donde quiero guardar
        JFileChooser fc = new JFileChooser();
        //filtro para que en el File Chooser aparezcan solo los arhivos con la
        //extension que indico
        fc.setFileFilter(new FileNameExtensionFilter("Archivo de texto", "txt"));
        //indico que tiene que aparecer el boton guardar
        fc.showSaveDialog(this);
        //capturo el File que devuelve el FileChooser en una variable
        File file = fc.getSelectedFile();
        //Si el usuario decide cancelar y no guardar el archivo, lo que devuelve
        //FileChooser es un null, por ende al intentar guardar eso de todas
        //formas se produce una Exception, para evitar esto, pregunto si se
        //cumple esta condicion, de ser asi, salgo del metodo
        if (file==null) {
            return true;
        }
        //creo un nuevo archivo con el contenido el txaTexto
        new FileText(file).setText(contenido);
        return false;
    }
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // Evento ir al login
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // Evento valido que solo puedan ingresarse letras en el campo
        Validator validator = new Validator(txtNombre);
        if (!validator.soloLetras(evt) && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE){
            evt.consume();
            lblErrorNombre.setText("Este campo solo admite letras");
        } else {
            lblErrorNombre.setText("");
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        // Evento valido que solo puedan ingresarse letras en el campo
        Validator validator = new Validator(txtApellido);
        if (!validator.soloLetras(evt) && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE){
            evt.consume();
            lblErrorApellido.setText("Este campo solo admite letras");
        } else {
            lblErrorApellido.setText("");
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        // Evento valido que no se ingresen espacios
        if (evt.getKeyChar() == KeyEvent.VK_SPACE) {
            evt.consume();
            lblErrorUsuario.setText("No se admiten espacios");
        } else {
            lblErrorUsuario.setText("");
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblErrorApellido;
    private javax.swing.JLabel lblErrorNombre;
    private javax.swing.JLabel lblErrorPassword;
    private javax.swing.JLabel lblErrorUsuario;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
