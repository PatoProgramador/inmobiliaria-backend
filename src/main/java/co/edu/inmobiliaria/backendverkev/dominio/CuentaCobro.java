package co.edu.inmobiliaria.backendverkev.dominio;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "cuenta_cobro")
public class CuentaCobro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cuenta;

    private Double monto;

    @OneToMany(mappedBy = "cuentaCobro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Arriendo> personaArriendoList;

    @OneToMany(mappedBy = "cuentaCobro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pago> pagoList;

    @OneToMany(mappedBy = "cuentaCobro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Compra> compraList;

    @OneToMany(mappedBy = "cuentaCobro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AnalisisRiesgo> analisisRiesgoList;

    public CuentaCobro() {}

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

    public List<Arriendo> getPersonaArriendoList() {
        return personaArriendoList;
    }

    public void setPersonaArriendoList(List<Arriendo> personaArriendoList) {
        this.personaArriendoList = personaArriendoList;
    }

    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }

    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    public List<AnalisisRiesgo> getAnalisisRiesgoList() {
        return analisisRiesgoList;
    }

    public void setAnalisisRiesgoList(List<AnalisisRiesgo> analisisRiesgoList) {
        this.analisisRiesgoList = analisisRiesgoList;
    }
}
