package co.edu.inmobiliaria.backendverkev.controladores;

import co.edu.inmobiliaria.backendverkev.dominio.Pago;
import co.edu.inmobiliaria.backendverkev.inputdtos.PagoInputDTO;
import co.edu.inmobiliaria.backendverkev.servicios.pago.PagoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/pago"})
public class PagoControlador {
    @Autowired
    private PagoServiceImp pagoServiceImp;

    @PostMapping("/crear/{idCuentaCobro}/comprador/{idComprador}")
    public Pago crearPago(@PathVariable Long idCuentaCobro, @PathVariable Long idComprador, @RequestBody PagoInputDTO pagoInputDTO) {
        return pagoServiceImp.crearPago(idCuentaCobro,idComprador, pagoInputDTO);
    }
}
