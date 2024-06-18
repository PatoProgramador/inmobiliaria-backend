package co.edu.inmobiliaria.backendverkev.repositorios;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaCompra;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaCompraRepository extends JpaRepository<PersonaCompra, Long> {
}