package pe.edu.cibertec.gch.dao;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author JAVA_MJ
 */
public class ProgramaDaoImplMemoria implements ProgramaDao {

    private static ArrayList<Programa> progr = new ArrayList<Programa>();

    @Override
    public Programa consultarPorCodigo(final String codigo) {
        Programa programa = new Programa() {
            {
                setCodigo(codigo);
            }
        };
        return progr.get(progr.indexOf(programa));
    }

    @Override
    public void registrar(Programa programa) {

        progr.add(programa);
        System.out.print("registroooooooo"
                + progr.size());
    }

    @Override
    public List<Programa> listarTodos() {
        return progr;
    }

    @Override
    public void eliminarPorCodigo(String codigo) {
        Programa programa = consultarPorCodigo(codigo);
        programa.setEstado(EstadoActividad.Obsoleto);
    }

    protected void borrarTodos() {
        progr.clear();
    }

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
}
