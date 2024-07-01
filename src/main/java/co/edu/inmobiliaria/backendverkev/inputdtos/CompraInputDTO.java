package co.edu.inmobiliaria.backendverkev.inputdtos;

public class CompraInputDTO {
    private String fecha;

    public CompraInputDTO() {}

    public CompraInputDTO(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
