package co.edu.inmobiliaria.backendverkev.dtos;

import co.edu.inmobiliaria.backendverkev.dominio.TipoIdentificacion;

public class TipoIdentificacionDTO {
    private int id;
    private String clave;
    private String descripcion;

    public TipoIdentificacionDTO(TipoIdentificacion tipoIdentificacion) {
        this.id = tipoIdentificacion.getId();
        this.clave = tipoIdentificacion.getClave();
        this.descripcion = tipoIdentificacion.getDescripcion();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}