package co.edu.inmobiliaria.backendverkev.servicios.inmueble;

import co.edu.inmobiliaria.backendverkev.dominio.Inmueble;
import co.edu.inmobiliaria.backendverkev.dominio.Persona;
import co.edu.inmobiliaria.backendverkev.dtos.InmuebleDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.InmubleInputDTO;
import co.edu.inmobiliaria.backendverkev.repositorios.InmuebleRepository;
import co.edu.inmobiliaria.backendverkev.servicios.persona.PersonaServiceImp;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InmuebleServiceImp implements InmuebleService{
    @Autowired
    private InmuebleRepository inmuebleRepository;

    @Autowired
    private PersonaServiceImp personaServiceImp;

    @Override
    public List<InmuebleDTO> listar() {
        return inmuebleRepository.findAll().stream()
                .map(i -> new InmuebleDTO(i))
                .collect(Collectors.toList());
    }

    @Override
    public List<InmuebleDTO> listarPorCiudad(String ciudad) {
        List<Inmueble> inmueblesDb = inmuebleRepository.listarInmueblesPorCiudad(ciudad);
        return inmueblesDb.stream()
                .map(i -> new InmuebleDTO(i))
                .collect(Collectors.toList());
    }

    @Override
    public List<InmuebleDTO> listarPorPersona(Long id) {
        List<Inmueble> inmuebles = inmuebleRepository.obtenerInmueblesPorPersona(id);
        if (inmuebles.size() > 0) {
            return inmuebles.stream()
                    .map(i -> new InmuebleDTO(i))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Override
    public InmuebleDTO encontrarPorIdInmuebleDTO(Long id) {
        Optional<Inmueble> inmueble = inmuebleRepository.findById(id);

        if (inmueble.isPresent()) {
            return new InmuebleDTO(inmueble.get());
        } else {
            throw new EntityNotFoundException("No se encontró el inmueble con id " + id);
        }
    }

    @Override
    public Inmueble encontrarPorIdInmueble(Long id) {
        Optional<Inmueble> inmueble = inmuebleRepository.findById(id);

        if (inmueble.isPresent()) {
            return inmueble.get();
        } else {
            throw new EntityNotFoundException("No se encontró el inmueble con id " + id);
        }
    }

    @Override
    public InmuebleDTO crearInmueble(Long idPersona, InmubleInputDTO inmubleInputDTO) {
        Inmueble inmueble = new Inmueble();
        // persona relacionada
        Persona personaDb = personaServiceImp.traerPorIdPersona(idPersona);
        inmueble.setPersona(personaDb);
        // atributos..
        inmueble.setDetalles(inmubleInputDTO.getDetalles());
        inmueble.setDireccion(inmubleInputDTO.getDireccion());
        inmueble.setDisponible(Boolean.FALSE);
        inmueble.setHora_creacion(new Timestamp(System.currentTimeMillis()));

        inmuebleRepository.save(inmueble);
        return new InmuebleDTO(inmueble);
    }

    @Override
    public InmuebleDTO modificarInmueble(Long idInmueble, Long idPersona, InmubleInputDTO inmubleInputDTO) {
        Optional<Inmueble> inmueble = inmuebleRepository.findById(idInmueble);
        if (inmueble.isPresent()) {
            Inmueble dbInmueble = inmueble.get();
            // cambiar la relacion con persona
            if (idPersona != 0) {
                Persona persona = personaServiceImp.traerPorIdPersona(idPersona);
                dbInmueble.setPersona(persona);
            }
            // alguno de los otros datos..
            if (inmubleInputDTO.getDetalles() != null && inmubleInputDTO.getDetalles() != "") {
                dbInmueble.setDetalles(inmubleInputDTO.getDetalles());
            }
            if (inmubleInputDTO.getDireccion() != null && inmubleInputDTO.getDireccion() != "") {
                dbInmueble.setDireccion(inmubleInputDTO.getDireccion());
            }
            if (inmubleInputDTO.getDisponible() != null) {
                dbInmueble.setDisponible(inmubleInputDTO.getDisponible());
            }
            inmuebleRepository.save(dbInmueble);
            return new InmuebleDTO(dbInmueble);
        } else {
            throw new EntityNotFoundException("No se encontró el inmueble con id " + idInmueble);
        }
    }
}
