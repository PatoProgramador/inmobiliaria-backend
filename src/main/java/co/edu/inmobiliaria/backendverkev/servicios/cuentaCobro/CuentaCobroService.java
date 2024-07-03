package co.edu.inmobiliaria.backendverkev.servicios.cuentaCobro;

import co.edu.inmobiliaria.backendverkev.dominio.CuentaCobro;
import co.edu.inmobiliaria.backendverkev.dtos.CuentaCobroDTO;

import java.util.List;

public interface CuentaCobroService {
    List<CuentaCobroDTO> listarCuentasPendientesCompras(Long idPersona);
    List<CuentaCobroDTO> listarCuentasPendientesArriendo(Long idPersona);
    List<CuentaCobroDTO> listarCuentasPendientesAnalisis(Long idPersona);

    CuentaCobro encontrarPorId(Long idCuentaCobro);
    CuentaCobroDTO encontrarPorIdDTO(Long idCuentaCobro);
    CuentaCobro crearCuentaCobro(CuentaCobro cuentaCobro);
}
