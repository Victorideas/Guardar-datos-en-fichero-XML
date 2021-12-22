/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crearxml;

/**
 *
 * @author DAM
 */
public class CrearXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        XML llamada = new XML();
        
        Coche coche1 = new Coche("8456-TRD", "Focus", "Azul", 2018);
        llamada.crearConstructor(coche1);
        llamada.leerXML();
    }
}

 