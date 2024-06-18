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
}
