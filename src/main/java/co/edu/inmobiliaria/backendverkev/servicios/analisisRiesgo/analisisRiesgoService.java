package co.edu.inmobiliaria.backendverkev.servicios.analisisRiesgo;

import co.edu.inmobiliaria.backendverkev.dominio.AnalisisRiesgo;
import co.edu.inmobiliaria.backendverkev.dtos.AnalisisRiesgoDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.AnalisisRiesgoInputDTO;

public interface analisisRiesgoService {

    AnalisisRiesgoDTO crearAnalisisRiesgo(Long idInmueble, AnalisisRiesgoInputDTO analisisRiesgoInputDTO);
}
