package co.edu.inmobiliaria.backendverkev.inputdtos;

public class VentaInputDTO {
    private String fecha;

    public VentaInputDTO() {}

    public VentaInputDTO(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

}
