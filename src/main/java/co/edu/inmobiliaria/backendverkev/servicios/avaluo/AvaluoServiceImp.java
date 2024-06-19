package co.edu.inmobiliaria.backendverkev.servicios.avaluo;

import co.edu.inmobiliaria.backendverkev.dominio.Avaluo;
import co.edu.inmobiliaria.backendverkev.dominio.Inmueble;
import co.edu.inmobiliaria.backendverkev.inputdtos.AvaluoInputDTO;
import co.edu.inmobiliaria.backendverkev.repositorios.AvaluoRepository;
import co.edu.inmobiliaria.backendverkev.servicios.inmueble.InmuebleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AvaluoServiceImp implements AvaluoService {

    @Autowired
    private AvaluoRepository avaluoRepository;

    @Autowired
    private InmuebleServiceImp inmuebleServiceImp;

    @Override
    public Avaluo crearAvaluo(Long idInmueble, AvaluoInputDTO avaluoInputDTO) {
        Avaluo avaluo = new Avaluo();
        // relacion con inmueble...
        Inmueble inmueble = inmuebleServiceImp.encontrarPorIdInmueble(idInmueble);
        avaluo.setInmueble(inmueble);

        // otros atributos..
        avaluo.setDescripcion(avaluoInputDTO.getDescripcion());
        avaluo.setPrecio(avaluoInputDTO.getPrecio());
        avaluo.setFecha(new Date());
        avaluoRepository.save(avaluo);
        return avaluo;
    }
}
