package gui;
public class Admin extends javax.swing.JFrame {

    public Admin() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregarPelicula = new javax.swing.JButton();
        btnAgregarSala = new javax.swing.JButton();
        btnAgregarDetalle = new javax.swing.JButton();
        btnAgregarRelacion = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnAgregarCartelera = new javax.swing.JButton();
        btnEntradas = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAgregarPelicula.setText("Peliculas");
        btnAgregarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPeliculaActionPerformed(evt);
            }
        });

        btnAgregarSala.setText("Salas");
        btnAgregarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarSalaActionPerformed(evt);
            }
        });

        btnAgregarDetalle.setText("Detalles");
        btnAgregarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDetalleActionPerformed(evt);
            }
        });

        btnAgregarRelacion.setText("Relaciones");
        btnAgregarRelacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRelacionActionPerformed(evt);
            }
        });

        jButton1.setText("Volver a Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAgregarCartelera.setText("Cartelera");
        btnAgregarCartelera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCarteleraActionPerformed(evt);
            }
        });

        btnEntradas.setText("Entradas");
        btnEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradasActionPerformed(evt);
            }
        });

        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(201, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarRelacion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarSala, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarCartelera, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnAgregarPelicula)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarSala)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarDetalle)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarRelacion)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarCartelera)
                .addGap(18, 18, 18)
                .addComponent(btnEntradas)
                .addGap(18, 18, 18)
                .addComponent(btnClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPeliculaActionPerformed
        // Evento Agregar Pelicula
        Peliculas cp = new Peliculas();
        cp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarPeliculaActionPerformed

    private void btnAgregarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSalaActionPerformed
        // Evento Agregar Sala
        
        Salas cs = new Salas();
        cs.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarSalaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Evento Volver a Login
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAgregarCarteleraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCarteleraActionPerformed
        // Evento Agregar Cartelera
        
        Carteleras cc = new Carteleras();
        cc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarCarteleraActionPerformed

    private void btnAgregarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDetalleActionPerformed
        // Evento Agregar Detalle
        Detalles cd = new Detalles();
        cd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarDetalleActionPerformed

    private void btnAgregarRelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRelacionActionPerformed
        // Evento Agregar Relacion
         Relaciones cr = new Relaciones();
         cr.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_btnAgregarRelacionActionPerformed

    private void btnEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradasActionPerformed
        // Evento Ir a Entradas
        Entradas entradas = new Entradas();
        entradas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEntradasActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        // Evento Ir a Clientes
        Clientes clientes = new Clientes();
        clientes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnClientesActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCartelera;
    private javax.swing.JButton btnAgregarDetalle;
    private javax.swing.JButton btnAgregarPelicula;
    private javax.swing.JButton btnAgregarRelacion;
    private javax.swing.JButton btnAgregarSala;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEntradas;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
