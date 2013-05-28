/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.modelo;

/**
 *
 * @author JAVA_MJ
 */
public enum TipoBusqueda {
    Completa(0),
    Parcial(1),
    NoDefinido(2);
    
    private int codigo;
    
    TipoBusqueda(int codigo) {
        this.codigo = codigo;
    }
    
    public static TipoBusqueda obtenerPorCodigo(int codigo) {
        switch(codigo) {
            case 0 : return Completa;
                
            case 1 : return Parcial;
                
            default : return NoDefinido;
        }
    }

}
