/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Clases.*;
import Controlador.cJugador;
import Controlador.cMovimientos;
import Modelo.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Samuel Rabanales
 */
public class frmPrincipal extends javax.swing.JFrame {
DefaultTableModel mover;
    
    Jugador modelo;
    Jugadores jugador1, jugador2;
    AlgorimtoIA CPU;
    boolean jugando, terminado;
    
    public final int homVScpu = 2;
    public final int JUGADOR1 = 1;
    public final int JUGADOR2 = 2;    
    public boolean pensando = false;
    
    int turno = 0;
    int turnoGeneral = 0;
    
    /*Matriz Juego*/
    int[] tablero = new int[9];
    
    /*Tablero*/
    JLabel fichas[];


    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal() {
            /*llenar tablero de 0 o null*/
            Arrays.fill(tablero,0);
           
        initComponents();
         iniciarCom();
        
        this.setLocationRelativeTo(null);
        limpiar();
        updateJu();
        updateMo();   
        
    }
    
    
    public void movimiento(JLabel ficha){
  
        if(jugando){
            if(!pensando)
                ponerFicha(ficha);
            if(this.modelo.tipo == 2 && this.turno == JUGADOR2){
                pensando = true;
                ponerFichaCPU(CPU.movimiento(this.tablero));
                pensando = false;
            }   
        }
        if(terminado){
            reiniciarJuego();
            return;
        }
        
        /*se verifica si termino el juego o alguien gano*/
        if(terminado() != 0){
        }
    
    }
    /*Pone la ficha por la computador*/
    public void ponerFichaCPU(int indice){
        if(indice == -1) return;
            switch(indice){
                case 0: this.a.setIcon(jugador2.obtnerFicha()); break;
                case 1: this.b.setIcon(jugador2.obtnerFicha()); break;
                case 2: this.c.setIcon(jugador2.obtnerFicha()); break;
                case 3: this.d.setIcon(jugador2.obtnerFicha()); break;
                case 4: this.e.setIcon(jugador2.obtnerFicha()); break;
                case 5: this.f.setIcon(jugador2.obtnerFicha()); break;
                case 6: this.g.setIcon(jugador2.obtnerFicha()); break;
                case 7: this.h.setIcon(jugador2.obtnerFicha()); break;
                case 8: this.i.setIcon(jugador2.obtnerFicha()); break;         
            }
            this.tablero[indice] = 2;
            /*Cambio de Turno*/
            turno = (turno == JUGADOR1) ? JUGADOR2 : JUGADOR1;
    }
    /*pone una ficha en el tablero*/
    public void ponerFicha(JLabel ficha){
        int casilla = Integer.parseInt(""+ficha.getName().charAt(1))-1;
        
        /*comprobar si la casilla esta ocupada*/
        if(estaOcupada(casilla))
            return;
    }
    /*0 nadie gano*/
    /*1 ganan jugador 1*/
    /*2 ganan jugador 2*/
    
