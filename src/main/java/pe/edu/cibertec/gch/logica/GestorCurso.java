/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.logica;

import java.util.ArrayList;
import java.util.List;
import pe.edu.cibertec.gch.modelo.Curso;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;
import java.util.LinkedList;

/**
 *
 * @author JAVA_MJ
 */
public class GestorCurso implements GestorBase<Curso>{
     private static ArrayList<Curso> listaCursos = new ArrayList<Curso>();
    @Override
    public void registrar(Curso curso) {
        listaCursos.add(curso);
    }
    @Override
    public List<Curso> listarTodos() {
        return listaCursos;
    }
    @Override
    public void eliminarPorCodigo(final String codigo) {
        // Al eliminar, el estado del profesor 
        // se cambia a inactivo
        Curso cursos = consultarPorCodigo(codigo);
        cursos.setEstado(EstadoActividad.Valido);
    }
    @Override
    public Curso consultarPorCodigo(final String codigo) {
        Curso curso = new Curso() {{setCodigo(codigo);}};
        return listaCursos.get(listaCursos.indexOf(curso));
    }
    
    public List<Curso> listarSegun(String codigo, String nombre, TipoBusqueda tipoBusquedaEnum) {
        List<Curso> resultado = new LinkedList();
        for (Curso curso : listaCursos) {
            switch(tipoBusquedaEnum) {
                case Completa : 
                    resultado.add(curso);
                    break;
                case Parcial :
                    if(!codigo.isEmpty() && codigo.equalsIgnoreCase(curso.getCodigo()) ||
                            !nombre.isEmpty() && nombre.equalsIgnoreCase(curso.getNombre()))
                    {
                        resultado.add(curso);
                    }
                    break;
            }
        }
        return resultado;
    }
    protected void borrarTodos() {
        listaCursos.clear();
    }
}
