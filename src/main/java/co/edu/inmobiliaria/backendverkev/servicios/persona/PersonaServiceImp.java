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
import co.edu.inmobiliaria.backendverkev.servicios.sucursal.SucursalServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.tipoIdentificacion.TipoIdentificacionServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.tipoPersona.TipoPersonaServiceImp;
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
    private TipoPersonaServiceImp tipoPersonaServiceImp;

    @Autowired
    private TipoIdentificacionServiceImp tipoIdentificacionServiceImp;

    @Autowired
    private SucursalServiceImp sucursalServiceImp;

    @Override
    public List<PersonaDTO> listar() {
        return personaRepository.findAll().stream()
                .map(p -> new PersonaDTO(p))
                .collect(Collectors.toList());
    }

    @Override
    public PersonaDTO crearPersona(Long idTipoPersona, Long idTipoIdentificacion, Long idSucursal, PersonaInputDTO personaInputDTO) {
        Persona persona = new Persona();

        Optional<TipoPersona> tipoPersona = tipoPersonaServiceImp.encontrarPorId(idTipoPersona);

        Optional<TipoIdentificacion> tipoIdentificacion = tipoIdentificacionServiceImp.encontrarPorId(idTipoIdentificacion);

        Optional<Sucursal> sucursal = sucursalServiceImp.encontrarPorId(idSucursal);

        // creacion de la instancia
        persona.setIdentificacion(personaInputDTO.getIdentificacion());
        persona.setNombre(personaInputDTO.getNombre());
        persona.setCorreo(personaInputDTO.getCorreo());
        persona.setTelefono(personaInputDTO.getTelefono());
        // relaciones...
        tipoPersona.ifPresent(persona::setTipoPersona);
        tipoIdentificacion.ifPresent(persona::setTipoIdentificacion);
        sucursal.ifPresent(persona::setSucursal);
        // guardamos la nueva instancia
        personaRepository.save(persona);
        // pulimos la instancia para devolverla..
        return new PersonaDTO(persona);
    }
}
