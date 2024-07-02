package co.edu.inmobiliaria.backendverkev.dtos;

import co.edu.inmobiliaria.backendverkev.dominio.Avaluo;

public class AvaluoDTO {
    private int id;
    private String fecha;
    private String descripcion;
    private Double precio;

    public AvaluoDTO() { }

    public AvaluoDTO(Avaluo avaluo) {
        this.id = avaluo.getId();
        this.descripcion = avaluo.getDescripcion();
        this.precio = avaluo.getPrecio();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
