package co.edu.inmobiliaria.backendverkev.servicios.cuentaCobro;

import co.edu.inmobiliaria.backendverkev.dominio.*;
import co.edu.inmobiliaria.backendverkev.dtos.CuentaCobroDTO;
import co.edu.inmobiliaria.backendverkev.repositorios.CuentaCobroRepository;
import co.edu.inmobiliaria.backendverkev.servicios.inmueble.InmuebleServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.persona.PersonaServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.personaArriendo.PersonaArriendoServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.personaCompra.PersonaCompraServiceImp;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CuentaCobroServiceImp implements CuentaCobroService {
    @Autowired
    private CuentaCobroRepository cuentaCobroRepository;
    @Autowired
    private PersonaCompraServiceImp personaCompraServiceImp;
    @Autowired
    private PersonaArriendoServiceImp personaArriendoServiceImp;
    @Autowired
    private InmuebleServiceImp inmuebleServiceImp;

    @Autowired
    private PersonaServiceImp personaServiceImp;

    @Override
    public List<CuentaCobroDTO> listarCuentasPendientesCompras(Long idPersona) {
        Persona persona = personaServiceImp.traerPorIdPersona(idPersona);

        if (!persona.getTipoPersona().getDescripcion().equalsIgnoreCase("Comercial")) {
            List<CuentaCobro> personaCuentaCobro = personaCompraServiceImp.traerPorIdPersona(idPersona).stream()
                    // evitamos que sea el propietario
                    .filter(pc -> pc.getCompra().getInmueble().getPersona().getId() != idPersona)
                    .filter(pc -> pc.getCompra().getCuentaCobro().getPagoList().size() == 0)
                    .map(pc -> pc.getCompra().getCuentaCobro())
                    .collect(Collectors.toList());

            return personaCuentaCobro.stream()
                    .map(c -> new CuentaCobroDTO(c))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Override
    public List<CuentaCobroDTO> listarCuentasPendientesArriendo(Long idPersona) {
        Persona persona = personaServiceImp.traerPorIdPersona(idPersona);

        if (!persona.getTipoPersona().getDescripcion().equalsIgnoreCase("Comercial")) {
            List<CuentaCobro> personaCuentaCobro = personaArriendoServiceImp.traerPorPersona(idPersona).stream()
                    .filter(pc -> pc.getArriendo().getInmueble().getPersona().getId() != idPersona)
                    .filter(pc -> pc.getArriendo().getCuentaCobro().getPagoList().size() == 0)
                    .map(pc -> pc.getArriendo().getCuentaCobro())
                    .collect(Collectors.toList());

            return personaCuentaCobro.stream()
                    .map(c -> new CuentaCobroDTO(c))
                    .collect(Collectors.toList());
        } else {
            return null;
        }

    }

    @Override
    public List<CuentaCobroDTO> listarCuentasPendientesAnalisis(Long idPersona) {
        List<Inmueble> inmuebles = inmuebleServiceImp.encontrarInmueblePropietario(idPersona).stream()
                .filter(i -> i.getAnalisisRiesgoList().size() > 0)
                .collect(Collectors.toList());

        if (inmuebles.size() > 0) {
            List<CuentaCobro> cuentaCobros = inmuebles.stream()
                    .flatMap(in -> in.getAnalisisRiesgoList().stream())
                    .filter(ar -> ar.getCuentaCobro().getPagoList().isEmpty())
                    .map(ar -> ar.getCuentaCobro())
                    .collect(Collectors.toList());

            return cuentaCobros.stream()
                    .map(c -> new CuentaCobroDTO(c))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Override
    public CuentaCobro encontrarPorId(Long idCuentaCobro) {
        Optional<CuentaCobro> cuentaCobro = cuentaCobroRepository.findById(idCuentaCobro);

        if (cuentaCobro.isPresent()) {
            return cuentaCobro.get();
        } else {
            throw new EntityNotFoundException("No se encontró la cuenta con id:  " + idCuentaCobro);
        }
    }

    @Override
    public CuentaCobroDTO encontrarPorIdDTO(Long idCuentaCobro) {
        Optional<CuentaCobro> cuentaCobro = cuentaCobroRepository.findById(idCuentaCobro);

        if (cuentaCobro.isPresent()) {
            return new CuentaCobroDTO(cuentaCobro.get());
        } else {
            throw new EntityNotFoundException("No se encontró la cuenta con id:  " + idCuentaCobro);
        }
    }

    @Override
    public CuentaCobro crearCuentaCobro(CuentaCobro cuentaCobro) {
        CuentaCobro cuentaCobroDb = cuentaCobroRepository.save(cuentaCobro);
        return cuentaCobroDb;
    }
}
