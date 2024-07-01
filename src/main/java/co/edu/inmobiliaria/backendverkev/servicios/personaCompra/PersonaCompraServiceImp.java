package co.edu.inmobiliaria.backendverkev.servicios.personaCompra;

import co.edu.inmobiliaria.backendverkev.dominio.Compra;
import co.edu.inmobiliaria.backendverkev.dominio.Persona;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaCompra;
import co.edu.inmobiliaria.backendverkev.repositorios.PersonaCompraRepository;
import co.edu.inmobiliaria.backendverkev.servicios.persona.PersonaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaCompraServiceImp implements PersonaCompraService{
    @Autowired
    private PersonaCompraRepository personaCompraRepository;

    @Autowired
    private PersonaServiceImp personaServiceImp;

    @Override
    public PersonaCompra crearPersonaCompra(Long idPersona, Compra compra) {
        PersonaCompra personaCompra = new PersonaCompra();

        Persona personaDb = personaServiceImp.traerPorIdPersona(idPersona);
        personaCompra.setPersona(personaDb);
        personaCompra.setCompra(compra);
        return personaCompraRepository.save(personaCompra);
    }
}
