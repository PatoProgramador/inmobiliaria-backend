package co.edu.inmobiliaria.backendverkev.dominio;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "c_tipo_persona")
public class TipoPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String clave;

    private String descripcion;

    @OneToMany(mappedBy = "tipoPersona", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Persona> personaList;

    public TipoPersona() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }
}

