/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import pe.edu.cibertec.gch.modelo.EstadoLaboratorio;
import pe.edu.cibertec.gch.modelo.Laboratorio;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author Admin
 */
public class LaboratorioDaoImplMemoria implements LaboratorioDao{
    
    private static ArrayList<Laboratorio> laboratorios = new ArrayList<Laboratorio>();
    @Override
    public List listarTodos() {
        return laboratorios;
    }

    @Override
    public void eliminarPorCodigo(final String codigo) {
          Laboratorio laboratorio = consultarPorCodigo(codigo);
        laboratorio.setEstado(EstadoLaboratorio.Deshabilitado);
    }

    @Override
    public Laboratorio consultarPorCodigo(final String codigo) {
        Laboratorio laboratorio = new Laboratorio() {{setCodigo(codigo);}};
        return laboratorios.get(laboratorios.indexOf(laboratorio));
    }

    @Override
    public void registrar(Laboratorio laboratorio) {
         laboratorios.add(laboratorio);
    }
    
    public List<Laboratorio> listarSegun(String nombre, String descripcion, String local, TipoBusqueda tipoBusquedaEnum) {
        List<Laboratorio> resultado = new LinkedList();
        for (Laboratorio lab : laboratorios) {
            switch(tipoBusquedaEnum) {
                case Completa : 
                    resultado.add(lab);
                    break;
                case Parcial :
                    if(!nombre.isEmpty() && nombre.equalsIgnoreCase(lab.getNombre()) ||
                            !descripcion.isEmpty() && descripcion.equalsIgnoreCase(lab.getDescripcion()) ||
                            !local.isEmpty() && local.equalsIgnoreCase(lab.getLocal()))
                    {
                        resultado.add(lab);
                    }
                    break;
            }
        }
        return resultado;
    }
    
    protected void borrarTodos() {
        laboratorios.clear();
    }
    
}
