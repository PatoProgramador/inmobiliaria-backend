package co.edu.inmobiliaria.backendverkev.controladores;

import co.edu.inmobiliaria.backendverkev.dominio.TipoPersona;
import co.edu.inmobiliaria.backendverkev.dtos.CiudadDTO;
import co.edu.inmobiliaria.backendverkev.dtos.TipoIdentificacionDTO;
import co.edu.inmobiliaria.backendverkev.repositorios.TipoPersonaRepository;
import co.edu.inmobiliaria.backendverkev.servicios.ciudad.CiudadServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.tipoIdentificacion.TipoIdentificacionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/catalogo"})
public class CatalogoControlador {
    @Autowired
    private CiudadServiceImp ciudadServiceImp;

    @Autowired
    private TipoIdentificacionServiceImp tipoIdentificacionServiceImp;

    @GetMapping("/ciudad/listar")
    public List<CiudadDTO> listarCiudades() {
        return ciudadServiceImp.listar();
    }

    @GetMapping("/tipoIdenficacion/listar")
    public List<TipoIdentificacionDTO> listarTiposIdentificacion() {
        return tipoIdentificacionServiceImp.listar();
    }

}
