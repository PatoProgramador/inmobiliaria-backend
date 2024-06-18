package co.edu.inmobiliaria.backendverkev.servicios.pago;

import co.edu.inmobiliaria.backendverkev.dominio.Pago;
import co.edu.inmobiliaria.backendverkev.repositorios.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoServiceImp implements PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    @Override
    public List<Pago> listarPagos() {
        return pagoRepository.findAll();
    }
}
