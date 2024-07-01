package co.edu.inmobiliaria.backendverkev.servicios.personaVenta;

import co.edu.inmobiliaria.backendverkev.dominio.*;
import co.edu.inmobiliaria.backendverkev.repositorios.PersonaVentaRepository;
import co.edu.inmobiliaria.backendverkev.servicios.persona.PersonaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaVentaServiceImp implements PersonaVentaService {
    @Autowired
    private PersonaVentaRepository personaVentaRepository;

    @Autowired
    private PersonaServiceImp personaServiceImp;

    @Override
    public PersonaVenta crearPersonaVenta(Long idPersona, Venta venta) {
        PersonaVenta personaVenta = new PersonaVenta();

        Persona personaDb = personaServiceImp.traerPorIdPersona(idPersona);
        personaVenta.setPersona(personaDb);
        personaVenta.setVenta(venta);
        return personaVentaRepository.save(personaVenta);
    }
}