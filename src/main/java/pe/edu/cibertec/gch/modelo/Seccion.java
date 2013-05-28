package pe.edu.cibertec.gch.modelo;

/**
 * Instancia de un programa que va a ser dictado por un profesor.
 */
public class Seccion {

    private long id;
    private Profesor profesor;
    private Programa programa;
    private EstadoSeccion estado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public EstadoSeccion getEstado() {
        return estado;
    }

    public void setEstado(EstadoSeccion estado) {
        this.estado = estado;
    }
}
