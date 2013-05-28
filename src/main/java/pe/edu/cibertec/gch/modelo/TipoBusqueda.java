package pe.edu.cibertec.gch.modelo;

/**
 * Tipo de busqueda realizada
 */
public enum TipoBusqueda {
    NoDeterminada(0),
    Completa(1),
    Parcial(2);
    private int codigo;

    private TipoBusqueda(int codigo) {
        this.codigo = codigo;
    }

    public static TipoBusqueda obtenerSegun(int codigo) {
        switch(codigo) {
            case 1:
                return Completa;
            case 2:
                return Parcial;
            default:
                return NoDeterminada;
        }
    }
}
