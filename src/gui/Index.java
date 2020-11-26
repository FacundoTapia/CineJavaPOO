package gui;

import connectors.Connector;
import entidades.Cliente;
import entidades.Detalle;
import entidades.Pelicula;
import entidades.Sala;
import enums.TipoSala;
import java.awt.event.ItemEvent;
import repositories.interfaces.I_RelacionRepository;
import repositories.jdbc.RelacionRepository;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import repositories.interfaces.I_ClienteRepository;
import repositories.interfaces.I_DetalleRepository;
import repositories.interfaces.I_EntradaRepository;
import repositories.interfaces.I_PeliculaRepository;
import repositories.interfaces.I_SalaRepository;
import repositories.jdbc.ClienteRepository;
import repositories.jdbc.DetalleRepository;
import repositories.jdbc.EntradaRepository;
import repositories.jdbc.PeliculaRepository;
import repositories.jdbc.SalaRepository;

public class Index extends javax.swing.JFrame {
    private static Cliente sesionActual;
    private Connection conn = Connector.getConnection();
    private I_RelacionRepository rr = new RelacionRepository(conn);
    private I_PeliculaRepository pr = new PeliculaRepository(conn);
    private I_DetalleRepository dr = new DetalleRepository(conn);    
    private I_ClienteRepository cr = new ClienteRepository(conn);
    private I_SalaRepository sr = new SalaRepository(conn);
    
    public Index() {
        initComponents();
        this.setLocationRelativeTo(this);
        obtenerSesionCliente();
        cargarCartelera(1);
    }

    private void obtenerSesionCliente() {
        sesionActual = cr.getById(Login.clienteAcceso.getId());
        btnUsuario.setText(sesionActual.getUsuario());
    }