    public int terminado(){
 /*Filas*/       if(tablero[0] == tablero[1] && tablero[0] == tablero[2] && tablero[0] != 0)    return tablero[0];
            else if(tablero[3] == tablero[4] && tablero[3] == tablero[5] && tablero[3] != 0)    return tablero[3];
            else if(tablero[6] == tablero[7] && tablero[6] == tablero[8] && tablero[6] != 0)    return tablero[6];
/*Columnas*/else if(tablero[0] == tablero[3] && tablero[0] == tablero[6] && tablero[0] != 0)    return tablero[0];
            else if(tablero[1] == tablero[4] && tablero[1] == tablero[7] && tablero[1] != 0)    return tablero[1];
            else if(tablero[2] == tablero[5] && tablero[2] == tablero[8] && tablero[2] != 0)    return tablero[2];  
/*Digonal*/ else if(tablero[0] == tablero[4] && tablero[0] == tablero[8] && tablero[0] != 0)    return tablero[0];
            else if(tablero[2] == tablero[4] && tablero[2] == tablero[6] && tablero[2] != 0)    return tablero[2];
       
        return 0;
    }
    public boolean lleno(){
        boolean res = true;
        for(int i = 0; i < tablero.length; i++)
            if(tablero[i] == 0)
                res = false;
        return res;
    }
    /*Indica si la casilla esta ocupada*/
    public boolean estaOcupada(int casilla){
    return (tablero[casilla] != 0);
    }
    
public void recibirJugador(){
    inicioJuego();
}
public void inicioJuego(){
    
}

public void reiniciarJuego(){
    Arrays.fill(tablero, 0);
    /*borrar icono*/
    for(int i = 0; i<9; i++)
        fichas[i].setIcon(null);
    try {
        
    } catch (Exception e) {
    }
    
    /*Cambio de turno*/
    if(this.modelo.tipo == homVScpu)
        turnoGeneral = JUGADOR1;
    else
        turnoGeneral = (turnoGeneral == JUGADOR1 ) ? JUGADOR2 : JUGADOR1;
    turno = turnoGeneral;
    
    /*jugando*/
    if(turno == JUGADOR1)
        mensaje("Turno de:  "+ jugador1);
    mostrarInfo();
    jugando = true;
    terminado = false;
    
}
public  void suspenderJuego(){


}
private  void iniciarCom(){


    /*Referencia de las Etiquetas*/
     fichas = new JLabel[9];
     fichas[0] = a; fichas[1] = b; fichas[2] = c;
     fichas[3] = d; fichas[4] = e; fichas[5] = f;
     fichas[6] = g; fichas[7] = h; fichas[8] = i;
     
     for(int i = 0; i < 9; i++)
        fichas[i].setCursor( new Cursor(Cursor.HAND_CURSOR));
     
    
}
public void mostrarInfo(){
    

}

public void mensaje(String msj){
    this.lblJugador.setText(msj);
}
public void cambiarFoco(){

    

}
    
    
    
    
    public void limpiar(){
     
    
    
    }
    public void updateJu(){
        ArrayList<mJugador> res = null;
        res = cJugador.listarJugador(txtBuscar.getText());
        System.out.println(res);
     llenarJug(res);        
    }
    
    public void llenarJug(ArrayList<mJugador> list){
        Object[][] datos = new Object[list.size()][5];
        int i = 0;
        for(mJugador jug : list){
            datos[i][0] = jug.getIdjugador();
            datos[i][1] = jug.getJug_Nombre();
            datos[i][2] = jug.getJug_Ganado();
            datos[i][3] = jug.getJug_Empatado();
            datos[i][4] = jug.getJug_Perdido();
            i++;
        }
         
        tblJugadores.setModel(new javax.swing.table.DefaultTableModel(
           datos,
                new String[]{
                "ID","Nombre","G","E","P"
                }
        ){
                
                         @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
        
        });
        
    }
    public void updateMo(){
    ArrayList<mMovimientos> mov = null;
        mov =  cMovimientos.listarMovimientos(lblJugador.getText());
        System.out.println(mov);
     llenarMov(mov); 
    }
    
