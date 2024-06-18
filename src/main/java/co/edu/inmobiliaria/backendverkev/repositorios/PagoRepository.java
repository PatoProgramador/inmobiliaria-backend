package co.edu.inmobiliaria.backendverkev.repositorios;

import co.edu.inmobiliaria.backendverkev.dominio.Pago;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PagoRepository extends JpaRepository<Pago, Long> {
}