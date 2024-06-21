package co.edu.inmobiliaria.backendverkev.inputdtos;

public class CitaInputDTO {
    private String fecha;
    private String descripcion;

    public CitaInputDTO(String fecha, String descripcion) {
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
