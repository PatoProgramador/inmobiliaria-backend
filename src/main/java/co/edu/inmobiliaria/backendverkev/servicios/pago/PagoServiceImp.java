package co.edu.inmobiliaria.backendverkev.servicios.pago;

import co.edu.inmobiliaria.backendverkev.dominio.CuentaCobro;
import co.edu.inmobiliaria.backendverkev.dominio.Inmueble;
import co.edu.inmobiliaria.backendverkev.dominio.Pago;
import co.edu.inmobiliaria.backendverkev.dtos.InmuebleDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.InmubleInputDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.PagoInputDTO;
import co.edu.inmobiliaria.backendverkev.repositorios.PagoRepository;
import co.edu.inmobiliaria.backendverkev.servicios.analisisRiesgo.AnalisisRiesgoServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.cuentaCobro.CuentaCobroServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.inmueble.InmuebleServiceImp;
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
    private CuentaCobroServiceImp cuentaCobroServiceImp;

    @Autowired
    private InmuebleServiceImp inmuebleServiceImp;

    @Override
    public List<Pago> listarPagos() {
        return pagoRepository.findAll();
    }

    @Override
    public Pago crearPago(Long idCuentaCobro, Long idComprador, PagoInputDTO pagoInputDTO) {
        Pago pago = new Pago();
        CuentaCobro cuentaCobro = cuentaCobroServiceImp.encontrarPorId(idCuentaCobro);

        pago.setCuentaCobro(cuentaCobro);
        pago.setMonto(cuentaCobro.getMonto());
        pago.setTipo_pago(pagoInputDTO.getTipoPago());

        if (cuentaCobro.getCompraList().size() > 0 && cuentaCobro.getCompraList() != null) {
            int lastIn = cuentaCobro.getCompraList().size() - 1;
            int inmuebleId = cuentaCobro.getCompraList().get(lastIn).getInmueble().getId();
            Inmueble inmueble = inmuebleServiceImp.encontrarPorIdInmueble((long) inmuebleId);
            InmubleInputDTO inmubleInputDTO = new InmubleInputDTO(inmueble);
            // cambio de propietario
            InmuebleDTO inmuebleUpdated = inmuebleServiceImp.modificarInmueble(Long.valueOf(inmuebleId), idComprador, inmubleInputDTO);
        }

        return pagoRepository.save(pago);
    }
}
