package co.edu.inmobiliaria.backendverkev.servicios.personaVenta;

import co.edu.inmobiliaria.backendverkev.dominio.PersonaVenta;
import co.edu.inmobiliaria.backendverkev.dominio.Venta;

import java.util.List;

public interface PersonaVentaService {
    List<PersonaVenta> traerPorIdPersona(Long idPersona);
    PersonaVenta crearPersonaVenta(Long idPersona, Venta venta);
}
