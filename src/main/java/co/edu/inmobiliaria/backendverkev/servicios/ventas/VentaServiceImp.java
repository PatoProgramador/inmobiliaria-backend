package co.edu.inmobiliaria.backendverkev.servicios.ventas;

import co.edu.inmobiliaria.backendverkev.dominio.Comisiones;
import co.edu.inmobiliaria.backendverkev.dominio.Inmueble;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaVenta;
import co.edu.inmobiliaria.backendverkev.dominio.Venta;
import co.edu.inmobiliaria.backendverkev.dtos.VentaDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.VentaInputDTO;
import co.edu.inmobiliaria.backendverkev.repositorios.VentaRepository;
import co.edu.inmobiliaria.backendverkev.servicios.comision.ComisionServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.inmueble.InmuebleServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.personaVenta.PersonaVentaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VentaServiceImp implements VentaService{
    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private InmuebleServiceImp inmuebleServiceImp;
    @Autowired
    private PersonaVentaServiceImp personaVentaServiceImp;
    @Autowired
    private ComisionServiceImp comisionServiceImp;

    @Override
    public VentaDTO crearVenta(Long idPropietario, Long idComercial, Long idComprador, Long idInmueble, VentaInputDTO ventaInputDTO) {
        Venta venta = new Venta();
        // inmueble asociado
        Inmueble inmueble = inmuebleServiceImp.encontrarPorIdInmueble(idInmueble);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
        venta.setInmueble(inmueble);
        // propiedades
        try {
            Date fecha = simpleDateFormat.parse(ventaInputDTO.getFecha());
            venta.setFecha(fecha);
        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
        }
        // instancia..
        venta = ventaRepository.save(venta);
        // relacion uno a muchos
        List<PersonaVenta> personaVentaList = new ArrayList<>(List.of(
                personaVentaServiceImp.crearPersonaVenta(idPropietario, venta),
                personaVentaServiceImp.crearPersonaVenta(idComercial, venta),
                personaVentaServiceImp.crearPersonaVenta(idComprador, venta)
                ));
        venta.setPersonaVentaList(personaVentaList);
        // comisiones
        List<Comisiones> comisiones = new ArrayList<>(List.of(
                comisionServiceImp.crearComisiones(venta)
        ));
        venta.setComisionesList(comisiones);
        return new VentaDTO(venta);
    }
}
