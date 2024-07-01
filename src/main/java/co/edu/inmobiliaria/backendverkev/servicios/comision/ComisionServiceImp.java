package co.edu.inmobiliaria.backendverkev.servicios.comision;

import co.edu.inmobiliaria.backendverkev.dominio.Comisiones;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaVenta;
import co.edu.inmobiliaria.backendverkev.dominio.Venta;
import co.edu.inmobiliaria.backendverkev.dtos.ComisionDTO;
import co.edu.inmobiliaria.backendverkev.repositorios.ComisionesRepository;
import co.edu.inmobiliaria.backendverkev.servicios.personaVenta.PersonaVentaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComisionServiceImp implements ComisionService{
    @Autowired
    private ComisionesRepository comisionesRepository;

    @Autowired
    private PersonaVentaServiceImp personaVentaServiceImp;

    @Override
    public List<ComisionDTO> traerComisionesPorVendedor(Long idComercial) {
        List<PersonaVenta> personaVentaList = personaVentaServiceImp.traerPorIdPersona(idComercial);

        List<Comisiones> comisiones = personaVentaList.stream()
                .flatMap(pv -> pv.getVenta().getComisionesList().stream())
                .collect(Collectors.toList());

        return comisiones.stream()
                .map(c -> new ComisionDTO(c))
                .collect(Collectors.toList());
    }

    @Override
    public Comisiones crearComisiones(Venta venta) {
        Comisiones comisiones = new Comisiones();
        Double porcentaje = 0.15;
        int lastInd = venta.getInmueble().getAvaluoList().size() - 1;
        Double valorInmueble = venta.getInmueble().getAvaluoList().get(lastInd).getPrecio();
        Double valorFinal = valorInmueble * porcentaje;
        // atributos...
        comisiones.setPorcentaje(porcentaje);
        comisiones.setMonto(valorFinal);
        comisiones.setVenta(venta);

        comisiones = comisionesRepository.save(comisiones);
        return comisiones;
    }
}
