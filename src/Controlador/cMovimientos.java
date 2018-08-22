/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.conexion;
import Modelo.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Samuel Rabanales
 */
public class cMovimientos {
    
    
    
        public static ArrayList<mMovimientos> listarMovimientos(String ID){
        return mostrar("mov_Jugador",ID);
    }
    
    private static ArrayList<mMovimientos> mostrar(String a, String b){
        return consulta("SELECT mov_Movimiento as mov,\n" +
                    "	COUNT(case when (mov_Descripcion = 'A') then mov_Descripcion  else null end) as A,\n" +
                    "	COUNT(case when (mov_Descripcion = 'B') then mov_Descripcion  else null end) as B,\n" +
                    "	COUNT(case when (mov_Descripcion = 'C') then mov_Descripcion  else null end) as C,\n" +
                    "	COUNT(case when (mov_Descripcion = 'D') then mov_Descripcion  else null end) as D,\n" +
                    "	COUNT(case when (mov_Descripcion = 'F') then mov_Descripcion  else null end) as E,\n" +
                    "	COUNT(case when (mov_Descripcion = 'F') then mov_Descripcion  else null end) as F,\n" +
                    "	COUNT(case when (mov_Descripcion = 'G') then mov_Descripcion  else null end) as G,\n" +
                    "	COUNT(case when (mov_Descripcion = 'H') then mov_Descripcion  else null end) as H,\n" +
                    "	COUNT(case when (mov_Descripcion = 'I') then mov_Descripcion  else null end) as I\n" +
                    "   FROM  movimiento WHERE "+ a +" = "+ b +" GROUP BY mov\n"); 
    }
    
    private static ArrayList<mMovimientos> consulta(String sql){
        ArrayList<mMovimientos> list = new ArrayList<mMovimientos>();
        Connection cn = conexion.getConnection();
        try {
               mMovimientos mo;
               Statement stmt = cn.createStatement();
               ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    mo = new mMovimientos();
                    mo.setMov_Movimiento(rs.getInt("mov"));
                    mo.setPosicionA(rs.getString("A"));
                    mo.setPosicionB(rs.getString("B"));
                    mo.setPosicionC(rs.getString("C"));
                    mo.setPosicionD(rs.getString("D"));
                    mo.setPosicionE(rs.getString("E"));
                    mo.setPosicionF(rs.getString("F"));
                    mo.setPosicionG(rs.getString("G"));
                    mo.setPosicionH(rs.getString("H"));
                    mo.setPosicionI(rs.getString("I"));
                    
                    list.add(mo);
                }
            cn.close();
        } catch (SQLException e) {
         System.err.println(e.getMessage());
            return null;
        }
         return list;
    }
    
    
}
