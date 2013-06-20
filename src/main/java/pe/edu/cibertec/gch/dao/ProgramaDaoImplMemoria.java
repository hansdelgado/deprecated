package pe.edu.cibertec.gch.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import pe.edu.cibertec.gch.helper.GCH;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author grupoPrograma
 */
public class ProgramaDaoImplMemoria implements ProgramaDao {

    private static ArrayList<Programa> progr = new ArrayList<Programa>();

    @Override
    public Programa consultarPorCodigo(final String codigo) {
        Programa programa = new Programa();
        programa.setCodigo(codigo);
        try {
            return progr.get(progr.indexOf(programa));
        } catch (IndexOutOfBoundsException e) {
            GCH.dump("Dao:consultarPorCodigo","no exite este programa");
            return null;
        }

    }

    @Override
    public void registrar(Programa programa) {
        progr.add(programa);
    }

    @Override
    public List<Programa> listarTodos() {
        return progr;
    }

    @Override
    public void eliminarPorCodigo(String codigo) {

        // // Sin eliminar.
        // Programa programa = consultarPorCodigo(codigo);
        // programa.setEstado(EstadoActividad.Obsoleto);

        // // eliminacion mediante una busqueda propia (externa).
        // System.out.print("ingresando a eliminar");
        // int index = 0;
        // for (Programa prg : progr) {
        //     if (prg.getCodigo().compareToIgnoreCase(codigo) == 0) {
        //         System.out.print("Encontrado");
        //         progr.remove(index);
        //         break;
        //     }
        //     index++;
        // }

        // eliminación mediante busqueda interna.
        progr.remove(new Programa(codigo));

    }

    protected void borrarTodos() {
        progr.clear();
    }

    @Override
    public List<Programa> listarSegun(String titulo, String descripcion, TipoBusqueda tipoBusquedaEnum) {

        List<Programa> resultado = new LinkedList<Programa>();
        for (Programa programas : progr) {
            switch (tipoBusquedaEnum) {
                case Completa:
                    resultado.add(programas);
                    break;
                case Parcial:
                    if (!titulo.isEmpty() && titulo.equalsIgnoreCase(programas.getTitulo())
                            || !descripcion.isEmpty() && descripcion.equalsIgnoreCase(programas.getDescripcion())) {
                        resultado.add(programas);
                    }
                    break;
            }
        }
        return resultado;
    }

    @Override
    public void modificarPorCodigo(Programa pro) {
        progr.set(progr.indexOf(pro), pro);
    }
}
