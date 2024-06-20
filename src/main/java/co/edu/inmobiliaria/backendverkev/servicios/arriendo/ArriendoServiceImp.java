package co.edu.inmobiliaria.backendverkev.servicios.arriendo;

import co.edu.inmobiliaria.backendverkev.dominio.Arriendo;
import co.edu.inmobiliaria.backendverkev.dominio.Inmueble;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaArriendo;
import co.edu.inmobiliaria.backendverkev.dtos.ArriendoDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.ArriendoInputDTO;
import co.edu.inmobiliaria.backendverkev.repositorios.ArriendoRepository;
import co.edu.inmobiliaria.backendverkev.servicios.inmueble.InmuebleServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.persona.PersonaServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.personaArriendo.PersonaArriendoService;
import co.edu.inmobiliaria.backendverkev.servicios.personaArriendo.PersonaArriendoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArriendoServiceImp implements ArriendoService{
    @Autowired
    private ArriendoRepository arriendoRepository;

    @Autowired
    private PersonaServiceImp personaServiceImp;

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
        }catch (ParseException e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
        }
        // instancia
        arriendoRepository.save(arriendo);
        // uno a muchos...
        PersonaArriendo personaArriendo1 = personaArriendoServiceImp.crearPersonaArriendo(idPropietario, arriendo);
        PersonaArriendo personaArriendo2 = personaArriendoServiceImp.crearPersonaArriendo(idComercial, arriendo);
        PersonaArriendo personaArriendo3 = personaArriendoServiceImp.crearPersonaArriendo(idArrendatario, arriendo);

        return new ArriendoDTO(arriendo);
    }
}
