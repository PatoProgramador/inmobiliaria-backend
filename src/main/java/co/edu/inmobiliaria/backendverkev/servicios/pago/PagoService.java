package co.edu.inmobiliaria.backendverkev.servicios.pago;

import co.edu.inmobiliaria.backendverkev.dominio.Pago;
import co.edu.inmobiliaria.backendverkev.dtos.PagoDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.PagoInputDTO;

import java.util.List;

public interface PagoService {
    List<Pago> listarPagos();

    PagoDTO crearPago(Long idCuentaCobro, Long idComprador, PagoInputDTO pagoInputDTO);
}
