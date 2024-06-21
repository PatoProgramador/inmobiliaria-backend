package co.edu.inmobiliaria.backendverkev.servicios.citas;

import co.edu.inmobiliaria.backendverkev.dominio.Citas;
import co.edu.inmobiliaria.backendverkev.dtos.CitaDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.CitaInputDTO;

public interface CitaService {
    Citas buscarCitaPorId(Long idCita);
    CitaDTO crearCita(Long idInmueble, Long idPropietario, Long idComprador, Long idComercial, CitaInputDTO citaInputDTO);
}
