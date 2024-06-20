package co.edu.inmobiliaria.backendverkev.servicios.personaArriendo;

import co.edu.inmobiliaria.backendverkev.dominio.Arriendo;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaArriendo;

public interface PersonaArriendoService {
    PersonaArriendo encontrarPorIdArriendoIdPersona(Long idArriendo, Long idPersona);
    PersonaArriendo crearPersonaArriendo(Long idPersona, Arriendo arriendo);
    PersonaArriendo modificarPersonaArriendo(Long idPersonaArriendo, Long idPersona);
    void eliminarPersonaArriendo(Long idPersonaArriendo);
}
