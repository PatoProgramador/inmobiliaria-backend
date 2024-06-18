package co.edu.inmobiliaria.backendverkev.servicios.inmueble;

import co.edu.inmobiliaria.backendverkev.dominio.Inmueble;
import co.edu.inmobiliaria.backendverkev.repositorios.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InmuebleServiceImp implements InmuebleService{
    @Autowired
    private InmuebleRepository inmuebleRepository;

    @Override
    public List<Inmueble> listar() {
        return inmuebleRepository.findAll();
    }
}
