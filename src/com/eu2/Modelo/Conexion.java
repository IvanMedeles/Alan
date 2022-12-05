package com.eu2.Modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Conexion {
    
    private Connection con=null;
    private static final String BD   = "Unidad3";
    private static final String DRIVER   = "com.mysql.cj.jdbc.Driver";
    private static final String USER     = "root";
    private static final String PASSWORD = "Mibeny123";
    private static final String URL      = "jdbc:mysql://localhost:3306/"+BD;
    
    public Connection getConexion() {
        
        try{
            Class.forName(DRIVER);
            con = (Connection)DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
            
        } catch(SQLException e){
            System.err.println(e);
        } catch(ClassNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}

