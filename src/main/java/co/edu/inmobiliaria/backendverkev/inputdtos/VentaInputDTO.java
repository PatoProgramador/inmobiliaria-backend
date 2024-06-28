package co.edu.inmobiliaria.backendverkev.inputdtos;

public class VentaInputDTO {
    private String fecha;
    private Double porcentajecomision;

    public VentaInputDTO(String fecha, Double porcentajecomision) {
        this.fecha = fecha;
        this.porcentajecomision = porcentajecomision;
    }

    public String getFecha() {
        return fecha;
    }

    public Double getPorcentajecomision() {
        return porcentajecomision;
    }
}
