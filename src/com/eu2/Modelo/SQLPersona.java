package com.eu2.Modelo;

import genericos.PrepararDatosCombos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Ivan Medeles
 */
public class SQLPersona extends Conexion{
    
    public PrepararDatosCombos Preparador;
    
    public boolean registrar(Persona persona){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO persona (nombre,ciudad,control,contrasenha) VALUES(?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getCiudad());
            ps.setString(4, persona.getContrasenha());
            ps.setString(3, persona.getControl());
            ps.execute();
            return true;
            
        } catch(SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            } catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    public boolean modificar(Persona persona){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE persona SET nombre=?,ciudad=?,control=?,contrasenha=? "
                    +"WHERE id=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getCiudad());
            ps.setString(4, persona.getContrasenha());
            ps.setString(3, persona.getControl());
            ps.setInt   (5, persona.getId());
            ps.execute();
            return true;
            
        } catch(SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            } catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminar(Persona persona){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM persona WHERE id=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, persona.getId());
            ps.execute();
            return true;
            
        } catch(SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            } catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    public boolean buscar(Persona persona){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        java.sql.Connection con = getConexion();
        
        String sql = "SELECT * FROM persona WHERE nombre=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, persona.getNombre());

            rs = ps.executeQuery();
          
            
            if(rs.next()){
                persona.setId(Integer.parseInt(rs.getString("id")));
                persona.setNombre(rs.getString("nombre"));
                persona.setCiudad(rs.getString("ciudad"));
                persona.setContrasenha(rs.getString("contrasenha"));
                persona.setControl(rs.getString("control"));
                return true;
            }
                    
                    
            return false;
            
        } catch(SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            } catch(SQLException e){
                System.err.println(e);
            }
        }
    }
}

