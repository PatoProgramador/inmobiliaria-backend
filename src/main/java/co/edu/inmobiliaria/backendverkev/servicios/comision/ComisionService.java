package co.edu.inmobiliaria.backendverkev.servicios.comision;

import co.edu.inmobiliaria.backendverkev.dominio.Comisiones;
import co.edu.inmobiliaria.backendverkev.dominio.Venta;
import co.edu.inmobiliaria.backendverkev.dtos.ComisionDTO;

import java.util.List;

public interface ComisionService {
    List<ComisionDTO> traerComisionesPorVendedor(Long idComercial);
    Comisiones crearComisiones(Venta venta);
}
