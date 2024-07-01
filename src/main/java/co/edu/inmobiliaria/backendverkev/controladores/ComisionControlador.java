package co.edu.inmobiliaria.backendverkev.controladores;

import co.edu.inmobiliaria.backendverkev.dtos.ComisionDTO;
import co.edu.inmobiliaria.backendverkev.servicios.comision.ComisionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/comisiones"})
public class ComisionControlador {

    @Autowired
    private ComisionServiceImp comisionServiceImp;

    @GetMapping("listar/idComercial/{idComercial}")
    public List<ComisionDTO> listarPorComercial(@PathVariable Long idComercial) {
        return comisionServiceImp.traerComisionesPorVendedor(idComercial);
    }
}
