package co.edu.inmobiliaria.backendverkev.controladores;

import co.edu.inmobiliaria.backendverkev.dtos.CuentaCobroDTO;
import co.edu.inmobiliaria.backendverkev.servicios.cuentaCobro.CuentaCobroServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/cuentaCobro"})
public class CuentaCobroControlador {
    @Autowired
    private CuentaCobroServiceImp cuentaCobroServiceImp;

    @GetMapping("/listar/comprasPendientes/{idPersona}")
    public List<CuentaCobroDTO> listarComprasPendientesPersona(@PathVariable Long idPersona) {
        return  cuentaCobroServiceImp.listarCuentasPendientesCompras(idPersona);
    }

    @GetMapping("/listar/arriendosPendientes/{idPersona}")
    public List<CuentaCobroDTO> listarArriendosPendientesPersona(@PathVariable Long idPersona) {
        return  cuentaCobroServiceImp.listarCuentasPendientesArriendo(idPersona);
    }

    @GetMapping("/listar/analisisPedientes/{idPersona}")
    public  List<CuentaCobroDTO> listarAnalisisPendientesPersona(@PathVariable Long idPersona) {
        return cuentaCobroServiceImp.listarCuentasPendientesAnalisis(idPersona);
    }
}
