package co.edu.inmobiliaria.backendverkev.inputdtos;

public class PagoInputDTO {
    private String tipoPago;

    public PagoInputDTO() {}

    public PagoInputDTO(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }
}
