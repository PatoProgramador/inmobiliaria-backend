package co.edu.inmobiliaria.backendverkev.servicios.comision;

import co.edu.inmobiliaria.backendverkev.dominio.Comisiones;
import co.edu.inmobiliaria.backendverkev.dominio.Venta;
import co.edu.inmobiliaria.backendverkev.repositorios.ComisionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComisionServiceImp implements ComisionService{
    @Autowired
    private ComisionesRepository comisionesRepository;

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
        return comisiones;
    }
}
