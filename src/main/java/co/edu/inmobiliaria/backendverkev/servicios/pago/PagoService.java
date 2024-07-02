package co.edu.inmobiliaria.backendverkev.servicios.pago;

import co.edu.inmobiliaria.backendverkev.dominio.Pago;
import co.edu.inmobiliaria.backendverkev.inputdtos.PagoInputDTO;

import java.util.List;

public interface PagoService {
    List<Pago> listarPagos();

    Pago crearPago(Long idCuentaCobro, Long idComprador, PagoInputDTO pagoInputDTO);
}
