package co.edu.inmobiliaria.backendverkev.servicios.ventas;

import co.edu.inmobiliaria.backendverkev.dominio.Venta;
import co.edu.inmobiliaria.backendverkev.inputdtos.CompraInputDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.VentaInputDTO;

public interface VentaService {
    Venta crearVenta(Long idPropietario, Long idComercial, Long idComprador, Long idInmueble, VentaInputDTO ventaInputDTO);
}
