package co.edu.inmobiliaria.backendverkev.dtos;

import co.edu.inmobiliaria.backendverkev.dominio.Comisiones;

import java.text.SimpleDateFormat;

public class ComisionDTO {
    private int id;
    private String fecha_venta;
    private Double porcentaje;
    private Double monto;

    public ComisionDTO() {}

    public ComisionDTO(Comisiones comisiones) {
        this.id = comisiones.getId();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaS = formato.format(comisiones.getVenta().getFecha());
        this.fecha_venta = fechaS.split(" ")[0];
        this.porcentaje = comisiones.getPorcentaje();
        this.monto = comisiones.getMonto();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
