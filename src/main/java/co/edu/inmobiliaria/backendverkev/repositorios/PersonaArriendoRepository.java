package co.edu.inmobiliaria.backendverkev.repositorios;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaArriendo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaArriendoRepository extends JpaRepository<PersonaArriendo, Long> {
}