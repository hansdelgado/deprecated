package pe.edu.cibertec.gch.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.Curso;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author JAVA_MJ
 */
public class CursoDaoImplements implements CursoDao {

    private static ArrayList<Curso> arrcurso = new ArrayList<Curso>();

    @Override
    public Curso consultarPorCodigo(final String codigo) {
        Curso curso = null;
        //curso.setCodigo(codigo);
        //System.out.println("codigo curso:"+curso.getCodigo());
        for(int i=0;i<arrcurso.size();i++){
            if(arrcurso.get(i).getCodigo().equals(codigo)){
                curso = arrcurso.get(i);
            }
        }
        return curso;
        //int tamanio = arrcurso.size();
        //int valPos = arrcurso.indexOf(curso);
        //int valPos2 = arrcurso.indexOf(codigo);
        //return arrcurso.get(arrcurso.indexOf(codigo));
        //return arrcurso.get(arrcurso.indexOf(codigo));
    }

    @Override
    public void registrar(Curso curso) {
        arrcurso.add(curso);
    }

    @Override
    public List<Curso> listarTodos() {
        this.arrcurso=arrcurso;
        return arrcurso;
    }

    @Override
    public void eliminarPorCodigo(String codigo) {
        Curso curso = consultarPorCodigo(codigo);
        curso.setEstado(EstadoActividad.Obsoleto);
    }
    
    public Curso eliminarPorCodigoCurso(String codigo) {
        Curso curso = consultarPorCodigo(codigo);
        curso.setEstado(EstadoActividad.Obsoleto);
        return curso;
    }

    protected void borrarTodos() {
        arrcurso.clear();
    }

    @Override
    public List<Curso> listarSegun(String codigo, String nombre,String descripcion,String objetivos, String requisitos, String estado, String duracion, TipoBusqueda tipoBusquedaEnum){
//listarSegun(String nombre,String descripcion,String objetivos, String requisitos, String estado, String duracion, TipoBusqueda tipoBusquedaEnum);
        List<Curso> resultado = new LinkedList<Curso>();
        for (Curso cursos : arrcurso) {
            switch (tipoBusquedaEnum) {
                case Completa:
                    resultado.add(cursos);
                    break;
                case Parcial:
                    if (!nombre.isEmpty() && nombre.equalsIgnoreCase(cursos.getNombre())
                            || !descripcion.isEmpty() && descripcion.equalsIgnoreCase(cursos.getDescripcion())) {
                        resultado.add(cursos);
                    }
                    break;
            }
        }
        return resultado;
    }

    @Override
    public void modificarPorCodigo(Curso cur) {
        int posicion=0;
        for(int i=0;i<arrcurso.size();i++){
            if(arrcurso.get(i).getCodigo().equals(cur.getCodigo())){
                posicion = i;
            }
        }
        arrcurso.set(posicion, cur);
    }
}
