package co.edu.inmobiliaria.backendverkev.dtos;

import co.edu.inmobiliaria.backendverkev.dominio.Inmueble;
import co.edu.inmobiliaria.backendverkev.dominio.Persona;
import co.edu.inmobiliaria.backendverkev.inputdtos.InmubleInputDTO;

public class InmuebleDTO {
    private int id;
    private String detalles;
    private String direccion;
    private Boolean disponible;
    private String propietario;

    public InmuebleDTO(Inmueble inmueble) {
        this.id = inmueble.getId();
        this.detalles = inmueble.getDetalles();
        this.direccion = inmueble.getDireccion();
        this.disponible = inmueble.getDisponible();
        this.propietario = inmueble.getPersona().getNombre();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}
