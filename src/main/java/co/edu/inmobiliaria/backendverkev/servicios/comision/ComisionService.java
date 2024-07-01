package co.edu.inmobiliaria.backendverkev.servicios.comision;

import co.edu.inmobiliaria.backendverkev.dominio.Comisiones;
import co.edu.inmobiliaria.backendverkev.dominio.Venta;

public interface ComisionService {
    Comisiones crearComisiones(Venta venta);
}
