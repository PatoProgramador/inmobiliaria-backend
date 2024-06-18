package co.edu.inmobiliaria.backendverkev.repositorios;

import co.edu.inmobiliaria.backendverkev.dominio.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}

