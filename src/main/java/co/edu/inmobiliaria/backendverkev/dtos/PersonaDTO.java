package co.edu.inmobiliaria.backendverkev.dtos;

import co.edu.inmobiliaria.backendverkev.dominio.Persona;

public class PersonaDTO {
    private int id;
    private String nombre;
    private String identificacion;
    private String telefono;
    private String correo;
    private String tipoPersona;
    private String tipoIdentificacion;
    private String sucursal;

    public PersonaDTO(Persona persona) {
        this.id = persona.getId();
        this.nombre = persona.getNombre();
        this.telefono = persona.getTelefono();
        this.correo = persona.getCorreo();
        if (persona.getTipoPersona().getDescripcion() == null) {
            this.tipoPersona = "";
        } else {
            this.tipoPersona = persona.getTipoPersona().getDescripcion();
        }
        this.tipoIdentificacion = persona.getTipoIdentificacion().getDescripcion();
        this.sucursal = persona.getSucursal().getNombre();
        this.identificacion = persona.getIdentificacion();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
}
