/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Clases.conexion;
import Modelo.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Samuel Rabanales
 */
public class cJugador {
    
    public static void ingresaJugador(mJugador jug)throws SQLException {
        String sqlNuevo = "INSERT INTO jugador(Jug_Nombre, Jug_Ganado, Jug_Empatado, Jug_Perdido) VALUE(?, 0, 0, 0)";
        Connection cn = conexion.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement(sqlNuevo);
        ps.setString(1, jug.getJug_Nombre());
        ps.executeUpdate();
        cn.close();
    }
    
   
    
    public static ArrayList<mJugador> listarJugador(String Nombre){
        return mostrar("Jug_Nombre","%"+ Nombre + "%", "like");
    }
    
    private static ArrayList<mJugador> mostrar(String a, String b, String c){
        return consulta("Select idjugador, Jug_Nombre, Jug_Ganado, Jug_Empatado, Jug_Perdido from jugador where "+a+" "+c+"'"+b+"' ORDER BY Jug_Ganado ASC"); 
    }
    
    private static ArrayList<mJugador> consulta(String sql){
        ArrayList<mJugador> list = new ArrayList<mJugador>();
        Connection cn = conexion.getConnection();
        try {
               mJugador ju;
               Statement stmt = cn.createStatement();
               ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    ju = new mJugador();
                    ju.setIdjugador(rs.getInt("idjugador"));
                    ju.setJug_Nombre(rs.getString("Jug_Nombre"));
                    ju.setJug_Ganado(rs.getInt("Jug_Ganado"));
                    ju.setJug_Empatado(rs.getInt("Jug_Empatado"));
                    ju.setJug_Perdido(rs.getInt("Jug_Perdido"));
                    list.add(ju);
                }
            cn.close();
        } catch (SQLException e) {
         System.err.println(e.getMessage());
            return null;
        }
         return list;
    }
    
   public static mJugador BuscarJugador(String Nombre) throws SQLException{
   
       String Buscar = "Select idjugador, Jug_Nombre, Jug_Ganado, Jug_Empatado, Jug_Perdido from jugador where Jug_Nombre ='"+Nombre+"'";
        Connection cn = conexion.getConnection();
        PreparedStatement ps = null;
            mJugador jug = null;
            ps = cn.prepareStatement(Buscar);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                jug = new mJugador(){};
                jug.setIdjugador(rs.getInt("idjugador"));
                jug.setJug_Nombre(Nombre);
                jug.setJug_Ganado(rs.getInt("Jug_Ganado"));
                jug.setJug_Empatado(rs.getInt("Jug_Empatado"));
                jug.setJug_Perdido(rs.getInt("Jug_Perdido"));
            
            }
       cn.close();
       ps.close();
       return jug;
   }
           
}
