package co.edu.inmobiliaria.backendverkev.servicios.ciudad;

import co.edu.inmobiliaria.backendverkev.dominio.Ciudad;
import co.edu.inmobiliaria.backendverkev.dtos.CiudadDTO;
import co.edu.inmobiliaria.backendverkev.repositorios.CiudadRepository;
import co.edu.inmobiliaria.backendverkev.servicios.ciudad.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CiudadServiceImp  implements CiudadService {
    @Autowired
    private CiudadRepository ciudadRepository;

    @Override
    public List<CiudadDTO> listar() {
        return ciudadRepository.findAll().stream()
                .map(c -> new CiudadDTO(c))
                .collect(Collectors.toList());
    }
}
