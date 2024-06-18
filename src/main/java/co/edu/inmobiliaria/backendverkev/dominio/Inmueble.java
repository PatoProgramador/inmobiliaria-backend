package co.edu.inmobiliaria.backendverkev.dominio;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name= "inmuebles")
public class Inmueble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String detalles;

    private String direccion;

    private Timestamp hora_creacion;

    private Boolean disponible;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @OneToMany(mappedBy = "inmueble", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Arriendo> arriendoList;

    @OneToMany(mappedBy = "inmueble", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AnalisisRiesgo> analisisRiesgoList;

    @OneToMany(mappedBy = "inmueble", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Avaluo> avaluoList;

    @OneToMany(mappedBy = "inmueble", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Citas> citasList;

    @OneToMany(mappedBy = "inmueble", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Venta> ventaList;

    @OneToMany(mappedBy = "inmueble", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Compra> compraList;

    public Inmueble() {}

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Timestamp getHora_creacion() {
        return hora_creacion;
    }

    public void setHora_creacion(Timestamp hora_creacion) {
        this.hora_creacion = hora_creacion;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Arriendo> getArriendoList() {
        return arriendoList;
    }

    public void setArriendoList(List<Arriendo> arriendoList) {
        this.arriendoList = arriendoList;
    }

    public List<AnalisisRiesgo> getAnalisisRiesgoList() {
        return analisisRiesgoList;
    }

    public void setAnalisisRiesgoList(List<AnalisisRiesgo> analisisRiesgoList) {
        this.analisisRiesgoList = analisisRiesgoList;
    }

    public List<Avaluo> getAvaluoList() {
        return avaluoList;
    }

    public void setAvaluoList(List<Avaluo> avaluoList) {
        this.avaluoList = avaluoList;
    }

    public List<Citas> getCitasList() {
        return citasList;
    }

    public void setCitasList(List<Citas> citasList) {
        this.citasList = citasList;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }
}
