package co.edu.inmobiliaria.backendverkev.dtos;

import co.edu.inmobiliaria.backendverkev.dominio.Compra;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaCompra;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaVenta;
import co.edu.inmobiliaria.backendverkev.dominio.Venta;

import java.text.SimpleDateFormat;
import java.util.Optional;

public class VentaDTO {
    private int id;
    private String fecha_venta;
    private Double monto;
    private int id_propietario;
    private String propietario;
    private int id_comercial;
    private String comercial;

    public VentaDTO() { }

    public VentaDTO(Venta venta) {
        this.id = venta.getId();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaS = formato.format(venta.getFecha());
        this.fecha_venta = fechaS.split(" ")[0];
        int lastItemIndex = venta.getInmueble().getAvaluoList().size() - 1;
        this.monto = venta.getInmueble().getAvaluoList().get(lastItemIndex).getPrecio();
        this.id_propietario = venta.getInmueble().getPersona().getId();
        this.propietario = venta.getInmueble().getPersona().getNombre();
        Optional<PersonaVenta> comercial = venta.getPersonaVentaList().stream()
                .filter(pc -> pc.getPersona().getTipoPersona().getDescripcion().equalsIgnoreCase("Comercial"))
                .findFirst();
        if (comercial.isPresent()) {
            this.id_comercial = comercial.get().getPersona().getId();
            this.comercial = comercial.get().getPersona().getNombre();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public int getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getId_comercial() {
        return id_comercial;
    }

    public void setId_comercial(int id_comercial) {
        this.id_comercial = id_comercial;
    }

    public String getComercial() {
        return comercial;
    }

    public void setComercial(String comercial) {
        this.comercial = comercial;
    }
}
