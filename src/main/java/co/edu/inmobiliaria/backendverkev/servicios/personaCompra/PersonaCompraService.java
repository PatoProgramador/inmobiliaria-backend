package co.edu.inmobiliaria.backendverkev.servicios.personaCompra;

import co.edu.inmobiliaria.backendverkev.dominio.Compra;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaCompra;

public interface PersonaCompraService {
    PersonaCompra crearPersonaCompra(Long idPersona, Compra compra);
}
