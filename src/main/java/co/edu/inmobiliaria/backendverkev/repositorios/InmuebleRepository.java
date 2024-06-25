package co.edu.inmobiliaria.backendverkev.repositorios;


import co.edu.inmobiliaria.backendverkev.dominio.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {
    @Query("SELECT i FROM Inmueble  i WHERE i.persona.sucursal.ciudad.clave = :ciudad")
    List<Inmueble> listarInmueblesPorCiudad(String ciudad);
}

