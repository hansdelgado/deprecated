/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.exception;

/**
 *
 * @author JAVA_MJ
 */
public class ProgramaSinDatoObligatorio extends Exception{
    
    private String titulo;

    public ProgramaSinDatoObligatorio(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
    
       
        
    
}
