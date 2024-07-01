package co.edu.inmobiliaria.backendverkev.repositorios;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonaVentaRepository extends JpaRepository<PersonaVenta, Long> {
    @Query("SELECT pv FROM PersonaVenta pv WHERE pv.persona.id = :id")
    List<PersonaVenta> encontrarPersonaVentaPorPersona(Long id);
}
