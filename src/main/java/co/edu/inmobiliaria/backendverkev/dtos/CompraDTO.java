package co.edu.inmobiliaria.backendverkev.dtos;

import co.edu.inmobiliaria.backendverkev.dominio.Compra;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaCita;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaCompra;

import java.text.SimpleDateFormat;
import java.util.Optional;

public class CompraDTO {
    private int id;
    private String fecha_compra;
    private String estado;
    private Double monto;
    private int id_propietario;
    private String propietario;
    private int id_comercial;
    private String comercial;
    private int id_cuenta_cobro;
    private String cuenta_cobro;

    public CompraDTO() {}

    public CompraDTO(Compra compra) {
        this.id = compra.getId();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaS = formato.format(compra.getFecha());
        this.fecha_compra = fechaS.split(" ")[0];
        if (compra.getEstado()) {
            this.estado = "pagado";
        } else {
            this.estado = "pendiente de pago";
        }
        int lastItemIndex = compra.getInmueble().getAvaluoList().size() - 1;
        this.monto = compra.getInmueble().getAvaluoList().get(lastItemIndex).getPrecio();
        this.id_propietario = compra.getInmueble().getPersona().getId();
        Optional<PersonaCompra> comercial = compra.getPersonaCompraList().stream()
                .filter(pc -> pc.getPersona().getTipoPersona().getDescripcion().equalsIgnoreCase("Comercial"))
                .findFirst();
        this.propietario = compra.getInmueble().getPersona().getNombre();
        if (comercial.isPresent()) {
            this.id_comercial = comercial.get().getPersona().getId();
            this.comercial = comercial.get().getPersona().getNombre();
        }
        this.id_cuenta_cobro = compra.getCuentaCobro().getId();
        this.cuenta_cobro = compra.getCuentaCobro().getCuenta();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public int getId_cuenta_cobro() {
        return id_cuenta_cobro;
    }

    public void setId_cuenta_cobro(int id_cuenta_cobro) {
        this.id_cuenta_cobro = id_cuenta_cobro;
    }

    public String getCuenta_cobro() {
        return cuenta_cobro;
    }

    public void setCuenta_cobro(String cuenta_cobro) {
        this.cuenta_cobro = cuenta_cobro;
    }
}
