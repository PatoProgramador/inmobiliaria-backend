package co.edu.inmobiliaria.backendverkev.servicios.tipoIdentificacion;

import co.edu.inmobiliaria.backendverkev.dominio.TipoIdentificacion;
import co.edu.inmobiliaria.backendverkev.dtos.TipoIdentificacionDTO;
import co.edu.inmobiliaria.backendverkev.repositorios.TipoIdentificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoIdentificacionServiceImp implements TipoIdentificacionService{
    @Autowired
    private TipoIdentificacionRepository tipoIdentificacionRepository;

    @Override
    public List<TipoIdentificacionDTO> listar() {
        List<TipoIdentificacionDTO> tipoIdentificacion =  tipoIdentificacionRepository.findAll().stream()
                .map(t -> new TipoIdentificacionDTO(t))
                .collect(Collectors.toList());

        return tipoIdentificacion;
    }

    @Override
    public Optional<TipoIdentificacion> encontrarPorId(Long id) {
        return tipoIdentificacionRepository.findById(id);
    }
}