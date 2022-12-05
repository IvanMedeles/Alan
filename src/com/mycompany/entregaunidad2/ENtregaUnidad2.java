package com.mycompany.entregaunidad2;
import com.eu2.Vista.Vista;
import com.eu2.Modelo.Persona;
import com.eu2.Modelo.SQLPersona;
import com.eu2.Control.Control;

/**
 *
 * @author Ivan Medeles
 */
public class ENtregaUnidad2 {

    public static void main(String[] args) {
        Vista vt   = new Vista();
        Persona t             = new Persona();
        SQLPersona qt     = new SQLPersona();
        Control ct = new Control(t,vt,qt);
    }
}
