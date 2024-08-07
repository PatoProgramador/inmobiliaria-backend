package co.edu.inmobiliaria.backendverkev.dtos;

import co.edu.inmobiliaria.backendverkev.dominio.Citas;
import co.edu.inmobiliaria.backendverkev.dominio.Persona;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaCita;

import java.text.SimpleDateFormat;
import java.util.Optional;

public class CitaDTO {
    private Long id;
    private String fecha_de_cita;
    private String dirrecion_inmueble;
    private String descripcion;
    private int id_propietario;
    private String propietario;
    private String correo_propietario;
    private String telefono_propietario;
    private int id_comercial;
    private String comercial;
    private String correo_comercial;
    private String telefono_comercial;

    public CitaDTO(Citas citas) {
        this.id = Long.valueOf(citas.getId());
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaS = formato.format(citas.getFecha());
        this.fecha_de_cita = fechaS.split(" ")[0];
        this.dirrecion_inmueble = citas.getInmueble().getDireccion();
        this.id_propietario = citas.getInmueble().getPersona().getId();
        this.propietario = citas.getInmueble().getPersona().getNombre();
        this.correo_propietario = citas.getInmueble().getPersona().getCorreo();
        this.telefono_propietario = citas.getInmueble().getPersona().getTelefono();
        this.descripcion = citas.getDescripcion();
        if (citas.getPersonaCitaList() != null) {
            Optional<PersonaCita> comercial = citas.getPersonaCitaList().stream()
                    .filter(pc -> pc.getPersona().getTipoPersona().getDescripcion().equalsIgnoreCase("Comercial"))
                    .findFirst();
            if (comercial.isPresent()) {
                this.id_comercial = comercial.get().getPersona().getId();
                this.comercial = comercial.get().getPersona().getNombre();
                this.correo_comercial = comercial.get().getPersona().getCorreo();
                this.telefono_comercial = comercial.get().getPersona().getTelefono();
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha_de_cita() {
        return fecha_de_cita;
    }

    public void setFecha_de_cita(String fecha_de_cita) {
        this.fecha_de_cita = fecha_de_cita;
    }

    public String getDirrecion_inmueble() {
        return dirrecion_inmueble;
    }

    public void setDirrecion_inmueble(String dirrecion_inmueble) {
        this.dirrecion_inmueble = dirrecion_inmueble;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getComercial() {
        return comercial;
    }

    public void setComercial(String comercial) {
        this.comercial = comercial;
    }

    public int getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    public int getId_comercial() {
        return id_comercial;
    }

    public void setId_comercial(int id_comercial) {
        this.id_comercial = id_comercial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCorreo_propietario() {
        return correo_propietario;
    }

    public void setCorreo_propietario(String correo_propietario) {
        this.correo_propietario = correo_propietario;
    }

    public String getTelefono_propietario() {
        return telefono_propietario;
    }

    public void setTelefono_propietario(String telefono_propietario) {
        this.telefono_propietario = telefono_propietario;
    }

    public String getCorreo_comercial() {
        return correo_comercial;
    }

    public void setCorreo_comercial(String correo_comercial) {
        this.correo_comercial = correo_comercial;
    }

    public String getTelefono_comercial() {
        return telefono_comercial;
    }

    public void setTelefono_comercial(String telefono_comercial) {
        this.telefono_comercial = telefono_comercial;
    }
}
