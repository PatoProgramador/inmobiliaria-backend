package co.edu.inmobiliaria.backendverkev.dominio;

import jakarta.persistence.*;

@Entity
@Table(name= "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tipo_pago;

    private Double monto;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_cobro")
    private CuentaCobro cuentaCobro;

    public Pago() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public CuentaCobro getCuentaCobro() {
        return cuentaCobro;
    }

    public void setCuentaCobro(CuentaCobro cuentaCobro) {
        this.cuentaCobro = cuentaCobro;
    }
}
