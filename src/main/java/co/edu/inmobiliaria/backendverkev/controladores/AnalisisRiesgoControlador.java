package co.edu.inmobiliaria.backendverkev.controladores;

import co.edu.inmobiliaria.backendverkev.dominio.AnalisisRiesgo;
import co.edu.inmobiliaria.backendverkev.dtos.AnalisisRiesgoDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.AnalisisRiesgoInputDTO;
import co.edu.inmobiliaria.backendverkev.servicios.analisisRiesgo.AnalisisRiesgoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/analisisRiesgo"})
public class AnalisisRiesgoControlador {
    @Autowired
    private AnalisisRiesgoServiceImp analisisRiesgoServiceImp;

    @PostMapping("crear/inmueble/{idInmueble}")
    public AnalisisRiesgoDTO crearAnalisisRiesgo(@PathVariable Long idInmueble, @RequestBody AnalisisRiesgoInputDTO analisisRiesgoInputDTO) {
        return analisisRiesgoServiceImp.crearAnalisisRiesgo(idInmueble, analisisRiesgoInputDTO);
    }
}
