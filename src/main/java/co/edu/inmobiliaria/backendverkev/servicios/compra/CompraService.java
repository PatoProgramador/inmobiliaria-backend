package co.edu.inmobiliaria.backendverkev.servicios.compra;

import co.edu.inmobiliaria.backendverkev.dominio.Compra;
import co.edu.inmobiliaria.backendverkev.dtos.CompraDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.CompraInputDTO;

public interface CompraService {
    CompraDTO crearCompra(Long idPropietario, Long idComercial, Long idComprador, Long idInmueble, CompraInputDTO compraInputDTO);
}
