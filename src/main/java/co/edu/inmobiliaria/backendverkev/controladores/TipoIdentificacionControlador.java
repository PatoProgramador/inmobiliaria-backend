package co.edu.inmobiliaria.backendverkev.controladores;

import co.edu.inmobiliaria.backendverkev.dtos.TipoIdentificacionDTO;
import co.edu.inmobiliaria.backendverkev.servicios.tipoIdentificacion.TipoIdentificacionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/tipoIdentificacion"})
public class TipoIdentificacionControlador {
    @Autowired
    private TipoIdentificacionServiceImp tipoIdentificacionServiceImp;

    @GetMapping("/getAll")
    public List<TipoIdentificacionDTO> getAll() {
        return tipoIdentificacionServiceImp.listar();
    }
}
