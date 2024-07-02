package co.edu.inmobiliaria.backendverkev.controladores;

import co.edu.inmobiliaria.backendverkev.dominio.Avaluo;
import co.edu.inmobiliaria.backendverkev.dtos.AvaluoDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.AvaluoInputDTO;
import co.edu.inmobiliaria.backendverkev.servicios.avaluo.AvaluoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/avaluo"})
public class AvaluoControlador {
    @Autowired
    private AvaluoServiceImp avaluoServiceImp;

    @PostMapping("/crearAvaluo/inmueble/{idInmueble}")
    public AvaluoDTO crearAvaluo(@PathVariable Long idInmueble, @RequestBody AvaluoInputDTO avaluoInputDTO) {
        return avaluoServiceImp.crearAvaluo(idInmueble, avaluoInputDTO);
    }
}
