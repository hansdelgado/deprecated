/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.exception;

/**
 *
 * @author hans delgado
 */
public class ProfesorNoEncontradoException extends Exception {
    
    private String nombre;
    
    public ProfesorNoEncontradoException(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
}
