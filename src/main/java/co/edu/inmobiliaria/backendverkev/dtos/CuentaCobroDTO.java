package co.edu.inmobiliaria.backendverkev.dtos;

import co.edu.inmobiliaria.backendverkev.dominio.CuentaCobro;

public class CuentaCobroDTO {
    private int id;
    private String cuenta;
    private Double monto;
    private int analisis_riesgo_id;
    private String analisis_riesgo;
    private int inmueble_id_compra;
    private String inmueble_compra;
    private int inmueble_arriendo_id;
    private String inmueble_arriendo;

    public CuentaCobroDTO() {}

    public CuentaCobroDTO(CuentaCobro cuentaCobro) {
        this.id = cuentaCobro.getId();
        this.cuenta = cuentaCobro.getCuenta();
        this.monto = cuentaCobro.getMonto();
        if (cuentaCobro.getAnalisisRiesgoList().size() > 0) {
            int lastIn = cuentaCobro.getAnalisisRiesgoList().size() - 1;
            this.analisis_riesgo_id = cuentaCobro.getAnalisisRiesgoList().get(lastIn).getId();
            this.analisis_riesgo = cuentaCobro.getAnalisisRiesgoList().get(lastIn).getDescripcion();
        }
        if (cuentaCobro.getCompraList().size() > 0) {
            int lastIn = cuentaCobro.getCompraList().size() - 1;
            this.inmueble_id_compra = cuentaCobro.getCompraList().get(lastIn).getInmueble().getId();
            this.inmueble_compra = cuentaCobro.getCompraList().get(lastIn).getInmueble().getDireccion();
        }
        if (cuentaCobro.getArriendoList().size() > 0) {
            int lastIn = cuentaCobro.getArriendoList().size() - 1;
            this.inmueble_arriendo_id = cuentaCobro.getArriendoList().get(lastIn).getInmueble().getId();
            this.inmueble_arriendo = cuentaCobro.getArriendoList().get(lastIn).getInmueble().getDireccion();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public int getAnalisis_riesgo_id() {
        return analisis_riesgo_id;
    }

    public void setAnalisis_riesgo_id(int analisis_riesgo_id) {
        this.analisis_riesgo_id = analisis_riesgo_id;
    }

    public String getAnalisis_riesgo() {
        return analisis_riesgo;
    }

    public void setAnalisis_riesgo(String analisis_riesgo) {
        this.analisis_riesgo = analisis_riesgo;
    }

    public int getInmueble_id_compra() {
        return inmueble_id_compra;
    }

    public void setInmueble_id_compra(int inmueble_id_compra) {
        this.inmueble_id_compra = inmueble_id_compra;
    }

    public String getInmueble_compra() {
        return inmueble_compra;
    }

    public void setInmueble_compra(String inmueble_compra) {
        this.inmueble_compra = inmueble_compra;
    }

    public int getInmueble_arriendo_id() {
        return inmueble_arriendo_id;
    }

    public void setInmueble_arriendo_id(int inmueble_arriendo_id) {
        this.inmueble_arriendo_id = inmueble_arriendo_id;
    }

    public String getInmueble_arriendo() {
        return inmueble_arriendo;
    }

    public void setInmueble_arriendo(String inmueble_arriendo) {
        this.inmueble_arriendo = inmueble_arriendo;
    }
}
