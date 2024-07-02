package co.edu.inmobiliaria.backendverkev.servicios.personaArriendo;

import co.edu.inmobiliaria.backendverkev.dominio.Arriendo;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaArriendo;

import java.util.List;

public interface PersonaArriendoService {
    List<PersonaArriendo> traerPorPersona(Long idPersona);
    PersonaArriendo encontrarPorIdArriendoIdPersona(Long idArriendo, Long idPersona);
    PersonaArriendo crearPersonaArriendo(Long idPersona, Arriendo arriendo);
    PersonaArriendo modificarPersonaArriendo(Long idPersonaArriendo, Long idPersona);
    void eliminarPersonaArriendo(Long idPersonaArriendo);
}
