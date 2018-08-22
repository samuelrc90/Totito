/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import  java.sql.Connection;
import  java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Samuel Rabanales
 */
public class conexion {
    
       public static Connection getConnection(){
       Connection con = null;
           try {
               Class.forName("com.mysql.jdbc.Driver");
               String url = "jdbc:mysql://localhost/totito";
               String user = "root";
               String pass = "";
               con = DriverManager.getConnection(url, user, pass);
           } catch (ClassNotFoundException e){
                con = null;
                    JOptionPane.showMessageDialog(null,"No se puede cargar el Drive "+ e.getMessage());
           } catch (SQLException e) {
               con = null;
               JOptionPane.showMessageDialog(null,"No conexion con la DB"+ e.getMessage());
           }
       
       return con;
       }
}
