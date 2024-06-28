package co.edu.inmobiliaria.backendverkev.servicios.inmueble;

import co.edu.inmobiliaria.backendverkev.dominio.Inmueble;
import co.edu.inmobiliaria.backendverkev.dtos.InmuebleDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.InmubleInputDTO;

import java.util.List;

public interface InmuebleService {
    List<InmuebleDTO> listar();

    List<InmuebleDTO> listarPorCiudad(String ciudad);
    List<InmuebleDTO> listarPorPersona(Long id);

    InmuebleDTO encontrarPorIdInmuebleDTO(Long id);
    Inmueble encontrarPorIdInmueble(Long id);


    InmuebleDTO crearInmueble(Long idPersona, InmubleInputDTO inmubleInputDTO);
    InmuebleDTO modificarInmueble(Long idInmueble, Long idPersona, InmubleInputDTO inmubleInputDTO);
}
