package co.edu.inmobiliaria.backendverkev.servicios.personaArriendo;

import co.edu.inmobiliaria.backendverkev.dominio.Arriendo;
import co.edu.inmobiliaria.backendverkev.dominio.Persona;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaArriendo;
import co.edu.inmobiliaria.backendverkev.repositorios.PersonaArriendoRepository;
import co.edu.inmobiliaria.backendverkev.servicios.arriendo.ArriendoServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.persona.PersonaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaArriendoServiceImp implements PersonaArriendoService {
    @Autowired
    private PersonaArriendoRepository personaArriendoRepository;

    @Autowired
    private PersonaServiceImp personaServiceImp;

    @Override
    public List<PersonaArriendo> listar() {
        return personaArriendoRepository.findAll();
    }

    @Override
    public List<PersonaArriendo> traerPorPersona(Long idPersona) {
        return personaArriendoRepository.encontrarPorPersona(idPersona);
    }

    @Override
    public PersonaArriendo encontrarPorIdArriendoIdPersona(Long idArriendo, Long idPersona) {
        return personaArriendoRepository.encontrarPersonaArriendoPorIdArriendo(idArriendo, idPersona);
    }

    @Override
    public PersonaArriendo crearPersonaArriendo(Long idPersona, Arriendo arriendo) {
        PersonaArriendo personaArriendo = new PersonaArriendo();
        // relaciones...
        Persona persona = personaServiceImp.traerPorIdPersona(idPersona);
        personaArriendo.setPersona(persona);
        personaArriendo.setArriendo(arriendo);
        // nueva instancia..
        personaArriendoRepository.save(personaArriendo);
        return personaArriendo;
    }

    @Override
    public PersonaArriendo modificarPersonaArriendo(Long idPersonaArriendo, Long idPersona) {
        Optional<PersonaArriendo> personaArriendo = personaArriendoRepository.findById(idPersonaArriendo);
        if (personaArriendo.isPresent()) {
            PersonaArriendo personaArriendodb = personaArriendo.get();
            if (idPersona != 0) {
                Persona persona = personaServiceImp.traerPorIdPersona(idPersona);
                personaArriendodb.setPersona(persona);
            }
            personaArriendoRepository.save(personaArriendodb);
            return personaArriendodb;
        } else {
            return null;
        }
    }

    @Override
    public void eliminarPersonaArriendo(Long idPersonaArriendo) {
        personaArriendoRepository.deleteById(idPersonaArriendo);
    }
}
