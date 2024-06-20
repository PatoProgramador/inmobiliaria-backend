package co.edu.inmobiliaria.backendverkev.controladores;

import co.edu.inmobiliaria.backendverkev.dominio.Arriendo;
import co.edu.inmobiliaria.backendverkev.dtos.ArriendoDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.ArriendoInputDTO;
import co.edu.inmobiliaria.backendverkev.servicios.arriendo.ArriendoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/arriendo"})
public class ArriendoControlador {
    @Autowired
    private ArriendoServiceImp arriendoServiceImp;

    @GetMapping("/listar")
    public List<ArriendoDTO> listar() {
        return arriendoServiceImp.listar();
    }

    @PostMapping("/crear/propietario/{idPropietario}/comercial/{idComercial}/arrendatario/{idArrendatario}/inmueble/{idInmueble}")
    public ArriendoDTO crearArriendo(@PathVariable Long idPropietario, @PathVariable Long idComercial, @PathVariable Long idArrendatario, @PathVariable Long idInmueble, @RequestBody ArriendoInputDTO arriendoInputDTO) {
        return arriendoServiceImp.crearArriendo(idPropietario, idComercial, idArrendatario, idInmueble, arriendoInputDTO);
    }
}
