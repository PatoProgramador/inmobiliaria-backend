package co.edu.inmobiliaria.backendverkev.inputdtos;

public class InmubleInputDTO {
    private String detalles;
    private String direccion;
    private Boolean disponible;

    public InmubleInputDTO(String detalles, String direccion, Boolean disponible) {
        this.detalles = detalles;
        this.direccion = direccion;
        if (disponible != null) {
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

    public String getDireccion() {
        return direccion;
    }
}
