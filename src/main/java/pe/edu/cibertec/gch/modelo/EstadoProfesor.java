package pe.edu.cibertec.gch.modelo;

/**
 * Indica el estado en que se encuentra un profesor, en terminos de ocupacion
 */
public enum EstadoProfesor {

    /**
     * El profesor se encuentra con disponibilidad para ser escogido en el
     * dictado de un curso, o se encuentra dictando.
     */
    Activo,
    /**
     * El profesor no se encuentra en la institucion o esta suspendido.
     */
    Inactivo,
    /**
     * No se sabe si puede dictar programas.
     */
    NoDeterminado,
    /**
     * El profesor se encuentra de vacaciones por el momento.
     */
    Vacaciones;

    public static EstadoProfesor obtenerSegun(String estado) {
        switch (estado) {
            case "1":
                return Activo;
            case "2":
                return Inactivo;
            case "3":
                return NoDeterminado;
            case "4":
                return Vacaciones;
            default:
                return NoDeterminado;
        }
    }
}
