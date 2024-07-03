package co.edu.inmobiliaria.backendverkev.servicios.pago;

import co.edu.inmobiliaria.backendverkev.dominio.*;
import co.edu.inmobiliaria.backendverkev.dtos.InmuebleDTO;
import co.edu.inmobiliaria.backendverkev.dtos.PagoDTO;
import co.edu.inmobiliaria.backendverkev.dtos.VentaDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.InmubleInputDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.PagoInputDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.VentaInputDTO;
import co.edu.inmobiliaria.backendverkev.repositorios.PagoRepository;
import co.edu.inmobiliaria.backendverkev.servicios.analisisRiesgo.AnalisisRiesgoServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.cuentaCobro.CuentaCobroServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.inmueble.InmuebleServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.personaArriendo.PersonaArriendoServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.personaCompra.PersonaCompraServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.personaVenta.PersonaVentaServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.ventas.VentaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImp implements PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private CuentaCobroServiceImp cuentaCobroServiceImp;

    @Autowired
    private InmuebleServiceImp inmuebleServiceImp;

    @Autowired
    private VentaServiceImp ventaServiceImp;

    @Autowired
    private AnalisisRiesgoServiceImp analisisRiesgoServiceImp;

    @Override
    public List<Pago> listarPagos() {
        return pagoRepository.findAll();
    }

    @Override
    public PagoDTO crearPago(Long idCuentaCobro, Long idComprador, PagoInputDTO pagoInputDTO) {
        Pago pago = new Pago();
        CuentaCobro cuentaCobro = cuentaCobroServiceImp.encontrarPorId(idCuentaCobro);

        pago.setCuentaCobro(cuentaCobro);
        pago.setMonto(cuentaCobro.getMonto());
        pago.setTipo_pago(pagoInputDTO.getTipoPago());

        if (cuentaCobro.getCompraList().size() > 0 && cuentaCobro.getCompraList() != null) {
            int lastIn = cuentaCobro.getCompraList().size() - 1;
            int inmuebleId = cuentaCobro.getCompraList().get(lastIn).getInmueble().getId();
            Inmueble inmueble = inmuebleServiceImp.encontrarPorIdInmueble((long) inmuebleId);
            Persona exPropietario = inmueble.getPersona();
            Optional<Persona> comercial = inmueble.getCompraList().get(lastIn).getPersonaCompraList().stream()
                    .filter(pc -> pc.getPersona().getTipoPersona().getDescripcion().equalsIgnoreCase("Comercial"))
                    .map(pc -> pc.getPersona())
                    .findFirst();
            InmubleInputDTO inmubleInputDTO = new InmubleInputDTO(inmueble);
            // cambio de propietario
            InmuebleDTO inmuebleUpdated = inmuebleServiceImp.modificarInmueble(Long.valueOf(inmuebleId), idComprador, inmubleInputDTO);
            // registro de venta
            if (comercial.isPresent()) {
                registrarVenta((long) exPropietario.getId(), (long) comercial.get().getId(), idComprador, (long) inmueble.getId());
            }
        }

        if (cuentaCobro.getArriendoList().size() > 0 && cuentaCobro.getArriendoList() != null) {
            int lastIn = cuentaCobro.getArriendoList().size() - 1;
            int inmuebleId = cuentaCobro.getArriendoList().get(lastIn).getInmueble().getId();
            Inmueble inmueble = inmuebleServiceImp.encontrarPorIdInmueble((long) inmuebleId);
            Persona propietario = inmueble.getPersona();
            Optional<Persona> comercial = inmueble.getArriendoList().get(lastIn).getPersonaArriendoList().stream()
                    .filter(pc -> pc.getPersona().getTipoPersona().getDescripcion().equalsIgnoreCase("Comercial"))
                    .map(pc -> pc.getPersona())
                    .findFirst();
            // registro de venta
            if (comercial.isPresent()) {
                registrarVenta((long) propietario.getId(), (long) comercial.get().getId(), idComprador, (long) inmueble.getId());
            }
        }

        if (cuentaCobro.getAnalisisRiesgoList().size() > 0 && cuentaCobro.getAnalisisRiesgoList() != null) {
            int lastIn = cuentaCobro.getAnalisisRiesgoList().size() - 1;
            AnalisisRiesgo analisisRiesgo = cuentaCobro.getAnalisisRiesgoList().get(lastIn);

            analisisRiesgo = analisisRiesgoServiceImp.modificarAnalisisRiesgo((long) analisisRiesgo.getId(), Boolean.TRUE);
        }
        pago = pagoRepository.save(pago);

        PagoDTO pagoDTO = new PagoDTO();
        if (pago != null) {
            pagoDTO.setStatus(Boolean.TRUE);
        } else {
            pagoDTO.setStatus(Boolean.FALSE);
        }
        return pagoDTO;
    }

    private void registrarVenta(Long idPropietario, Long idComercial, Long idComprador, Long idInmueble) {
        VentaDTO ventaDTO = ventaServiceImp.crearVenta(idPropietario, idComercial, idComprador, idInmueble);
    }
}
