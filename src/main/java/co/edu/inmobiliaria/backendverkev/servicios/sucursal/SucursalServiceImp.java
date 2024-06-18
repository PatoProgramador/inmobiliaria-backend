package co.edu.inmobiliaria.backendverkev.servicios.sucursal;

import co.edu.inmobiliaria.backendverkev.dtos.SucursalDTO;
import co.edu.inmobiliaria.backendverkev.repositorios.SucursalRepository;
import co.edu.inmobiliaria.backendverkev.servicios.sucursal.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SucursalServiceImp  implements SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<SucursalDTO> listar() {
        List<SucursalDTO> sucursalList = sucursalRepository.findAll().stream()
                .map(s -> new SucursalDTO(s.getId(), s.getNombre(), s.getCiudad().getDescripcion()))
                .collect(Collectors.toList());

        return sucursalList;
    }
}

