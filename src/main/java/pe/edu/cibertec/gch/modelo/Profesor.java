package pe.edu.cibertec.gch.modelo;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Representa a un docente de la institucion.
 */
public class Profesor implements Serializable {

    private String codigo;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private String referencia;
    private Date fechaNacimiento;
    private Genero sexo;
    private EstadoProfesor estado;
    private List<String> telefonos;
    private List<String> emails;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.matches("px[a-z]{6}\\d?")) {
            this.codigo = codigo;
        }
    }

    public Profesor conCodigo(String codigo) {
        setCodigo(codigo);
        return this;
    }
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Profesor conNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public Profesor conApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
        return this;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Profesor conApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Profesor conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Profesor conReferencia(String referencia) {
        this.referencia = referencia;
        return this;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Profesor conFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public Genero getSexo() {
        return sexo;
    }

    public void setSexo(Genero sexo) {
        this.sexo = sexo;
    }

    public Profesor conSexo(Genero sexo) {
        this.sexo = sexo;
        return this;
    }

    public EstadoProfesor getEstado() {
        return estado;
    }

    public void setEstado(EstadoProfesor estado) {
        this.estado = estado;
    }

    public Profesor conEstado(EstadoProfesor estado) {
        this.estado = estado;
        return this;
    }

    public List<String> getTelefonos() {
        return Collections.unmodifiableList(telefonos);
    }

    public void agregarTelefono(String telefono) {
        telefonos.add(telefono);
    }

    public void eliminarTelefono(String telefono) {
        telefonos.remove(telefono);
    }

    public List<String> getEmails() {
        return Collections.unmodifiableList(emails);
    }

    public void agregarEmail(String email) {
        emails.add(email);
    }

    public void eliminarEmail(String email) {
        emails.remove(email);
    }

    public boolean tieneDatosObligatorios() {
        boolean faltaCodigo = (null == getCodigo()),
                faltaNombres = (null == getNombres()),
                faltaApellidoPaterno = (null == getApellidoPaterno()),
                faltaFechaNacimiento = (null == getFechaNacimiento()),
                faltaGenero = (null == getSexo()),
                faltaEstado = (null == getEstado());
        // se puede devolver directamente el resultado de la condicion,
        if (faltaCodigo
                || faltaNombres
                || faltaApellidoPaterno
                || faltaFechaNacimiento
                || faltaGenero
                || faltaEstado) {
            return false;
        } else {
            return true;
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Profesor)) {
            return false;
        }
        final Profesor other = (Profesor) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }

}
