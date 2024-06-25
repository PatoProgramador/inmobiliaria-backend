package co.edu.inmobiliaria.backendverkev.controladores;

import co.edu.inmobiliaria.backendverkev.dominio.Inmueble;
import co.edu.inmobiliaria.backendverkev.dtos.InmuebleDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.InmubleInputDTO;
import co.edu.inmobiliaria.backendverkev.servicios.inmueble.InmuebleServiceImp;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/inmueble"})
public class InmuebleControlador {

    @Autowired
    private InmuebleServiceImp inmuebleServiceImp;

    @GetMapping("/listar")
    public List<InmuebleDTO> listarInmuebles() {
        return inmuebleServiceImp.listar();
    }

    @GetMapping("/listar/{ciudad}")
    public List<InmuebleDTO> listarInmueblesPorCiudad(@PathVariable String ciudad) { return inmuebleServiceImp.listarPorCiudad(ciudad);}

    @GetMapping("/{idInmueble}")
    public InmuebleDTO obtenerPorId(@PathVariable Long idInmueble) {
        return inmuebleServiceImp.encontrarPorIdInmuebleDTO(idInmueble);
    }
    @PostMapping("/crearInmueble/persona/{idPersona}")
    public InmuebleDTO crearInmueble(@PathVariable Long idPersona, @RequestBody InmubleInputDTO inmubleInputDTO) {
        return inmuebleServiceImp.crearInmueble(idPersona, inmubleInputDTO);
    }

    @PutMapping("/modificarInmueble/{idInmueble}/persona/{idPersona}")
    public InmuebleDTO modificarInmueble(@PathVariable Long idInmueble, @PathVariable Long idPersona, @RequestBody InmubleInputDTO inmubleInputDTO) {
        return inmuebleServiceImp.modificarInmueble(idInmueble, idPersona, inmubleInputDTO);
    }
}