    private void cargarCartelera(int codCartelera) {
        //inicio cmbCartelera
        cmbCartelera.removeAllItems();
        
        cmbCartelera.addItem("Seleccione una pelicula...");
        
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
    
    private void cargarCmbHorario(LocalDate fecha, String titulo){
        cmbHorariosPelicula.removeAllItems();
        
        for(Detalle d: dr.getDetallesByFechaYTitulo(fecha, titulo)){
            cmbHorariosPelicula.addItem(d.getHorario());
        }
    }
    
    private void cargarLblEntradasDisponibles(LocalDate fecha, LocalTime horario, String titulo){
        //Obtengo el detalle mediante la fecha y comparo si existe una funcion a la hora
        //pasada
        Detalle de = new Detalle();
        
        for(Detalle d : dr.getDetallesByFechaYTitulo(fecha, titulo)){
            if (d.getHorario().equals(horario)) {
                de = d;
            }
        }
        
        lblEntradasDisponibles.setText(String.valueOf(de.getEntradasDisponibles()));
        
        Sala sala = sr.getByNumero(de.getNroSala());
        System.out.println("tiposala: " + sala.getTipoSala());
        
        cmbTipoEntrada.removeAllItems();
        
        cmbTipoEntrada.addItem(sala.getTipoSala());
        
    }
    
    private void cargarTxaDescripcion(String titulo){
        Pelicula p = pr.getByTitulo(titulo);
        
        txaDescripcion.setLineWrap(true);
        txaDescripcion.setWrapStyleWord(true);
        txaDescripcion.setText(p.getDescripcion());
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
        cmbFechasPelicula = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblEntradasDisponibles = new javax.swing.JLabel();
        btnUsuario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDescripcion = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        cmbTipoEntrada = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Cartelera");

        cmbCartelera.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCarteleraItemStateChanged(evt);
            }
        });
        cmbCartelera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCarteleraActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Cantidad de Entradas");

        txtCantidadEntradas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadEntradasKeyTyped(evt);
            }
        });

        btnComprar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        cmbHorariosPelicula.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbHorariosPeliculaItemStateChanged(evt);
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

        cmbFechasPelicula.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFechasPeliculaItemStateChanged(evt);
            }
        });
        cmbFechasPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFechasPeliculaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Fechas");

        jLabel2.setText("Entradas disponibles: ");

        btnUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUsuario.setForeground(new java.awt.Color(255, 0, 51));
        btnUsuario.setText("Usuario");
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        txaDescripcion.setEditable(false);
        txaDescripcion.setColumns(20);
        txaDescripcion.setRows(5);
        jScrollPane1.setViewportView(txaDescripcion);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Tipo de Entrada");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(cmbCartelera, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblEntradasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(cmbFechasPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(cmbTipoEntrada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(lblPortada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(101, 101, 101)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btnUsuario)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmbTipoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCantidadEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEntradasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblPortada, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
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
        //System.out.println("actionPerformed: "+cmbFechasPelicula.getItemAt(cmbFechasPelicula.getSelectedIndex()));
        cargarCmbHorario(
            cmbFechasPelicula.getItemAt(cmbFechasPelicula.getSelectedIndex()),
            cmbCartelera.getItemAt(cmbCartelera.getSelectedIndex())
        );
    }//GEN-LAST:event_cmbFechasPeliculaActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        // Evento Comprar Entradas
        if (txtCantidadEntradas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la cantidad de entradas que desea comprar");
            return;
        }
        
        //Obtengo el detalle necesario para la construccion de la entrada.
        //Traigo el detalle que cumpla con la fecha y hora seleccionadas en los cmb.
        LocalDate fechaSeleccionada = cmbFechasPelicula.getItemAt(cmbFechasPelicula.getSelectedIndex());
        LocalTime horarioSeleccionado = cmbHorariosPelicula.getItemAt(cmbHorariosPelicula.getSelectedIndex());
        
        System.out.println("fechaSeleccionada: " + fechaSeleccionada);
        System.out.println("horarioSeleccionada: " + horarioSeleccionado);
        
        Detalle detalleEntrada = dr.getByFechaYHorario(fechaSeleccionada, horarioSeleccionado);
        
        System.out.println("detalleEntrada: " + detalleEntrada);
        
        if (detalleEntrada.getHorario().equals(horarioSeleccionado)) {
            List listaEntradasGeneradas = cr.comprar(sesionActual, detalleEntrada, Integer.parseInt(txtCantidadEntradas.getText()));
            
            listaEntradasGeneradas.forEach(System.out::println);
            
            lblPortada.setText(listaEntradasGeneradas.toString());
            cargarLblEntradasDisponibles(fechaSeleccionada, horarioSeleccionado, cmbCartelera.getItemAt(cmbCartelera.getSelectedIndex()));
        } else {
            JOptionPane.showMessageDialog(this, "Hay un error con los datos, no fue posible crear la entrad");
        }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void cmbHorariosPeliculaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbHorariosPeliculaItemStateChanged
        // Evento Item cambio de estado
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cargarLblEntradasDisponibles(cmbFechasPelicula.getItemAt(cmbFechasPelicula.getSelectedIndex()), 
                                         (LocalTime)evt.getItem(),
                                         cmbCartelera.getItemAt(cmbCartelera.getSelectedIndex()));
            
            txtCantidadEntradas.setText("");
        }
    }//GEN-LAST:event_cmbHorariosPeliculaItemStateChanged

    private void cmbFechasPeliculaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFechasPeliculaItemStateChanged
        // Evento cambio de estado de item
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            //cargarCmbFecha(String.valueOf(evt.getItem()));
        }
    }//GEN-LAST:event_cmbFechasPeliculaItemStateChanged

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        // Evento Estadisticas de Cliente
        I_EntradaRepository er = new EntradaRepository(conn);
        
        System.out.println(er.getByCliente(sesionActual));

        InfoCliente infoCliente = new InfoCliente();
        infoCliente.setCliente(sesionActual);
        infoCliente.setVisible(true);
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void cmbCarteleraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCarteleraItemStateChanged
        // Evento cambio de estado
        String titulo = "";
        
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            titulo = String.valueOf(evt.getItem());
            cargarTxaDescripcion(titulo);
        }
    }//GEN-LAST:event_cmbCarteleraItemStateChanged

    private void txtCantidadEntradasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadEntradasKeyTyped
        // Validacion de la entrada de datos
        char caracterIngresado = evt.getKeyChar();
        
        if (caracterIngresado < '0' || caracterIngresado > '9' && caracterIngresado != '\b' /*BACK_SPACE*/)  {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadEntradasKeyTyped
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
    private javax.swing.JButton btnUsuario;
    private javax.swing.JComboBox<String> cmbCartelera;
    private javax.swing.JComboBox<LocalDate> cmbFechasPelicula;
    private javax.swing.JComboBox<LocalTime> cmbHorariosPelicula;
    private javax.swing.JComboBox<Enum> cmbTipoEntrada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEntradasDisponibles;
    private javax.swing.JLabel lblPortada;
    private javax.swing.JTextArea txaDescripcion;
    private javax.swing.JTextField txtCantidadEntradas;
    // End of variables declaration//GEN-END:variables

    public static Cliente getSesionActual() {
        return sesionActual;
    }

    public void setSesionActual(Cliente sesionActual) {
        this.sesionActual = sesionActual;
    }
}