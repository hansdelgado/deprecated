package pe.edu.cibertec.gch.modelo;

/**
 * Rango horario de dictado de un curso.
 */
public class Horario {

    private String codigo;
    private String descripcion;
    /**
     * Momento de inicio del horario en minutos
     */
    private int momentoInicio;
    /**
     * Momento de fin del horario en minutos
     */
    private int momentoFin;
    private EstadoActividad estado;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMomentoInicio() {
        return momentoInicio;
    }

    public void setMomentoInicio(int momentoInicio) {
        this.momentoInicio = momentoInicio;
    }

    public int getMomentoFin() {
        return momentoFin;
    }

    public void setMomentoFin(int momentoFin) {
        this.momentoFin = momentoFin;
    }

    public EstadoActividad getEstado() {
        return estado;
    }

    public void setEstado(EstadoActividad estado) {
        this.estado = estado;
    }
}
