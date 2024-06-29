package co.edu.inmobiliaria.backendverkev.dtos;

import co.edu.inmobiliaria.backendverkev.dominio.Inmueble;

public class InmuebleDTO {
    private int id;
    private String detalles;
    private String direccion;
    private Boolean disponible;
    private int id_Propietario;
    private String propietario;
    private Double precio;

    public InmuebleDTO(Inmueble inmueble) {
        this.id = inmueble.getId();
        this.detalles = inmueble.getDetalles();
        this.direccion = inmueble.getDireccion();
        this.disponible = inmueble.getDisponible();
        this.propietario = inmueble.getPersona().getNombre();
        this.id_Propietario = inmueble.getPersona().getId();
        if (inmueble.getAvaluoList() != null && inmueble.getAvaluoList().size() > 0) {
            // asignamos el ultimo avaluo
            int lastItemIndex = inmueble.getAvaluoList().size() - 1;
            this.precio = inmueble.getAvaluoList().get(lastItemIndex).getPrecio();
        }
    }

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

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getId_Propietario() {
        return id_Propietario;
    }

    public void setId_Propietario(int id_Propietario) {
        this.id_Propietario = id_Propietario;
    }
}