    public void llenarMov(ArrayList<mMovimientos> list){
         Object[][] datos = new Object[list.size()][10];
         int i = 0;
         for(mMovimientos mov : list){
            datos[i][0] = mov.getMov_Movimiento();
            datos[i][1] = mov.getPosicionA();
            datos[i][2] = mov.getPosicionB();
            datos[i][3] = mov.getPosicionC();
            datos[i][4] = mov.getPosicionD();
            datos[i][5] = mov.getPosicionE();
            datos[i][6] = mov.getPosicionF();
            datos[i][7] = mov.getPosicionG();
            datos[i][8] = mov.getPosicionH();
            datos[i][9] = mov.getPosicionI();      
            i++;
        }
        
         tblMovimientos.setModel(new javax.swing.table.DefaultTableModel(
           datos,
                new String[]{
                "Mov","A","B","C","D","E","F","G","H","I"
                }
        ){
                
                         @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
        
        });
    }
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpmPerfil = new javax.swing.JPopupMenu();
        jmiCambiar = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJugadores = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        a = new javax.swing.JLabel();
        b = new javax.swing.JLabel();
        c = new javax.swing.JLabel();
        d = new javax.swing.JLabel();
        e = new javax.swing.JLabel();
        f = new javax.swing.JLabel();
        g = new javax.swing.JLabel();
        h = new javax.swing.JLabel();
        i = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMovimientos = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        lblJugador = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        img2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jmiCambiar.setText("Cambiar Perfil");
        jmiCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCambiarActionPerformed(evt);
            }
        });
        jpmPerfil.add(jmiCambiar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblJugadores.setComponentPopupMenu(jpmPerfil);
        jScrollPane1.setViewportView(tblJugadores);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        a.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a.setToolTipText("");
        a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aMouseClicked(evt);
            }
        });

        b.setBackground(new java.awt.Color(204, 204, 255));
        b.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b.setToolTipText("");
        b.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bMouseClicked(evt);
            }
        });

        c.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c.setToolTipText("");
        c.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cMouseClicked(evt);
            }
        });

        d.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d.setToolTipText("");
        d.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dMouseClicked(evt);
            }
        });

        e.setBackground(new java.awt.Color(204, 204, 255));
        e.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        e.setToolTipText("");
        e.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        e.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eMouseClicked(evt);
            }
        });

        f.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f.setToolTipText("");
        f.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        f.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fMouseClicked(evt);
            }
        });

        g.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        g.setToolTipText("");
        g.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        g.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gMouseClicked(evt);
            }
        });

        h.setBackground(new java.awt.Color(204, 204, 255));
        h.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        h.setToolTipText("");
        h.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        h.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hMouseClicked(evt);
            }
        });

        i.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        i.setToolTipText("");
        i.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        i.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(e, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(f, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(g, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(h, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(i, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(g, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tblMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblMovimientos);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        lblJugador.setText("j");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/persona.png"))); // NOI18N

        img2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pvspc.png"))); // NOI18N

        jLabel3.setText("VS");

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Nuevo Jugador");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Juego");

        jMenuItem2.setText("Nuevo");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Finalizar");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img2))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(img2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Jugador jug = new Jugador(this);
        
        jug.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void aMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aMouseClicked
        // TODO add your handling code here:
        movimiento(a);
    }//GEN-LAST:event_aMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        updateJu();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jmiCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCambiarActionPerformed
        // TODO add your handling code here:
        int seleccion = tblJugadores.getSelectedRow();
        try {
            String Nombre, ID;
            if(seleccion == -1){
                    JOptionPane.showMessageDialog(null, "Seleccionar el Nombre de un Jugador","Aviso",JOptionPane.WARNING_MESSAGE);
            }else{
                
                ID = tblJugadores.getValueAt(seleccion,0).toString();
                Nombre = tblJugadores.getValueAt(seleccion,1).toString();
             lblJugador.setText(Nombre);
             
             
            
            }
        } catch (Exception e) {
        }
        updateMo();
    }//GEN-LAST:event_jmiCambiarActionPerformed

    private void bMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMouseClicked
        // TODO add your handling code here:
        movimiento(b);
    }//GEN-LAST:event_bMouseClicked

    private void cMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cMouseClicked
        // TODO add your handling code here:
         movimiento(c);
    }//GEN-LAST:event_cMouseClicked

    private void dMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dMouseClicked
        // TODO add your handling code here:
        movimiento(d);
    }//GEN-LAST:event_dMouseClicked

    private void eMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eMouseClicked
        // TODO add your handling code here:
         movimiento(e);
    }//GEN-LAST:event_eMouseClicked

    private void fMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fMouseClicked
        // TODO add your handling code here:
         movimiento(f);
    }//GEN-LAST:event_fMouseClicked

    private void gMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gMouseClicked
        // TODO add your handling code here:
         movimiento(g);
    }//GEN-LAST:event_gMouseClicked

    private void hMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hMouseClicked
        // TODO add your handling code here:
         movimiento(h);
    }//GEN-LAST:event_hMouseClicked

    private void iMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iMouseClicked
        // TODO add your handling code here:
         movimiento(i);
    }//GEN-LAST:event_iMouseClicked
   
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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a;
    private javax.swing.JLabel b;
    private javax.swing.JLabel c;
    private javax.swing.JLabel d;
    private javax.swing.JLabel e;
    private javax.swing.JLabel f;
    private javax.swing.JLabel g;
    private javax.swing.JLabel h;
    private javax.swing.JLabel i;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem jmiCambiar;
    private javax.swing.JPopupMenu jpmPerfil;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JTable tblJugadores;
    private javax.swing.JTable tblMovimientos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
