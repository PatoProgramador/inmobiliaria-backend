package co.edu.inmobiliaria.backendverkev.dtos;

import co.edu.inmobiliaria.backendverkev.dominio.Ciudad;
import co.edu.inmobiliaria.backendverkev.dominio.TipoPersona;

public class TipoPersonaDTO {
    private int id;
    private String clave;
    private String descripcion;

    public TipoPersonaDTO(TipoPersona tipoPersona) {
        this.id = tipoPersona.getId();
        this.clave = tipoPersona.getClave();
        this.descripcion = tipoPersona.getDescripcion();
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
