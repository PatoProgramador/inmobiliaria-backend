package co.edu.inmobiliaria.backendverkev.servicios.pago;

import co.edu.inmobiliaria.backendverkev.dominio.Pago;
import co.edu.inmobiliaria.backendverkev.repositorios.PagoRepository;
import co.edu.inmobiliaria.backendverkev.servicios.analisisRiesgo.AnalisisRiesgoServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.personaArriendo.PersonaArriendoServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.personaCompra.PersonaCompraServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.personaVenta.PersonaVentaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoServiceImp implements PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private PersonaCompraServiceImp personaCompraServiceImp;
    @Autowired
    private PersonaVentaServiceImp personaVentaServiceImp;
    @Autowired
    private PersonaArriendoServiceImp personaArriendoServiceImp;
    @Autowired
    private AnalisisRiesgoServiceImp analisisRiesgoServiceImp;
    @Override
    public List<Pago> listarPagos() {
        return pagoRepository.findAll();
    }
}
