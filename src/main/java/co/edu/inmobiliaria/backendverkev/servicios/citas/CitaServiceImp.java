package co.edu.inmobiliaria.backendverkev.servicios.citas;

import co.edu.inmobiliaria.backendverkev.dominio.Citas;
import co.edu.inmobiliaria.backendverkev.dominio.Inmueble;
import co.edu.inmobiliaria.backendverkev.dominio.Persona;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaCita;
import co.edu.inmobiliaria.backendverkev.dtos.CitaDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.CitaInputDTO;
import co.edu.inmobiliaria.backendverkev.repositorios.CitasRepository;
import co.edu.inmobiliaria.backendverkev.servicios.inmueble.InmuebleServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.persona.PersonaServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.personaCita.PersonaCitaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CitaServiceImp implements CitaService {
    @Autowired
    private CitasRepository citasRepository;
    @Autowired
    private InmuebleServiceImp inmuebleServiceImp;

    @Autowired
    private PersonaCitaServiceImp personaCitaServiceImp;

    @Override
    public Citas buscarCitaPorId(Long idCita) {
        return null;
    }

    @Override
    public CitaDTO crearCita(Long idInmueble, Long idPropietario, Long idComprador, Long idComercial, CitaInputDTO citaInputDTO) {
        Citas citas = new Citas();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
        // Busquedas
        Inmueble inmueble = inmuebleServiceImp.encontrarPorIdInmueble(idInmueble);
        // atributos
        citas.setInmueble(inmueble);
        citas.setDescripcion(citaInputDTO.getDescripcion());
        try {
            Date fecha = simpleDateFormat.parse(citaInputDTO.getFecha());

            citas.setFecha(fecha);
        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
        }
        Citas citaDb = citasRepository.save(citas);
        // crear instancias de la tabla intermedia PersonaCita
        List<PersonaCita> personaCitaList = new ArrayList<>(List.of(
                personaCitaServiceImp.crearPersonaCita(idPropietario, citaDb),
                personaCitaServiceImp.crearPersonaCita(idComercial, citaDb),
                personaCitaServiceImp.crearPersonaCita(idComprador, citaDb)
        ));
        citas.setPersonaCitaList(personaCitaList);
        return new CitaDTO(citas);
    }
}
