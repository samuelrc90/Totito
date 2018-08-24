/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Modelo.*;
import Controlador.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Samuel Rabanales
 */
public class Jugador extends javax.swing.JFrame {

        private frmPrincipal juego;
        private JOptionPane msj;
        public final int HvC = 2;
        public int tipo = 0;
        public String Nombre;
        
    /**
     * Creates new form Jugador
     */
    public Jugador(frmPrincipal juego) {
        initComponents();
         this.setLocationRelativeTo(null);
         this.juego = juego;
    }

    private Jugador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean recoger(){
        this.tipo = HvC;
        this.Nombre = txtJugador.getText();
        System.out.println(tipo + " " +Nombre);
        return  true;
    }
    public void enviarJugador(){    
    juego.recibirJugador();
    juego.updateJu();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblAceptar = new javax.swing.JButton();
        txtJugador = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        img2 = new javax.swing.JLabel();
        tbnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre del Jugador");

        lblAceptar.setText("Aceptar");
        lblAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblAceptarActionPerformed(evt);
            }
        });

        txtJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJugadorActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/persona.png"))); // NOI18N

        img2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pvspc.png"))); // NOI18N

        tbnCancelar.setText("Cancelar");
        tbnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(tbnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img2)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(img2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAceptar)
                    .addComponent(tbnCancelar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJugadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJugadorActionPerformed

    private void lblAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblAceptarActionPerformed
        // TODO add your handling code here:
        mJugador jug = null;
        if(txtJugador.getText().compareTo("") != 0){
            try {
               jug = cJugador.BuscarJugador(txtJugador.getText().trim());
               
            } catch (SQLException e) {
                 System.out.println("" + e.getMessage());
            }
                if(jug != null){
                        JOptionPane.showMessageDialog(null, "El jugador "+txtJugador.getText()+" ya esta Registrado: ");
                        txtJugador.setText("");
                        
                }else{
                        try {
                            mJugador j = new mJugador();
                            j.setJug_Nombre(txtJugador.getText());
                            cJugador.ingresaJugador(j);
                            JOptionPane.showMessageDialog(null, "Jugador Almacenado Correctamente");
                            if(recoger()){
                            
                            enviarJugador();
                            }
                            this.dispose();
                        } catch (SQLException e) {
                                 System.out.println("Erro DB"+e.getMessage());
                        }
                            }
            
           
        }else{
        JOptionPane.showMessageDialog(null, "llenar todos los campos");
        }
        
    }//GEN-LAST:event_lblAceptarActionPerformed

    private void tbnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnCancelarActionPerformed
        // TODO add your handling code here:
      //  dispose();
      
    }//GEN-LAST:event_tbnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Jugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jugador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel img2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton lblAceptar;
    private javax.swing.JButton tbnCancelar;
    private javax.swing.JTextField txtJugador;
    // End of variables declaration//GEN-END:variables
}
