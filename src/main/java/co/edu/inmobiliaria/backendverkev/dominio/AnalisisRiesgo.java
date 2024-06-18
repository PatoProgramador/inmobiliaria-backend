package co.edu.inmobiliaria.backendverkev.dominio;

import jakarta.persistence.*;

@Entity
@Table(name= "analisis_riesgo")
public class AnalisisRiesgo {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Boolean aprobado;

    @Column
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_inmueble")
    private Inmueble inmueble;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_cobro")
    private CuentaCobro cuentaCobro;

    public AnalisisRiesgo() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public CuentaCobro getCuentaCobro() {
        return cuentaCobro;
    }

    public void setCuentaCobro(CuentaCobro cuentaCobro) {
        this.cuentaCobro = cuentaCobro;
    }
}
