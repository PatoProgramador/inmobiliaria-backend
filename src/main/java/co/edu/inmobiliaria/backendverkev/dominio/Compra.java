package co.edu.inmobiliaria.backendverkev.dominio;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name= "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date fecha;

    private Boolean estado;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PersonaCompra> personaCompraList;

    @ManyToOne
    @JoinColumn(name = "id_inmueble")
    private Inmueble inmueble;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_cobro")
    private CuentaCobro cuentaCobro;

    public Compra() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<PersonaCompra> getPersonaCompraList() {
        return personaCompraList;
    }

    public void setPersonaCompraList(List<PersonaCompra> personaCompraList) {
        this.personaCompraList = personaCompraList;
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
