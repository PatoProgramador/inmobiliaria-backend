package co.edu.inmobiliaria.backendverkev.inputdtos;

import co.edu.inmobiliaria.backendverkev.dominio.Inmueble;

public class InmubleInputDTO {
    private String detalles;
    private String direccion;
    private Boolean disponible;

    public InmubleInputDTO() {}
    public InmubleInputDTO(Inmueble inmueble) {
        this.detalles = inmueble.getDetalles();
        this.direccion = inmueble.getDireccion();
        if (inmueble.getDisponible() != null) {
            this.disponible = disponible;
        } else {
            this.disponible = null;
        }
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getDireccion() {
        return direccion;
    }
}
