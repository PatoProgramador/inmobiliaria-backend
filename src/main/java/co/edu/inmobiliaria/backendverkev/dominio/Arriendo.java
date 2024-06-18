package co.edu.inmobiliaria.backendverkev.dominio;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name= "arriendo")
public class Arriendo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String detalles;

    private Date fecha_inicio;

    private Date fecha_final;

    private Double monto;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_cobro")
    private CuentaCobro cuentaCobro;

    @ManyToOne
    @JoinColumn(name = "id_inmueble")
    private Inmueble inmueble;

    @OneToMany(mappedBy = "arriendo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PersonaArriendo> personaArriendoList;

    public Arriendo() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
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

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public List<PersonaArriendo> getPersonaArriendoList() {
        return personaArriendoList;
    }

    public void setPersonaArriendoList(List<PersonaArriendo> personaArriendoList) {
        this.personaArriendoList = personaArriendoList;
    }
}
