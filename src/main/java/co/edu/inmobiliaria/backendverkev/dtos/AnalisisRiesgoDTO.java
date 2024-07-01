package co.edu.inmobiliaria.backendverkev.dtos;

import co.edu.inmobiliaria.backendverkev.dominio.AnalisisRiesgo;

public class AnalisisRiesgoDTO {
    private int id;
    private String estado;
    private String descripcion;
    private int id_cuenta_cobro;
    private String cuenta_cobro;
    private Double monto;

    public AnalisisRiesgoDTO() {}

    public AnalisisRiesgoDTO(AnalisisRiesgo analisisRiesgo) {
        this.id = analisisRiesgo.getId();
        if (analisisRiesgo.getAprobado()) {
            this.estado = "Aprobado";
        } else {
            this.estado = "En revisión";
        }
        this.descripcion = analisisRiesgo.getDescripcion();
        this.id_cuenta_cobro = analisisRiesgo.getCuentaCobro().getId();
        this.cuenta_cobro = analisisRiesgo.getCuentaCobro().getCuenta();
        this.monto = analisisRiesgo.getCuentaCobro().getMonto();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCuenta_cobro() {
        return cuenta_cobro;
    }

    public void setCuenta_cobro(String cuenta_cobro) {
        this.cuenta_cobro = cuenta_cobro;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public int getId_cuenta_cobro() {
        return id_cuenta_cobro;
    }

    public void setId_cuenta_cobro(int id_cuenta_cobro) {
        this.id_cuenta_cobro = id_cuenta_cobro;
    }
}
