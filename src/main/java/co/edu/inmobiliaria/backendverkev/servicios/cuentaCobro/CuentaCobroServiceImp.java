package co.edu.inmobiliaria.backendverkev.servicios.cuentaCobro;

import co.edu.inmobiliaria.backendverkev.dominio.CuentaCobro;
import co.edu.inmobiliaria.backendverkev.dominio.Persona;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaCompra;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaVenta;
import co.edu.inmobiliaria.backendverkev.dtos.CuentaCobroDTO;
import co.edu.inmobiliaria.backendverkev.repositorios.CuentaCobroRepository;
import co.edu.inmobiliaria.backendverkev.servicios.persona.PersonaServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.personaCompra.PersonaCompraServiceImp;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CuentaCobroServiceImp implements CuentaCobroService{
    @Autowired
    private CuentaCobroRepository cuentaCobroRepository;
    @Autowired
    private PersonaCompraServiceImp personaCompraServiceImp;

    @Autowired
    private PersonaServiceImp personaServiceImp;

    @Override
    public List<CuentaCobroDTO> listarCuentasPendientesCompras(Long idPersona) {
        Persona persona = personaServiceImp.traerPorIdPersona(idPersona);
        Optional<Integer> idPropietario = personaCompraServiceImp.traerPorIdPersona(idPersona).stream()
                .filter(pc -> pc.getCompra().getCuentaCobro().getPagoList().size() == 0)
                .map(pc -> pc.getCompra().getInmueble().getPersona().getId())
                .findFirst();
        if (idPropietario.isPresent()) {
            System.out.println(persona.getTipoPersona().getDescripcion());
            System.out.println(idPropietario.get());
            if (!persona.getTipoPersona().getDescripcion().equalsIgnoreCase("Comercial") && persona.getId() != idPropietario.get()) {
                List<CuentaCobro> personaCuentaCobro = personaCompraServiceImp.traerPorIdPersona(idPersona).stream()
                        .filter(pc -> pc.getCompra().getCuentaCobro().getPagoList().size() == 0)
                        .map(pc -> pc.getCompra().getCuentaCobro())
                        .collect(Collectors.toList());

                return personaCuentaCobro.stream()
                        .map(c -> new CuentaCobroDTO(c))
                        .collect(Collectors.toList());
            } else {
                return null;
            }

        } else {
            throw new EntityNotFoundException("No se encontró la persona con id:  " + idPersona);
        }
    }

    @Override
    public List<CuentaCobroDTO> listarCuentasPendientesArriendo(Long idPersona) {
        return null;
    }

    @Override
    public List<CuentaCobroDTO> listarCuentasPendientesAnalisis(Long idPersona) {
        return null;
    }

    @Override
    public CuentaCobro crearCuentaCobro(CuentaCobro cuentaCobro) {
        CuentaCobro cuentaCobroDb = cuentaCobroRepository.save(cuentaCobro);
        return cuentaCobroDb;
    }
}
