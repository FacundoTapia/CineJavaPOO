package gui;

import connectors.Connector;
import entidades.Cliente;
import entidades.Detalle;
import entidades.Entrada;
import entidades.Pelicula;
import repositories.interfaces.I_RelacionRepository;
import repositories.jdbc.RelacionRepository;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import repositories.interfaces.I_ClienteRepository;
import repositories.interfaces.I_DetalleRepository;
import repositories.interfaces.I_PeliculaRepository;
import repositories.jdbc.ClienteRepository;
import repositories.jdbc.DetalleRepository;
import repositories.jdbc.PeliculaRepository;

public class Index extends javax.swing.JFrame {
    private Cliente sesionActual;
    private Connection conn = Connector.getConnection();
    
    private I_RelacionRepository rr = new RelacionRepository(conn);
    private I_PeliculaRepository pr = new PeliculaRepository(conn);
    private I_DetalleRepository dr = new DetalleRepository(conn);    
    private I_ClienteRepository cr = new ClienteRepository(conn);
    
    public Index() {
        initComponents();
        this.setLocationRelativeTo(this);
        obtenerSesionCliente();
        cargarCartelera(1);
    }

    private void obtenerSesionCliente() {
        sesionActual = cr.getById(Login.clienteAcceso.getId());
        lblUsuario.setText(sesionActual.getUsuario());
    }

    private void cargarCartelera(int codCartelera) {
        //inicio cmbCartelera
        cmbCartelera.removeAllItems();
        
        //Mediante el codCartelera pasado por parametro, obtengo la lista
        //de los Detalles vinculados a esta cartelera. De estos extraigo
        //el codPelicula, con este busco el nombre de la pelicula, para mostrarlo
        //en el cmbCartelera
        ArrayList<String> peliculasSinRepetidos = new ArrayList();
        
        for(Detalle d : rr.getDetalleByCodCartelera(codCartelera)){
            Pelicula p = pr.getByCodigo(d.getCodPelicula());
            
            String nombrePelicula = p.getTitulo();
            
            if (!peliculasSinRepetidos.contains(nombrePelicula)) {
                peliculasSinRepetidos.add(nombrePelicula);
            }
        }   
        
        for(String st: peliculasSinRepetidos){
            cmbCartelera.addItem(st);
        }        
    }
    
    private void cargarCmbFecha(String tituloSeleccionado){
        cmbFechasPelicula.removeAllItems();
        
        int codPelicula = pr.getByTitulo(tituloSeleccionado).getCodigo();
        
        ArrayList<LocalDate> fechasSinRepetidos = new ArrayList();
        
        for(Detalle d : dr.getDetallesByPelicula(codPelicula)){
            LocalDate ld = d.getFecha();
            
            if (!fechasSinRepetidos.contains(ld)) {
                fechasSinRepetidos.add(ld);
            }
        }

        for(LocalDate ld : fechasSinRepetidos){
            cmbFechasPelicula.addItem(ld);
        }
    }
    
    private void cargarCmbHorario(LocalDate fechaSeleccionada){
        cmbHorariosPelicula.removeAllItems();
        
        Detalle detalle = dr.getByFecha(fechaSeleccionada);
        
        cmbHorariosPelicula.addItem(detalle.getHorario());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        cmbCartelera = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtCantidadEntradas = new javax.swing.JTextField();
        btnComprar = new javax.swing.JButton();
        cmbHorariosPelicula = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        lblPortada = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblInfoPelicula = new javax.swing.JLabel();
        cmbFechasPelicula = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Cartelera");

        cmbCartelera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCarteleraActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Cantidad de Entradas");

        btnComprar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Horarios");

        btnLogout.setText("Cerrar Sesión");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        lblPortada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Sesion iniciada como ");

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 0, 0));
        lblUsuario.setText("Usuario");

        lblInfoPelicula.setText("INFO PELICULA");

        cmbFechasPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFechasPeliculaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Fechas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cmbCartelera, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInfoPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(81, 81, 81)
                                    .addComponent(cmbHorariosPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel7)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtCantidadEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbFechasPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42)
                        .addComponent(lblPortada, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lblUsuario)))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPortada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbCartelera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmbFechasPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cmbHorariosPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCantidadEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(lblInfoPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // Evento Logout
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void cmbCarteleraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCarteleraActionPerformed
        // Evento Click en cmbCartelera
        cargarCmbFecha(cmbCartelera.getItemAt(cmbCartelera.getSelectedIndex()));
    }//GEN-LAST:event_cmbCarteleraActionPerformed

    private void cmbFechasPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFechasPeliculaActionPerformed
        // Evento Click en cmbFechas
        cargarCmbHorario(cmbFechasPelicula.getItemAt(cmbFechasPelicula.getSelectedIndex()));
    }//GEN-LAST:event_cmbFechasPeliculaActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        // Evento Comprar Entradas
        
        //Obtengo el detalle necesario para la construccion de la entrada.
        //Traigo el detalle que cumpla con la fecha y hora seleccionadas en los cmb.
        LocalDate fechaSeleccionada = cmbFechasPelicula.getItemAt(cmbFechasPelicula.getSelectedIndex());
        LocalTime horarioSeleccionado = cmbHorariosPelicula.getItemAt(cmbHorariosPelicula.getSelectedIndex());
        
        System.out.println("fechaSeleccionada: " + fechaSeleccionada);
        System.out.println("horarioSeleccionada: " + horarioSeleccionado);
        
        Detalle detalleEntrada = dr.getByFecha(fechaSeleccionada);
        
        System.out.println("detalleEntrada: " + detalleEntrada);
        
        if (detalleEntrada.getHorario().equals(horarioSeleccionado)) {
            Entrada entrada  = cr.comprar(sesionActual, detalleEntrada, Integer.parseInt(txtCantidadEntradas.getText()));
            
            lblPortada.setText(entrada.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Hay un error con los datos, no fue posible crear la entrad");
        }
    }//GEN-LAST:event_btnComprarActionPerformed
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
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnLogout;
    private javax.swing.JComboBox<String> cmbCartelera;
    private javax.swing.JComboBox<LocalDate> cmbFechasPelicula;
    private javax.swing.JComboBox<LocalTime> cmbHorariosPelicula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblInfoPelicula;
    private javax.swing.JLabel lblPortada;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtCantidadEntradas;
    // End of variables declaration//GEN-END:variables

    public Cliente getSesionActual() {
        return sesionActual;
    }

    public void setSesionActual(Cliente sesionActual) {
        this.sesionActual = sesionActual;
    }
}
