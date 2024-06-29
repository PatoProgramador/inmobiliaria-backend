package co.edu.inmobiliaria.backendverkev.controladores;

import co.edu.inmobiliaria.backendverkev.dominio.Persona;
import co.edu.inmobiliaria.backendverkev.dtos.PersonaDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.PersonaInputDTO;
import co.edu.inmobiliaria.backendverkev.servicios.persona.PersonaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/persona"})
public class PersonaControlador {
    @Autowired
    private PersonaServiceImp personaServiceImp;

    @GetMapping("/listar")
    public List<PersonaDTO> getAll() {
        return personaServiceImp.listar();
    }

    @GetMapping("/{idPersona}")
    public PersonaDTO traerPersonaPorId(@PathVariable Long idPersona) {
        return personaServiceImp.traerPorIdDTO(idPersona);
    }

    @GetMapping("/listar/comerciales")
    public List<PersonaDTO> traerTodosLosComerciales() {
        return personaServiceImp.traerTodosLosComerciales();
    }

    @GetMapping("/tipoDocumento/{idTipoDocumento}/documento/{documento}")
    public PersonaDTO traerPersonaPorTipoDocumentYDoc(@PathVariable Long idTipoDocumento, @PathVariable String documento){
        return personaServiceImp.traerPorTipoDocumentYDoc(idTipoDocumento, documento);
    }

    @PostMapping("/crearPersona/tipoPersona/{idTipoPersona}/tipoIdentificacion/{idTipoIdentificacion}/sucursal/{idSucursal}")
    public PersonaDTO crear(@PathVariable Long idTipoPersona, @PathVariable Long idTipoIdentificacion, @PathVariable Long idSucursal, @RequestBody PersonaInputDTO personaInputDTO) {
        return personaServiceImp.crearPersona(idTipoPersona, idTipoIdentificacion, idSucursal, personaInputDTO);
    }

    @PutMapping("/modificarPersona/{idPersona}/tipoPersona/{idTipoPersona}/tipoIdentificacion/{idTipoIdentificacion}/sucursal/{idSucursal}")
    public PersonaDTO modificar(@PathVariable Long idPersona,@PathVariable Long idTipoPersona, @PathVariable Long idTipoIdentificacion, @PathVariable Long idSucursal, @RequestBody PersonaInputDTO personaInputDTO) {
        return personaServiceImp.modificarPersona(idPersona, idTipoPersona, idTipoIdentificacion, idSucursal, personaInputDTO);
    }

    @DeleteMapping("/borrar/{idPersona}")
    public PersonaDTO eliminar(@PathVariable Long idPersona) {
        return personaServiceImp.eliminarPersona(idPersona);
    }
}
