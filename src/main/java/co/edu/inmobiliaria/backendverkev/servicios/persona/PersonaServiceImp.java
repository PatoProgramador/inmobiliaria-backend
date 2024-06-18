package co.edu.inmobiliaria.backendverkev.servicios.persona;

import co.edu.inmobiliaria.backendverkev.dominio.Persona;
import co.edu.inmobiliaria.backendverkev.dominio.Sucursal;
import co.edu.inmobiliaria.backendverkev.dominio.TipoIdentificacion;
import co.edu.inmobiliaria.backendverkev.dominio.TipoPersona;
import co.edu.inmobiliaria.backendverkev.dtos.PersonaDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.PersonaInputDTO;
import co.edu.inmobiliaria.backendverkev.repositorios.PersonaRepository;
import co.edu.inmobiliaria.backendverkev.repositorios.SucursalRepository;
import co.edu.inmobiliaria.backendverkev.repositorios.TipoIdentificacionRepository;
import co.edu.inmobiliaria.backendverkev.repositorios.TipoPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImp implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private TipoPersonaRepository tipoPersonaRepository;

    @Autowired
    private TipoIdentificacionRepository tipoIdentificacionRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<PersonaDTO> listar() {
        return personaRepository.findAll().stream()
                .map(p -> new PersonaDTO(p))
                .collect(Collectors.toList());
    }

    @Override
    public Persona crearPersona(Long idTipoPersona, Long idTipoIdentificacion, Long idSucursal, PersonaInputDTO personaInputDTO) {
        Persona persona = new Persona();

        Optional<TipoPersona> tipoPersona = tipoPersonaRepository.findById(idTipoPersona);

        Optional<TipoIdentificacion> tipoIdentificacion = tipoIdentificacionRepository.findById(idTipoIdentificacion);

        Optional<Sucursal> sucursal = sucursalRepository.findById(idSucursal);

        // creacion de la instancia
        persona.setIdentificacion(personaInputDTO.getIdentificacion());
        persona.setNombre(personaInputDTO.getNombre());
        persona.setCorreo(personaInputDTO.getCorreo());
        persona.setTelefono(personaInputDTO.getTelefono());

        tipoPersona.ifPresent(persona::setTipoPersona);
        tipoIdentificacion.ifPresent(persona::setTipoIdentificacion);
        sucursal.ifPresent(persona::setSucursal);

        System.out.println(persona);

        personaRepository.save(persona);

        return persona;
    }
}
