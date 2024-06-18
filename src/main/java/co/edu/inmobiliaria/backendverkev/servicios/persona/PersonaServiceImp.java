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
import jakarta.persistence.EntityNotFoundException;
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
    public PersonaDTO traerPorId(Long id) {
        Optional<Persona> personaDTO = personaRepository.findById(id);
        if (personaDTO.isPresent()) {
            return new PersonaDTO(personaDTO.get());
        } else {
            throw new EntityNotFoundException("No se encontró la persona con id " + id);
        }
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

    @Override
    public PersonaDTO modificarPersona(Long idPersona, Long idTipoPersona, Long idTipoIdentificacion, Long idSucursal, PersonaInputDTO personaInputDTO) {
        Optional<Persona> persona = personaRepository.findById(idPersona);
        if (persona.isPresent()) {
            Persona dbPer = persona.get();
            // si es distinto de 0 es porque quiere ser modificado
            if (idTipoPersona != 0) {
                // manejo de tipo de persona
                Optional<TipoPersona> tipoPersona = tipoPersonaServiceImp.encontrarPorId(idTipoPersona);
                // manejo de error optional
                if (tipoPersona.isPresent()) {
                    // setear la db persona
                    dbPer.setTipoPersona(tipoPersona.get());
                } else {
                    throw new EntityNotFoundException("No se encontró el tipo de persona con id " + idTipoPersona);
                }
            }
            // si es distinto de 0 se quiere modificar el tipo de identificacion
            if (idTipoIdentificacion != 0) {
                Optional<TipoIdentificacion> tipoIdentificacion = tipoIdentificacionServiceImp.encontrarPorId(idTipoIdentificacion);

                if (tipoIdentificacion.isPresent()) {
                    // setear la db persona
                    dbPer.setTipoIdentificacion(tipoIdentificacion.get());
                } else {
                    throw new EntityNotFoundException("No se encontró el tipo de identificacion con id " + idTipoIdentificacion);
                }
            }

            if (idSucursal != 0) {
                Optional<Sucursal> sucursal = sucursalServiceImp.encontrarPorId(idSucursal);

                if (sucursal.isPresent()) {
                    // setear la db persona
                    dbPer.setSucursal(sucursal.get());
                } else {
                    throw new EntityNotFoundException("No se encontró la sucursal con id " + idSucursal);
                }
            }
            // si la identificacion no viene vacia se setea en la instancia de la db
            if (personaInputDTO.getIdentificacion() != null && personaInputDTO.getIdentificacion() != "") {
                dbPer.setIdentificacion(personaInputDTO.getIdentificacion());
            }
            // si el nombre no viene vacio se setea en la instancia de la db
            if (personaInputDTO.getNombre() != null && personaInputDTO.getNombre() != "") {
                dbPer.setNombre(personaInputDTO.getNombre());
            }
            // etc etc
            if (personaInputDTO.getCorreo() != null && personaInputDTO.getCorreo() != "") {
                dbPer.setCorreo(personaInputDTO.getCorreo());
            }
            // etc etc x2
            if (personaInputDTO.getTelefono() != null && personaInputDTO.getTelefono() != "") {
                dbPer.setTelefono(personaInputDTO.getTelefono());
            }
            // guardamos las modificaciones
            personaRepository.save(dbPer);
            // instancia de DTO para retornar la persona modificada
            PersonaDTO personaDTO = new PersonaDTO(dbPer);

            return personaDTO;
        } else {
            // Manejar el caso donde la persona no existe
            throw new EntityNotFoundException("No se encontró la persona con id " + idPersona);
        }
    }
}
