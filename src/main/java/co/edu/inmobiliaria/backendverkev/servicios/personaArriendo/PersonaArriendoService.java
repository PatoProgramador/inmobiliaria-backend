package co.edu.inmobiliaria.backendverkev.servicios.personaArriendo;

import co.edu.inmobiliaria.backendverkev.dominio.Arriendo;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaArriendo;

public interface PersonaArriendoService {
    PersonaArriendo crearPersonaArriendo(Long idPersona, Arriendo arriendo);
    void eliminarPersonaArriendo(Long idPersonaArriendo);
}
