package co.edu.inmobiliaria.backendverkev.dominio;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String identificacion;

    private String nombre;

    private String correo;

    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_c_tipo_persona")
    private TipoPersona tipoPersona;

    @ManyToOne
    @JoinColumn(name = "id_c_tipo_identificacion")
    private TipoIdentificacion tipoIdentificacion;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PersonaCompra> personaCompraList;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PersonaVenta> personaVentaList;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PersonaCita> personaCitaList;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PersonaArriendo> personaArriendoList;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Inmueble> inmuebleList;

    public Persona() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public List<PersonaCompra> getPersonaCompraList() {
        return personaCompraList;
    }

    public void setPersonaCompraList(List<PersonaCompra> personaCompraList) {
        this.personaCompraList = personaCompraList;
    }

    public List<PersonaVenta> getPersonaVentaList() {
        return personaVentaList;
    }

    public void setPersonaVentaList(List<PersonaVenta> personaVentaList) {
        this.personaVentaList = personaVentaList;
    }

    public List<PersonaCita> getPersonaCitaList() {
        return personaCitaList;
    }

    public void setPersonaCitaList(List<PersonaCita> personaCitaList) {
        this.personaCitaList = personaCitaList;
    }

    public List<PersonaArriendo> getPersonaArriendoList() {
        return personaArriendoList;
    }

    public void setPersonaArriendoList(List<PersonaArriendo> personaArriendoList) {
        this.personaArriendoList = personaArriendoList;
    }

    public List<Inmueble> getInmuebleList() {
        return inmuebleList;
    }

    public void setInmuebleList(List<Inmueble> inmuebleList) {
        this.inmuebleList = inmuebleList;
    }
}
