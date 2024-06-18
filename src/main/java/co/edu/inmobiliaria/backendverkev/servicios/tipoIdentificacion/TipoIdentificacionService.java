package co.edu.inmobiliaria.backendverkev.servicios.tipoIdentificacion;

import co.edu.inmobiliaria.backendverkev.dominio.TipoIdentificacion;
import co.edu.inmobiliaria.backendverkev.dtos.TipoIdentificacionDTO;

import java.util.List;
import java.util.Optional;

public interface TipoIdentificacionService  {
    List<TipoIdentificacionDTO> listar();
    Optional<TipoIdentificacion> encontrarPorId(Long id);
}
