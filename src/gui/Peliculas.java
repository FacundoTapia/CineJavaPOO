package gui;

import ar.org.centro8.curso.java.utils.swing.Table;
import ar.org.centro8.curso.java.utils.swing.Validator;
import connectors.Connector;
import entidades.Pelicula;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.nio.charset.StandardCharsets;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import repositories.interfaces.I_PeliculaRepository;
import repositories.jdbc.PeliculaRepository;

public class Peliculas extends javax.swing.JFrame {
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de imagen", "jpg");
    private String portada;
    
    public Peliculas() {
        initComponents();
        this.setLocationRelativeTo(this);
        cargarElementos();
    }
    
    public void cargarElementos(){
        I_PeliculaRepository pr = new PeliculaRepository(Connector.getConnection());
        new Table<Pelicula>().cargar(tblPeliculas, pr.getAll());
        
        buttonGroup1.add(jrbNo);
        buttonGroup1.add(jrbSi);
        jrbNo.setSelected(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jrbSi = new javax.swing.JRadioButton();
        jrbNo = new javax.swing.JRadioButton();
        btnGuardar = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeliculas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaDescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JButton();
        btnGuardar1 = new javax.swing.JButton();
        txtRutaPortada = new javax.swing.JTextField();
        lblErrorDuracion = new javax.swing.JLabel();
        lblErrorGenero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Creacion de Peliculas");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("Titulo");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setText("Duración (mins)");

        txtDuracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDuracionKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("Genero");

        txtGenero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGeneroKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("es +18");

        jrbSi.setText("Si");

        jrbNo.setText("No");

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

        jScrollPane1.setViewportView(tblPeliculas);

        txaDescripcion.setColumns(20);
        txaDescripcion.setRows(5);
        jScrollPane2.setViewportView(txaDescripcion);

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Descripción:");

        btnBorrar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnGuardar1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnGuardar1.setText("Elegir Portada");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        txtRutaPortada.setEditable(false);

        lblErrorDuracion.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblErrorDuracion.setForeground(new java.awt.Color(255, 0, 51));

        lblErrorGenero.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblErrorGenero.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jrbSi)
                        .addGap(18, 18, 18)
                        .addComponent(jrbNo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtDuracion))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdmin, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRutaPortada)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGenero)
                            .addComponent(lblErrorDuracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblErrorGenero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(lblErrorGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jrbSi)
                            .addComponent(jrbNo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(txtRutaPortada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnBorrar))
                        .addGap(18, 18, 18)
                        .addComponent(btnAdmin))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Evento Guardar Pelicula        
        if (txtTitulo.getText().isEmpty() ||
            txtDuracion.getText().isEmpty() ||
            txtGenero.getText().isEmpty() ||
            txtRutaPortada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos");
            return;
        }
        
        Validator validator = new Validator(txtDuracion);
        if (!validator.isInteger()) {
            JOptionPane.showMessageDialog(this, "La duracion no es un numero");
            return;
        }
        
        boolean esMas18 = false;
        
        if (jrbSi.isSelected()) {
            esMas18 = true;
        }
        
        I_PeliculaRepository pr = new PeliculaRepository(Connector.getConnection());
        
        Pelicula p = new Pelicula(
                txtTitulo.getText().toUpperCase(), 
                Integer.parseInt(txtDuracion.getText()),
                txtGenero.getText(),
                esMas18,
                txaDescripcion.getText(),
                portada
        );
        
        try {
            pr.guardar(p);
            
            txtTitulo.setText("");
            txtGenero.setText("");
            txtDuracion.setText("");
            jrbNo.setSelected(true);
            txaDescripcion.setText("");
            txtRutaPortada.setText("");
            txtTitulo.requestFocus();
            
            cargarElementos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error al guardar la pelicula");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        // Evento Volver a Admin
        Admin admin = new Admin();
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // Evento Borrar 
        int filaSeleccionada = tblPeliculas.getSelectedRow();
        if (filaSeleccionada == -1) return;
        
        //Obtengo el valor del id ya que paso la fila seleccionada, el valor
        //de la primer columna que es el id
        int id = (int)tblPeliculas.getValueAt(filaSeleccionada, 0);
        
        if (JOptionPane.showConfirmDialog(this, "Desea borrar la pelicula id:"+id+"?")!=0) return;
        
        I_PeliculaRepository pr = new PeliculaRepository(Connector.getConnection());
        
        pr.borrar(pr.getByCodigo(id));
        
        cargarElementos();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        cargarPortada();
        portada = txtRutaPortada.getText();
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void txtDuracionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuracionKeyTyped
        // Evento validar numeros
        // Validacion de la entrada de datos
        char caracterIngresado = evt.getKeyChar();
        
        if (caracterIngresado < '0' || caracterIngresado > '9' && caracterIngresado != KeyEvent.VK_BACK_SPACE /*BACK_SPACE*/)  {
            evt.consume();
            lblErrorDuracion.setText("Ingresar solo minutos de duracion");
        } else {
            lblErrorDuracion.setText("");
        }
    }//GEN-LAST:event_txtDuracionKeyTyped

    private void txtGeneroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGeneroKeyTyped
        // Evento valido que solo puedan ingresarse letras en el campo
        Validator validator = new Validator(txtGenero);
        if (!validator.soloLetras(evt) && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE){
            evt.consume();
            lblErrorGenero.setText("Este campo solo admite letras");
        } else {
            lblErrorGenero.setText("");
        }
    }//GEN-LAST:event_txtGeneroKeyTyped

    public void cargarPortada() throws HeadlessException {
        // Evento Elegir portada para la pelicula con JFileChooser
        
        //Creo el file chooser y le seteo el filtro
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(filter);
        
        //Guardo el estado del fc
        int opcion = fc.showOpenDialog(this);
        
        if (opcion == JFileChooser.APPROVE_OPTION) {
            //Obtengo el nombre del archivo seleccionado
            String nombreArchivo = fc.getSelectedFile().getPath();
            
            //Obtengo su ruta
            String rutaArchivo = fc.getSelectedFile().toString();
            
            System.out.println("nombreArchivo: " + nombreArchivo);
            System.out.println("rutaArchivo: " + rutaArchivo);
            
            txtRutaPortada.setText(nombreArchivo);
        } else {
            JOptionPane.showMessageDialog(this, "No se selecciono correctamente la imagen");
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
            java.util.logging.Logger.getLogger(Peliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Peliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Peliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Peliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Peliculas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton jrbNo;
    private javax.swing.JRadioButton jrbSi;
    private javax.swing.JLabel lblErrorDuracion;
    private javax.swing.JLabel lblErrorGenero;
    private javax.swing.JTable tblPeliculas;
    private javax.swing.JTextArea txaDescripcion;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtRutaPortada;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}