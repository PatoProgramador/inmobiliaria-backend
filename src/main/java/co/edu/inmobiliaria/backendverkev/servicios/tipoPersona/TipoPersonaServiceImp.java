package co.edu.inmobiliaria.backendverkev.servicios.tipoPersona;

import co.edu.inmobiliaria.backendverkev.dominio.TipoPersona;
import co.edu.inmobiliaria.backendverkev.repositorios.TipoPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPersonaServiceImp implements TipoPersonaService{
    @Autowired
    private TipoPersonaRepository tipoPersonaRepository;

    @Override
    public List<TipoPersona> listar() {
        return tipoPersonaRepository.findAll();
    }

    @Override
    public Optional<TipoPersona> encontrarPorId(Long id) {
        Optional<TipoPersona> dbTipoPersona = tipoPersonaRepository.findById(id);

        return dbTipoPersona;
    }
}
