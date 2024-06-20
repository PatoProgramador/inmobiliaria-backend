package co.edu.inmobiliaria.backendverkev.servicios.arriendo;

import co.edu.inmobiliaria.backendverkev.dominio.Arriendo;
import co.edu.inmobiliaria.backendverkev.dominio.Inmueble;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaArriendo;
import co.edu.inmobiliaria.backendverkev.dtos.ArriendoDTO;
import co.edu.inmobiliaria.backendverkev.dtos.InmuebleDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.ArriendoInputDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.InmubleInputDTO;
import co.edu.inmobiliaria.backendverkev.repositorios.ArriendoRepository;
import co.edu.inmobiliaria.backendverkev.servicios.inmueble.InmuebleServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.personaArriendo.PersonaArriendoServiceImp;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ArriendoServiceImp implements ArriendoService{
    @Autowired
    private ArriendoRepository arriendoRepository;

    @Autowired
    private PersonaArriendoServiceImp personaArriendoServiceImp;

    @Autowired
    private InmuebleServiceImp inmuebleServiceImp;

    @Override
    public List<ArriendoDTO> listar() {
        return arriendoRepository.findAll().stream()
                .map(ar -> new ArriendoDTO(ar))
                .collect(Collectors.toList());
    }

    @Override
    public Arriendo encontrarArriendoPorId(Long id) {
        Optional<Arriendo> arriendo = arriendoRepository.findById(id);

        if (arriendo.isPresent()) {
            return arriendo.get();
        } else {
            throw new EntityNotFoundException("No se encontró el arriendo con id " + id);
        }
    }

    @Override
    public ArriendoDTO crearArriendo(Long idPropietario, Long idComercial, Long idArrendatario, Long idInmueble, ArriendoInputDTO arriendoInputDTO) {
        Arriendo arriendo = new Arriendo();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
        // relacion con inmueble
        Inmueble inmueble = inmuebleServiceImp.encontrarPorIdInmueble(idInmueble);
        arriendo.setInmueble(inmueble);
        // demas atributos..
        arriendo.setDetalles(arriendoInputDTO.getDetalles());
        arriendo.setMonto(arriendoInputDTO.getMonto());
        // fechas..
        try {
            Date fechaInicio = simpleDateFormat.parse(arriendoInputDTO.getFechaInicio());
            Date fechaFinal = simpleDateFormat.parse(arriendoInputDTO.getFechaFinal());

            arriendo.setFecha_inicio(fechaInicio);
            arriendo.setFecha_final(fechaFinal);
        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
        }
        // instancia
        arriendoRepository.save(arriendo);
        // uno a muchos...
        PersonaArriendo personaArriendo1 = personaArriendoServiceImp.crearPersonaArriendo(idPropietario, arriendo);
        PersonaArriendo personaArriendo2 = personaArriendoServiceImp.crearPersonaArriendo(idComercial, arriendo);
        PersonaArriendo personaArriendo3 = personaArriendoServiceImp.crearPersonaArriendo(idArrendatario, arriendo);
        List<PersonaArriendo> personaArriendoList = new ArrayList<>();
        personaArriendoList.add(personaArriendo1);
        personaArriendoList.add(personaArriendo2);
        personaArriendoList.add(personaArriendo3);
        arriendo.setPersonaArriendoList(personaArriendoList);
        // estado del inmueble a falso
        InmubleInputDTO inmubleInputDTO = new InmubleInputDTO();
        inmubleInputDTO.setDisponible(Boolean.FALSE);
        InmuebleDTO inmuebleDTO = inmuebleServiceImp.modificarInmueble(idInmueble, 0L, inmubleInputDTO);
        return new ArriendoDTO(arriendo);
    }

    @Override
    public ArriendoDTO modificarArriendo(Long idArriendo, Long idPropietario, Long idComercial, Long idArrendatario, Long idInmueble, ArriendoInputDTO arriendoInputDTO) {
        Optional<Arriendo> arriendo = arriendoRepository.findById(idArriendo);
        if (arriendo.isPresent()) {
            Arriendo arriendoDB = arriendo.get();
            // operaciones con personaArriendo
            List<PersonaArriendo> personaArriendoList = new ArrayList<>();
            // buscamos el id del propietaario mediante el inmueble
            int propietarioDB = arriendoDB.getInmueble().getPersona().getId();
            // buscamos el id del comercial
            Optional<Integer> comercialDB = arriendoDB.getPersonaArriendoList().stream()
                    .filter(ar -> ar.getPersona().getTipoPersona().getDescripcion().equalsIgnoreCase("Comercial"))
                    .findFirst()
                    .map(ar -> ar.getPersona().getId());
            // buscamos el id del arrendatario
            int arrendatarioDB = arriendoDB.getPersonaArriendoList().stream()
                    .filter(ar -> !ar.getPersona().getTipoPersona().getDescripcion().equalsIgnoreCase("Comercial") && ar.getPersona().getId() != propietarioDB)
                    .findFirst()
                    .map(ar -> ar.getPersona().getId())
                    .orElseThrow(() -> new NoSuchElementException("No se encontró ninguna persona con tipo 'Comercial'"));
            if (idPropietario != 0) {
                PersonaArriendo personaArriendo = modificarPersonaArriendo(idArriendo, (long) propietarioDB, idPropietario);
                personaArriendoList.add(personaArriendo);
            }
            if (idComercial != 0) {
                PersonaArriendo personaArriendo;
                if (comercialDB.isPresent()) {
                    personaArriendo = modificarPersonaArriendo(idArriendo, (long) comercialDB.get(), idComercial);
                } else {
                    personaArriendo = personaArriendoServiceImp.crearPersonaArriendo(idComercial, arriendoDB);
                }
                personaArriendoList.add(personaArriendo);
            }
            if (idArrendatario != 0) {
                PersonaArriendo personaArriendo = modificarPersonaArriendo(idArriendo, (long) arrendatarioDB, idArrendatario);
                personaArriendoList.add(personaArriendo);
            }
            if (personaArriendoList.size() > 0) {
                arriendoDB.setPersonaArriendoList(personaArriendoList);
            }
            // con inmueble
            if (idInmueble != 0) {
                Inmueble inmueble = inmuebleServiceImp.encontrarPorIdInmueble(idInmueble);
                arriendoDB.setInmueble(inmueble);
            }
            // con alguna de sus propiedades...
            if (arriendoInputDTO.getDetalles() != null) {
                arriendoDB.setDetalles(arriendoInputDTO.getDetalles());
            }
            if (arriendoInputDTO.getMonto() != null) {
                arriendoDB.setMonto(arriendoInputDTO.getMonto());
            }
            // fechas...
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
            if (arriendoInputDTO.getFechaInicio() != null) {
                try {
                    Date fechaInicio = simpleDateFormat.parse(arriendoInputDTO.getFechaInicio());
                    arriendoDB.setFecha_inicio(fechaInicio);
                } catch (ParseException e) {
                    System.out.println("Error al convertir la fecha: " + e.getMessage());
                }
            }
            if (arriendoInputDTO.getFechaFinal() != null) {
                try {
                    Date fechaFin = simpleDateFormat.parse(arriendoInputDTO.getFechaFinal());
                    arriendoDB.setFecha_final(fechaFin);
                } catch (ParseException e) {
                    System.out.println("Error al convertir la fecha: " + e.getMessage());
                }
            }
            Arriendo arriendoUpd = arriendoRepository.save(arriendoDB);
            return new ArriendoDTO(arriendoUpd);
        } else {
            throw new EntityNotFoundException("No se encontró el arriendo con id " + idArriendo);
        }
    }

    public PersonaArriendo modificarPersonaArriendo(Long idArriendo, Long idPerson, Long idNewPerson) {
        PersonaArriendo personaArriendoFind = personaArriendoServiceImp.encontrarPorIdArriendoIdPersona(idArriendo, idPerson);
        return personaArriendoServiceImp.modificarPersonaArriendo((long) personaArriendoFind.getId(), idNewPerson);
    }

}
