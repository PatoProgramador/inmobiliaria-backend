package co.edu.inmobiliaria.backendverkev.inputdtos;

public class ArriendoInputDTO {
    private String detalles;
    private String fechaInicio;
    private String fechaFinal;
    private Double monto;

    public ArriendoInputDTO(String detalles, String fechaInicio, String fechaFinal, Double monto) {
        this.detalles = detalles;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.monto = monto;
    }

    public String getDetalles() {
        return detalles;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public Double getMonto() {
        return monto;
    }
}
