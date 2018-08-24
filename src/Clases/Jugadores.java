/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.ImageIcon;

/**
 *
 * @author Samuel Rabanales
 */
public class Jugadores {
    String nombre;
    public int GANADOS, PERDIDOS, EMPATADOS;
    private ImageIcon ficha;
    
    public Jugadores(String nombre, String ruta){
        this.nombre = nombre;
        GANADOS = 0;
        PERDIDOS = 0;
        EMPATADOS = 0;
        /*Imagen por Defecto*/
        miFicha(ruta);
    }
    public void gano(){
        GANADOS ++;
    }
    
    public void perdio(){
        PERDIDOS ++;
    }
    public void empato(){
        EMPATADOS ++;
    }
/*Devuelve imagen de la ficha*/
    public ImageIcon obtnerFicha(){
         return ficha;
    }
    /*Establece ficha*/
    public void miFicha(String ruta) {
        this.ficha = new ImageIcon(this.getClass().getResource(ruta));
    }
    
}
