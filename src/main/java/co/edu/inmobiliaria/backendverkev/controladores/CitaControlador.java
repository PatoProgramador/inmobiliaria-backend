package co.edu.inmobiliaria.backendverkev.controladores;

import co.edu.inmobiliaria.backendverkev.dominio.Citas;
import co.edu.inmobiliaria.backendverkev.dtos.CitaDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.CitaInputDTO;
import co.edu.inmobiliaria.backendverkev.servicios.citas.CitaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/citas"})
public class CitaControlador {
    @Autowired
    private CitaServiceImp citaServiceImp;

    @PostMapping("/crear/inmueble/{idInmueble}/propietario/{idPropietario}/comprador/{idComprador}/comercial/{idComercial}")
    public CitaDTO crearCita(@PathVariable Long idInmueble, @PathVariable Long idPropietario, @PathVariable Long idComprador, @PathVariable Long idComercial, @RequestBody CitaInputDTO citaInputDTO) {
        return citaServiceImp.crearCita(idInmueble, idPropietario, idComprador, idComercial, citaInputDTO);
    }
}
