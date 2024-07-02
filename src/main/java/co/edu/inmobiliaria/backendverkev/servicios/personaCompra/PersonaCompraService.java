package co.edu.inmobiliaria.backendverkev.servicios.personaCompra;

import co.edu.inmobiliaria.backendverkev.dominio.Compra;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaCompra;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaVenta;

import java.util.List;

public interface PersonaCompraService {
    List<PersonaCompra> traerPorIdPersona(Long idPersona);
    PersonaCompra crearPersonaCompra(Long idPersona, Compra compra);
}
