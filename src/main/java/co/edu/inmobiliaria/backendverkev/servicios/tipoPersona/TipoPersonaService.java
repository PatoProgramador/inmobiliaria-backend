package co.edu.inmobiliaria.backendverkev.servicios.tipoPersona;

import co.edu.inmobiliaria.backendverkev.dominio.TipoPersona;

import java.util.List;
import java.util.Optional;

public interface TipoPersonaService {
    List<TipoPersona> listar();

    Optional<TipoPersona> encontrarPorId(Long id);
}
