package gui;

import ar.org.centro8.curso.java.utils.swing.Validator;
import connectors.Connector;
import entidades.Cliente;
import entidades.Detalle;
import entidades.Pelicula;
import entidades.Sala;
import java.awt.Image;
import java.awt.event.ItemEvent;
import repositories.interfaces.I_RelacionRepository;
import repositories.jdbc.RelacionRepository;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import repositories.interfaces.I_ClienteRepository;
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
    private static Detalle detalleEntrada;
    public static int cantidadEntradas;
    private Connection conn = Connector.getConnection();
    private I_RelacionRepository rr = new RelacionRepository(conn);
    private I_PeliculaRepository pr = new PeliculaRepository(conn);
    private DetalleRepository dr = new DetalleRepository(conn);    
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
        
        //Mediante el codCartelera pasado por parametro, obtengo la lista
        //de los Detalles vinculados a esta cartelera. De estos extraigo
        //el codPelicula, con este busco el nombre de la pelicula, para mostrarlo
        //en el cmbCartelera
        ArrayList<String> peliculasSinRepetidos = new ArrayList<>();
        
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
        
        ArrayList<LocalDate> fechasSinRepetidos = new ArrayList<>();
        
        for(Detalle d : dr.getByPelicula(codPelicula)){
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
        
        for(Detalle d: dr.getByFechaYTitulo(fecha, titulo)){
            cmbHorariosPelicula.addItem(d.getHorario());
        }
    }
    
    private void cargarLblEntradasDisponibles(LocalDate fecha, LocalTime horario, String titulo){
        //Obtengo el detalle mediante la fecha y comparo si existe una funcion a la hora
        //pasada
        
        //creo una lista donde voy a obtener todos los dettales que cumplan con
        //el horario, fecha y titulo
        Detalle de = new Detalle();
        
        for(Detalle d : dr.getByFechaYTitulo(fecha, titulo)){
            if (d.getHorario().equals(horario)) {
                de = d;
            }
        }
        
        lblEntradasDisponibles.setText(String.valueOf(de.getEntradasDisponibles()));
        
        Sala sala = sr.getByNumero(de.getNroSala());
        
        txtTipoEntrada.setText(sala.getTipoSala().toString());
    }
    
    private void cargarTxaDescripcion(String titulo){
        Pelicula p = pr.getByTitulo(titulo);
        
        txaDescripcion.setLineWrap(true);
        txaDescripcion.setWrapStyleWord(true);
        txaDescripcion.setText(p.getDescripcion());
        
        txtGenero.setText(p.getGenero());
        txtDuracion.setText(p.getDuracion() + " Minutos");
    }
    
    private void cargarPortada(String titulo, JLabel portada){
        Pelicula p = pr.getByTitulo(titulo);
        
        String rutaPortada = p.getRutaPortada();
        
        System.out.println("rutaPortada: " + rutaPortada);
        
//        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/portadas/LaIslaSinistra.jpg"));
//        
//        ImageIcon icono = new ImageIcon(imagen.getImage().getScaledInstance(portada.getWidth(), portada.getHeight(), Image.SCALE_DEFAULT));

        ImageIcon imagen = new ImageIcon(rutaPortada);
        
        Image img = imagen.getImage().getScaledInstance(portada.getWidth(), portada.getHeight(), Image.SCALE_DEFAULT);
        
        ImageIcon icono = new ImageIcon(img);

        System.out.println("imagen: " + imagen);
        
        portada.setIcon(icono);
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
        txtTipoEntrada = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        txtDuracion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

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
        jLabel9.setText("Tipo Función");

        txtTipoEntrada.setEditable(false);
        txtTipoEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoEntradaKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("Genero");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("Duracion");

        txtGenero.setEditable(false);
        txtGenero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGeneroKeyTyped(evt);
            }
        });

        txtDuracion.setEditable(false);
        txtDuracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDuracionKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                        .addComponent(cmbHorariosPelicula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(txtCantidadEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbFechasPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addComponent(txtTipoEntrada)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnLogout)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtGenero, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(txtDuracion))
                            .addGap(140, 140, 140)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblPortada, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnUsuario)
                    .addComponent(btnLogout))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
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
                            .addComponent(txtTipoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCantidadEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEntradasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPortada, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(25, Short.MAX_VALUE))))
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
        if (txtCantidadEntradas.getText().isEmpty() || Integer.parseInt(txtCantidadEntradas.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Ingrese la cantidad de entradas que desea comprar");
            return;
        }

        Validator validator = new Validator(txtCantidadEntradas);
        if (!validator.isInteger(1, Integer.parseInt(lblEntradasDisponibles.getText()))){
            JOptionPane.showMessageDialog(this, "No hay tantas entradas disponibles!");
            return;
        }        
        
        //Obtengo el detalle necesario para la construccion de la entrada.
        //Traigo el detalle que cumpla con la fecha y hora seleccionadas en los cmb.
        LocalDate fechaSeleccionada = cmbFechasPelicula.getItemAt(cmbFechasPelicula.getSelectedIndex());
        LocalTime horarioSeleccionado = cmbHorariosPelicula.getItemAt(cmbHorariosPelicula.getSelectedIndex());
        String tituloPelicula = cmbCartelera.getItemAt(cmbCartelera.getSelectedIndex());
        
        Detalle detEntrada = dr.getByFechaTituloHorario(fechaSeleccionada, horarioSeleccionado, tituloPelicula);        

        Index.detalleEntrada = detEntrada;
        cantidadEntradas = Integer.parseInt(txtCantidadEntradas.getText());
        Compra compra = new Compra();
        compra.setVisible(true);
        
        cmbCartelera.setSelectedIndex(0);
        txtCantidadEntradas.setText("");
        txtTipoEntrada.setText("");
        lblEntradasDisponibles.setText("");
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
            System.out.println("cmbCarteleraItemStateChanged: " + evt.getItem());
            
            titulo = String.valueOf(evt.getItem());
            cargarTxaDescripcion(titulo);
            cargarPortada(titulo, lblPortada);
        }
    }//GEN-LAST:event_cmbCarteleraItemStateChanged

    private void txtCantidadEntradasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadEntradasKeyTyped
        // Validacion de la entrada de datos
        char caracterIngresado = evt.getKeyChar();
        
        if (caracterIngresado < '0' || caracterIngresado > '9' && caracterIngresado != '\b' /*BACK_SPACE*/)  {
            evt.consume();
        }        
    }//GEN-LAST:event_txtCantidadEntradasKeyTyped

    private void txtTipoEntradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoEntradaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoEntradaKeyTyped

    private void txtGeneroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGeneroKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGeneroKeyTyped

    private void txtDuracionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuracionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuracionKeyTyped

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        //Ventana recibiendo foco
        cargarLblEntradasDisponibles(cmbFechasPelicula.getItemAt(cmbFechasPelicula.getSelectedIndex()), 
                                     cmbHorariosPelicula.getItemAt(cmbHorariosPelicula.getSelectedIndex()),
                                     cmbCartelera.getItemAt(cmbCartelera.getSelectedIndex()));
    }//GEN-LAST:event_formWindowGainedFocus
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtTipoEntrada;
    // End of variables declaration//GEN-END:variables

    public static Cliente getSesionActual() {
        return sesionActual;
    }

    public void setSesionActual(Cliente sesionActual) {
        this.sesionActual = sesionActual;
    }
    
    public static Detalle getDetalleEntrada() {
        return detalleEntrada;
    }

    public static void setDetalleEntrada(Detalle aDetalleEntrada) {
        detalleEntrada = aDetalleEntrada;
    }    

    public int getCantidadEntradas() {
        return cantidadEntradas;
    }

    public void setCantidadEntradas(int cantidadEntradas) {
        this.cantidadEntradas = cantidadEntradas;
    }
}