package co.edu.inmobiliaria.backendverkev.servicios.tipoPersona;

import co.edu.inmobiliaria.backendverkev.dominio.TipoPersona;
import co.edu.inmobiliaria.backendverkev.dtos.TipoPersonaDTO;

import java.util.List;
import java.util.Optional;

public interface TipoPersonaService {
    List<TipoPersonaDTO> listar();

    Optional<TipoPersona> encontrarPorId(Long id);
}
