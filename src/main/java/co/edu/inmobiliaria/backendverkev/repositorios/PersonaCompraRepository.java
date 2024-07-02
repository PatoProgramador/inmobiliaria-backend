package co.edu.inmobiliaria.backendverkev.repositorios;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaCompra;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PersonaCompraRepository extends JpaRepository<PersonaCompra, Long> {
    @Query("SELECT pc FROM PersonaCompra pc WHERE pc.persona.id = :id")
    List<PersonaCompra> encontrarPersonaCompraPorPersona(Long id);
}