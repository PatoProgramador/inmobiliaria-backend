package co.edu.inmobiliaria.backendverkev.repositorios;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaArriendo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PersonaArriendoRepository extends JpaRepository<PersonaArriendo, Long> {
    @Query("SELECT pa FROM PersonaArriendo  pa WHERE pa.persona.id = :idPersona")
    List<PersonaArriendo> encontrarPorPersona(Long idPersona);
    @Query("SELECT pa FROM PersonaArriendo pa WHERE pa.arriendo.id = :idArriendo AND pa.persona.id = :idPersona")
    PersonaArriendo encontrarPersonaArriendoPorIdArriendo(Long idArriendo, Long idPersona);
}