package co.edu.inmobiliaria.backendverkev.repositorios;
import co.edu.inmobiliaria.backendverkev.dominio.CuentaCobro;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CuentaCobroRepository extends JpaRepository<CuentaCobro, Long> {
}