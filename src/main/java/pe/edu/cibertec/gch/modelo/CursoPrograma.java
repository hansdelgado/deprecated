package pe.edu.cibertec.gch.modelo;

/**
 * Curso asociado a un programa en un determinado momento.
 */
public class CursoPrograma {

    private Programa programa;
    private Curso curso;
    private EstadoActividad estado;

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public EstadoActividad getEstado() {
        return estado;
    }

    public void setEstado(EstadoActividad estado) {
        this.estado = estado;
    }
}
