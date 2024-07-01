package co.edu.inmobiliaria.backendverkev.controladores;

import co.edu.inmobiliaria.backendverkev.dominio.Compra;
import co.edu.inmobiliaria.backendverkev.dtos.CompraDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.CompraInputDTO;
import co.edu.inmobiliaria.backendverkev.servicios.compra.CompraServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/compra"})
public class CompraControlador {
    @Autowired
    private CompraServiceImp compraServiceImp;

    @PostMapping("/crear/propietario/{idPropietario}/comercial/{idComercial}/comprador/{idComprador}/inmueble/{idInmueble}")
    public CompraDTO crearCompra(@PathVariable Long idPropietario, @PathVariable Long idComercial, @PathVariable Long idComprador, @PathVariable Long idInmueble, @RequestBody CompraInputDTO compraInputDTO) {
        return compraServiceImp.crearCompra(idPropietario, idComercial, idComprador, idInmueble, compraInputDTO);
    }
}
