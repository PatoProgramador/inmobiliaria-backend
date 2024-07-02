package co.edu.inmobiliaria.backendverkev.servicios.avaluo;

import co.edu.inmobiliaria.backendverkev.dominio.Avaluo;
import co.edu.inmobiliaria.backendverkev.dtos.AvaluoDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.AvaluoInputDTO;

public interface AvaluoService {
    AvaluoDTO crearAvaluo(Long idInmueble, AvaluoInputDTO avaluoInputDTO);
}
