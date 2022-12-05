package com.eu2.Vista;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

/**
 *
 * @author Ivan
 */
public class Vista extends JFrame {
    private JLabel jLbId;
    private JLabel jLbNombre;
    private JLabel jLbCiudad;
    private JLabel jLbContrasenha;
    private JLabel jLbControl;
       
    public JTextField jTxFId;
    public JTextField jTxFNombre;
    public JComboBox jTxFCiudad;
    public JPasswordField jPsFContrasenha;
    public JTextField jTxFControl;

    public JButton jBtnLimpiar;
    public JButton jBtnAgregar;
    public JButton jBtnModificar;
    public JButton jBtnBuscar;
    public JButton jBtnEliminar;
    public JButton jBtnSalir; 
    
    private JPanel jPGeneral;
    private JPanel jPDatos;
    private JPanel jPBotones;
    
    
    
    public Vista(){
        inicializarComponentes();

        this.setSize(1200,150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        marco();
    }
    
    public void marco(){
        jPDatos.add(jLbId);
        jPDatos.add(jTxFId);
        jPDatos.add(jLbNombre);
        jPDatos.add(jTxFNombre);
        jPDatos.add(jLbCiudad);
        jPDatos.add(jTxFCiudad);
        jPDatos.add(jLbControl);
        jPDatos.add(jTxFControl);
        jPDatos.add(jLbContrasenha);
        jPDatos.add(jPsFContrasenha);
        
        
        
        jPBotones.add(jBtnAgregar);
        jPBotones.add(jBtnModificar);
        jPBotones.add(jBtnBuscar);
        jPBotones.add(jBtnEliminar);
        jPBotones.add(jBtnLimpiar);
        jPBotones.add(jBtnSalir);
        
        jPGeneral.add(jPDatos, BorderLayout.NORTH);
        jPGeneral.add(jPBotones, BorderLayout.SOUTH);
        
        this.add(jPGeneral);
        
    }
    
    public void inicializarComponentes(){
        jLbId           = new JLabel("Id:");
        jLbNombre       = new JLabel("Nombre:");
        jLbCiudad       = new JLabel("Ciudad:");
        jLbControl      = new JLabel("Numero de Control:");
        jLbContrasenha  = new JLabel("Contraseña:");
        
        
        jTxFId          = new JTextField(6);
        jTxFNombre      = new JTextField(30);
        jTxFCiudad     = new JComboBox();
        jTxFControl     = new JTextField(8);
        jPsFContrasenha = new JPasswordField(10);
        
        
        jBtnAgregar     = new JButton("Agregar");
        jBtnModificar   = new JButton("Modificar");
        jBtnBuscar      = new JButton("Buscar");
        jBtnEliminar    = new JButton("Eliminar");
        jBtnLimpiar     = new JButton("Limpiar");
        jBtnSalir       = new JButton("Salir");
        
        jPGeneral       = new JPanel();
        jPDatos         = new JPanel();
        jPBotones       = new JPanel();
        
        jPGeneral.setLayout(new BorderLayout());
        jPDatos.setBorder(BorderFactory.createTitledBorder("Datos Generales"));
    }
}
