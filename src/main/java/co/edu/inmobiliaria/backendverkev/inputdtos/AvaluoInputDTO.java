package co.edu.inmobiliaria.backendverkev.inputdtos;

public class AvaluoInputDTO {
    private Double precio;
    private String descripcion;

    public AvaluoInputDTO(Double precio, String descripcion) {
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
