package co.edu.inmobiliaria.backendverkev.servicios.arriendo;

import co.edu.inmobiliaria.backendverkev.dominio.Arriendo;
import co.edu.inmobiliaria.backendverkev.dtos.ArriendoDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.ArriendoInputDTO;

import java.util.List;

public interface ArriendoService {
    List<ArriendoDTO> listar();
    Arriendo encontrarArriendoPorId(Long id);
    ArriendoDTO crearArriendo(Long idPropietario, Long idComercial, Long idArrendatario, Long idInmueble, ArriendoInputDTO arriendoInputDTO);
    ArriendoDTO modificarArriendo(Long idArriendo, Long idPropietario, Long idComercial, Long idArrendatario, Long idInmueble, ArriendoInputDTO arriendoInputDTO);
}
