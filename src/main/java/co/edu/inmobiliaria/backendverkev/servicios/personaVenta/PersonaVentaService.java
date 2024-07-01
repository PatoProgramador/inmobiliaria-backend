package co.edu.inmobiliaria.backendverkev.servicios.personaVenta;

import co.edu.inmobiliaria.backendverkev.dominio.PersonaVenta;
import co.edu.inmobiliaria.backendverkev.dominio.Venta;

public interface PersonaVentaService {
    PersonaVenta crearPersonaVenta(Long idPersona, Venta venta);
}
