package co.edu.inmobiliaria.backendverkev.dtos;

import co.edu.inmobiliaria.backendverkev.dominio.Ciudad;

public class CiudadDTO {
    private int id;
    private String clave;
    private String descripcion;

    public CiudadDTO(Ciudad ciudad) {
        this.id = ciudad.getId();
        this.clave = ciudad.getClave();
        this.descripcion = ciudad.getDescripcion();
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
