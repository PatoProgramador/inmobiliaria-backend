package co.edu.inmobiliaria.backendverkev.dominio;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name= "venta")
public class Venta {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_inmueble")
    private Inmueble inmueble;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PersonaVenta> personaVentaList;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comisiones> comisionesList;

    public Venta() {}

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

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public List<PersonaVenta> getPersonaVentaList() {
        return personaVentaList;
    }

    public void setPersonaVentaList(List<PersonaVenta> personaVentaList) {
        this.personaVentaList = personaVentaList;
    }

    public List<Comisiones> getComisionesList() {
        return comisionesList;
    }

    public void setComisionesList(List<Comisiones> comisionesList) {
        this.comisionesList = comisionesList;
    }
}
