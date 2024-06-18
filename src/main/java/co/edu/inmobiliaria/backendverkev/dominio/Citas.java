package co.edu.inmobiliaria.backendverkev.dominio;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name= "citas")
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descripcion;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_inmueble")
    private Inmueble inmueble;

    @OneToMany(mappedBy = "citas", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PersonaCita> personaCitaList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public List<PersonaCita> getPersonaCitaList() {
        return personaCitaList;
    }

    public void setPersonaCitaList(List<PersonaCita> personaCitaList) {
        this.personaCitaList = personaCitaList;
    }
}
