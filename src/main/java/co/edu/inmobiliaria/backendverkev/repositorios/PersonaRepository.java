package co.edu.inmobiliaria.backendverkev.repositorios;

import co.edu.inmobiliaria.backendverkev.dominio.Persona;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    @Query("SELECT p FROM Persona p WHERE  p.tipoIdentificacion.id = :idTipoDocumento AND p.identificacion = :documento")
    Optional<Persona> traerPorTipoDocyDoc(Long idTipoDocumento, String documento);
    @Modifying
    @Transactional
    @Query("DELETE FROM Persona p WHERE p.id = :idPersona")
    void borrarPersona(@Param("idPersona") Long idPersona);
}

