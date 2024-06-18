package co.edu.inmobiliaria.backendverkev.repositorios;

import co.edu.inmobiliaria.backendverkev.dominio.Arriendo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArriendoRepository extends JpaRepository<Arriendo, Long> {
}
