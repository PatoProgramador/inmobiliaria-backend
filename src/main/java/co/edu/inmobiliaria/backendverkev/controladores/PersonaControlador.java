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

    @GetMapping("/getAll")
    public List<PersonaDTO> getAll() {
        return personaServiceImp.listar();
    }

    @PostMapping("/crearPersona/tipoPersona/{idTipoPersona}/tipoIdentificacion/{idTipoIdentificacion}/sucursal/{idSucursal}")
    public PersonaDTO crear(@PathVariable Long idTipoPersona, @PathVariable Long idTipoIdentificacion, @PathVariable Long idSucursal, @RequestBody PersonaInputDTO personaInputDTO) {
        return personaServiceImp.crearPersona(idTipoPersona, idTipoIdentificacion, idSucursal, personaInputDTO);
    }
}
