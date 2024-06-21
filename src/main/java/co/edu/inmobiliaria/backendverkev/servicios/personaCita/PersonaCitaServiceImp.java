package co.edu.inmobiliaria.backendverkev.servicios.personaCita;

import co.edu.inmobiliaria.backendverkev.dominio.Citas;
import co.edu.inmobiliaria.backendverkev.dominio.Persona;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaCita;
import co.edu.inmobiliaria.backendverkev.repositorios.PersonaCitaRepository;
import co.edu.inmobiliaria.backendverkev.servicios.persona.PersonaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaCitaServiceImp implements PersonaCitaService {
    @Autowired
    private PersonaCitaRepository personaCitaRepository;

    @Autowired
    private PersonaServiceImp personaServiceImp;

    @Override
    public PersonaCita crearPersonaCita(Long idPersona, Citas citas) {
        PersonaCita personaCita = new PersonaCita();

        Persona persona = personaServiceImp.traerPorIdPersona(idPersona);

        personaCita.setPersona(persona);
        personaCita.setCitas(citas);
        personaCitaRepository.save(personaCita);
        return personaCita;
    }
}
