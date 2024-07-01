package co.edu.inmobiliaria.backendverkev.dtos;

import co.edu.inmobiliaria.backendverkev.dominio.Arriendo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class ArriendoDTO {
    private int id;
    private String detalles;
    private String fecha_inicio;
    private String fecha_fin;
    private Double monto;
    private String detalles_inmueble;
    private String direccion;
    private String propietario;
    private String comercial_encargado;

    public ArriendoDTO(Arriendo arriendo) {
        this.id = arriendo.getId();
        this.detalles = arriendo.getDetalles();
        this.fecha_inicio = convertirFechaStringSinHora(arriendo.getFecha_inicio())[0];
        if (arriendo.getFecha_final() != null) {
            this.fecha_fin = convertirFechaStringSinHora(arriendo.getFecha_final())[0];
        }
        this.monto = arriendo.getMonto();
        this.detalles_inmueble = arriendo.getInmueble().getDetalles();
        this.direccion = arriendo.getInmueble().getDireccion();
        this.propietario = arriendo.getInmueble().getPersona().getNombre();
        if (arriendo.getPersonaArriendoList() != null) {
            Optional<String> comercial = arriendo.getPersonaArriendoList().stream()
                    .filter(pa -> pa.getPersona().getTipoPersona().getDescripcion().equalsIgnoreCase("Comercial"))
                    .map(pa -> pa.getPersona().getNombre())
                    .findFirst();
            if (comercial.isPresent()) {
                this.comercial_encargado = comercial.get();
            }
        }
    }

    public String[] convertirFechaStringSinHora(Date fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaS = formato.format(fecha);

        return fechaS.split(" ");
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

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getDetalles_inmueble() {
        return detalles_inmueble;
    }

    public void setDetalles_inmueble(String detalles_inmueble) {
        this.detalles_inmueble = detalles_inmueble;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getComercial_encargado() {
        return comercial_encargado;
    }

    public void setComercial_encargado(String comercial_encargado) {
        this.comercial_encargado = comercial_encargado;
    }
}
