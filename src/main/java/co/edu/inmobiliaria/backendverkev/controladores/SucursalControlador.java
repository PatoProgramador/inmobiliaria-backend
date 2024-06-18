package co.edu.inmobiliaria.backendverkev.controladores;

import co.edu.inmobiliaria.backendverkev.dtos.SucursalDTO;
import co.edu.inmobiliaria.backendverkev.servicios.sucursal.SucursalServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/sucursal"})
public class SucursalControlador {
    @Autowired
    private SucursalServiceImp sucursalServiceImp;

    @GetMapping("/getAll")
    public List<SucursalDTO> getAll() {
        return sucursalServiceImp.listar();
    }
}
