package pe.edu.cibertec.gch.modelo;

import java.io.Serializable;

/**
 * Ambiente que contiene equipos necesarios para dictar clases.
 */
public class Laboratorio implements Serializable{

    private String codigo;
    private String nombre;
    private String descripcion;
    private String local;
    private String pabellon;
    private String salon;
    private int capacidad;
    private EstadoLaboratorio estado;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Laboratorio conCodigo(String codigo) {
        setCodigo(codigo);
        return this;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Laboratorio conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Laboratorio conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }
    
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
    public Laboratorio conLocal(String local) {
        this.local = local;
        return this;
    }

    public String getPabellon() {
        return pabellon;
    }

    public void setPabellon(String pabellon) {
        this.pabellon = pabellon;
    }

    public Laboratorio conPabellon(String pabellon) {
        this.pabellon = pabellon;
        return this;
    }
    
    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }
    
    public Laboratorio conSalon(String salon) {
        this.salon = salon;
        return this;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public Laboratorio conCapacidad(int capacidad) {
        this.capacidad = capacidad;
        return this;
    }

    public EstadoLaboratorio getEstado() {
        return estado;
    }

    public void setEstado(EstadoLaboratorio estado) {
        this.estado = estado;
    }
    
    public Laboratorio conEstado(EstadoLaboratorio estado) {
        this.estado = estado;
        return this;
    }
}
