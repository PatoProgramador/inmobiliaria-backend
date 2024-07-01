package co.edu.inmobiliaria.backendverkev.controladores;

import co.edu.inmobiliaria.backendverkev.dominio.Venta;
import co.edu.inmobiliaria.backendverkev.dtos.VentaDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.VentaInputDTO;
import co.edu.inmobiliaria.backendverkev.servicios.ventas.VentaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/venta"})
public class VentaControlador {
    @Autowired
    private VentaServiceImp ventaServiceImp;

    @PostMapping("/crear/propietario/{idPropietario}/comercial/{idComercial}/comprador/{idComprador}/inmueble/{idInmueble}")
    public VentaDTO CrearVenta(@PathVariable Long idPropietario, @PathVariable Long idComercial, @PathVariable Long idComprador, @PathVariable Long idInmueble, @RequestBody VentaInputDTO ventaInputDTO) {
        return ventaServiceImp.crearVenta(idPropietario,idComercial,idComprador,idInmueble,ventaInputDTO);
    }
}
