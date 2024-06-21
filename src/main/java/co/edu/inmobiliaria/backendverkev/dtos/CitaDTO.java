package co.edu.inmobiliaria.backendverkev.dtos;

import co.edu.inmobiliaria.backendverkev.dominio.Citas;

import java.text.SimpleDateFormat;
import java.util.Optional;

public class CitaDTO {
    private Long id;
    private String fecha_de_cita;
    private String dirrecion_inmueble;
    private String propietario;
    private String comercial;

    public CitaDTO(Citas citas) {
        this.id = Long.valueOf(citas.getId());
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaS = formato.format(citas.getFecha());
        this.fecha_de_cita = fechaS.split(" ")[0];
        this.dirrecion_inmueble = citas.getInmueble().getDireccion();
        this.propietario = citas.getInmueble().getPersona().getNombre();
        if (citas.getPersonaCitaList() != null) {
            Optional<String> comercial = citas.getPersonaCitaList().stream()
                    .filter(pc -> pc.getPersona().getTipoPersona().getDescripcion().equalsIgnoreCase("Comercial"))
                    .map(pc -> pc.getPersona().getNombre())
                    .findFirst();
            if (comercial.isPresent()) {
                this.comercial = comercial.get();
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
}
