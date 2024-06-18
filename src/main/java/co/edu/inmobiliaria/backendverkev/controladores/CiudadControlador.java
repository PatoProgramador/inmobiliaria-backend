package co.edu.inmobiliaria.backendverkev.controladores;

import co.edu.inmobiliaria.backendverkev.dominio.Ciudad;
import co.edu.inmobiliaria.backendverkev.dtos.CiudadDTO;
import co.edu.inmobiliaria.backendverkev.servicios.ciudad.CiudadServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/ciudad"})
public class CiudadControlador {
    @Autowired
    private CiudadServiceImp ciudadServiceImp;

    @GetMapping("/getAll")
    public List<CiudadDTO> getAll() {
        return ciudadServiceImp.listar();
    }
}
