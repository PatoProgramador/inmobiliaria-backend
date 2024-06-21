package co.edu.inmobiliaria.backendverkev.servicios.personaCita;

import co.edu.inmobiliaria.backendverkev.dominio.Citas;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaCita;

public interface PersonaCitaService {
    PersonaCita crearPersonaCita(Long idPersona, Citas citas);
}
