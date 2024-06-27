package co.edu.inmobiliaria.backendverkev.servicios.tipoPersona;

import co.edu.inmobiliaria.backendverkev.dominio.TipoPersona;
import co.edu.inmobiliaria.backendverkev.dtos.TipoPersonaDTO;
import co.edu.inmobiliaria.backendverkev.repositorios.TipoPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoPersonaServiceImp implements TipoPersonaService{
    @Autowired
    private TipoPersonaRepository tipoPersonaRepository;

    @Override
    public List<TipoPersonaDTO> listar() {
        return tipoPersonaRepository.findAll().stream()
                .map(tp -> new TipoPersonaDTO(tp))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TipoPersona> encontrarPorId(Long id) {
        Optional<TipoPersona> dbTipoPersona = tipoPersonaRepository.findById(id);

        return dbTipoPersona;
    }
}
