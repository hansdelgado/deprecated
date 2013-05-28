/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.logica;

/**
 *
 * @author JAVA_MJ
 */
public class GestorFactory {
    public static GestorLaboratorio getGestorLaboratorio(){
        return new GestorLaboratorio();
    }
}
