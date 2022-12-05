package com.eu2.Control;

import com.eu2.Modelo.SQLPersona;
import com.eu2.Modelo.Persona;
import com.eu2.Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author Ivan Medeles
 */
public class Control implements ActionListener {
    private Persona persona;
    private Vista vista;
    private SQLPersona sqlPersona;
    
    public Control(){
        
    }
    
    public Control(Persona persona, Vista vista, SQLPersona sqlPersona){
        this.persona      = persona;
        this.vista = vista;
        this.sqlPersona   = sqlPersona;
        inicializarVista();
    }
    public void inicializarVista(){
        this.vista.setVisible(true);
        this.vista.jBtnAgregar.addActionListener(this);
        this.vista.jBtnBuscar.addActionListener(this);
        this.vista.jBtnEliminar.addActionListener(this);
        this.vista.jBtnModificar.addActionListener(this);
        this.vista.jBtnLimpiar.addActionListener(this);
        this.vista.jBtnSalir.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(vista.jBtnAgregar==ae.getSource()){
            persona.setNombre(vista.jTxFNombre.getText());
            persona.setContrasenha(vista.jPsFContrasenha.getText());
            persona.setControl(vista.jTxFControl.getText());
            //persona.setCiudad((String) vista.jTxFCiudad.getText());
            
            
            if(sqlPersona.registrar(persona)){
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
                
        }
        
        if(vista.jBtnModificar==ae.getSource()){
            persona.setId(Integer.parseInt(vista.jTxFId.getText()));
            
            persona.setNombre(vista.jTxFNombre.getText());
            persona.setContrasenha(vista.jPsFContrasenha.getText());
            persona.setControl(vista.jTxFControl.getText());
            //persona.setCiudad((String) vista.jTxFCiudad.getText());
            
            if(sqlPersona.modificar(persona)){
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
                
        }
        
        if(vista.jBtnEliminar==ae.getSource()){
            persona.setId(Integer.parseInt(vista.jTxFId.getText()));
                       
            if(sqlPersona.eliminar(persona)){
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
                
        }
        
        if(vista.jBtnBuscar==ae.getSource()){
            persona.setNombre(vista.jTxFNombre.getText());
                       
            if(sqlPersona.buscar(persona)){
                
                vista.jTxFId.setText(String.valueOf(persona.getId()));
                vista.jTxFNombre.setText(persona.getNombre());
               // vista.jTxFCiudad.setText(String.valueOf(persona.getCiudad()));
                vista.jPsFContrasenha.setText(String.valueOf(persona.getContrasenha()));
                vista.jTxFControl.setText(String.valueOf(persona.getControl()));
                
                        
            }else{
                JOptionPane.showMessageDialog(null, "No encontrado, error!");
                limpiar();
            }
                
        }

        if(vista.jBtnLimpiar==ae.getSource()){
            limpiar();
            
        }        
        
        if(vista.jBtnSalir==ae.getSource()){
            vista.dispose();
        }        
    }
    private void limpiar(){
        vista.jTxFId.setText(null);
        vista.jTxFNombre.setText(null);
        //vista.jTxFCiudad.setText(null);
        vista.jPsFContrasenha.setText("");
        vista.jTxFControl.setText("");
    }
}
