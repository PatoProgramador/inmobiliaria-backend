package co.edu.inmobiliaria.backendverkev.dtos;

public class SucursalDTO {
    private int id;
    private String nombre;
    private String ciudad;

    public SucursalDTO(int id, String nombre, String nombreCiudad) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = nombreCiudad;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
