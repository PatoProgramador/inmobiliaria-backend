package co.edu.inmobiliaria.backendverkev.servicios.persona;

import co.edu.inmobiliaria.backendverkev.dominio.Persona;
import co.edu.inmobiliaria.backendverkev.dtos.PersonaDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.PersonaInputDTO;

import java.util.List;
import java.util.Optional;

public interface PersonaService {

    List<PersonaDTO> listar();
    PersonaDTO traerPorId(Long id);

    PersonaDTO crearPersona(Long idTipoPersona, Long idTipoIdentificacion, Long idSucursal, PersonaInputDTO personaInputDTO);
    PersonaDTO modificarPersona(Long idPersona, Long idTipoPersona, Long idTipoIdentificacion, Long idSucursal, PersonaInputDTO personaInputDTO);
}
