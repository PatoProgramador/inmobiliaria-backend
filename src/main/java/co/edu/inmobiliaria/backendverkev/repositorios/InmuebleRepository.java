package co.edu.inmobiliaria.backendverkev.repositorios;


import co.edu.inmobiliaria.backendverkev.dominio.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {
}

