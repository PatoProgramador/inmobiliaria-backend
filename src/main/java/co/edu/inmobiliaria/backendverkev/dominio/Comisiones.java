package co.edu.inmobiliaria.backendverkev.dominio;

import jakarta.persistence.*;

@Entity
@Table(name= "comisiones")
public class Comisiones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Double porcentaje;
    private Double monto;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta  venta;

    public Comisiones() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
