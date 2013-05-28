package pe.edu.cibertec.gch.modelo;

/**
 * Situacion en que se encuentra un dictado de un programa (seccion).
 */
public enum EstadoSeccion {

    /**
     * El programa esta siendo difundido, se inscriben los alumnos.
     */
    Convocatoria,
    /**
     * Solo requiere una fecha de inicio, se pueden seguir inscribiendo.
     */
    PendienteInicio,
    /**
     * Las clases han sido iniciadas.
     */
    Iniciada,
    /**
     * Las clases han sido suspendidas hasta nuevo aviso.
     */
    Suspendida,
    /**
     * Las clases se suspenden y seran reemplazadas por otras.
     */
    Truncada,
    /**
     * La seccion continua luego de haber sido suspendida o cambiada de
     * profesor.
     */
    Modificada,
    /**
     * El profesor ha sido cambiado.
     */
    ProfesorCambiado,
    /**
     * Terminaron las clases del programa.
     */
    Finalizada
}
