package co.edu.inmobiliaria.backendverkev.servicios.sucursal;

import co.edu.inmobiliaria.backendverkev.dominio.Ciudad;
import co.edu.inmobiliaria.backendverkev.dominio.Sucursal;
import co.edu.inmobiliaria.backendverkev.dtos.SucursalDTO;

import java.util.List;
import java.util.Optional;

public interface SucursalService {
    List<SucursalDTO> listar();
    Optional<Sucursal> encontrarPorId(Long id);
}
