package co.edu.inmobiliaria.backendverkev.servicios.avaluo;

import co.edu.inmobiliaria.backendverkev.dominio.Avaluo;
import co.edu.inmobiliaria.backendverkev.inputdtos.AvaluoInputDTO;

public interface AvaluoService {
    Avaluo crearAvaluo(Long idInmueble, AvaluoInputDTO avaluoInputDTO);
}
