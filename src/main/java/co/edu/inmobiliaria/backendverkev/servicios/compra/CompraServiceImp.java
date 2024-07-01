package co.edu.inmobiliaria.backendverkev.servicios.compra;

import co.edu.inmobiliaria.backendverkev.dominio.Compra;
import co.edu.inmobiliaria.backendverkev.dominio.CuentaCobro;
import co.edu.inmobiliaria.backendverkev.dominio.Inmueble;
import co.edu.inmobiliaria.backendverkev.dominio.PersonaCompra;
import co.edu.inmobiliaria.backendverkev.inputdtos.CompraInputDTO;
import co.edu.inmobiliaria.backendverkev.repositorios.CompraRepository;
import co.edu.inmobiliaria.backendverkev.servicios.cuentaCobro.CuentaCobroServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.inmueble.InmuebleServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.personaCompra.PersonaCompraServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CompraServiceImp implements CompraService{
    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private InmuebleServiceImp inmuebleServiceImp;

    @Autowired
    private CuentaCobroServiceImp cobroServiceImp;
    @Autowired
    private PersonaCompraServiceImp personaCompraServiceImp;

    @Override
    public Compra crearCompra(Long idPropietario, Long idComercial, Long idComprador, Long idInmueble, CompraInputDTO compraInputDTO) {
        Compra compra = new Compra();
        // se setea en falso en tanto no ha sido pago
        compra.setEstado(Boolean.FALSE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
        // Buscamos el inmueble relacionado
        Inmueble inmuebleDb = inmuebleServiceImp.encontrarPorIdInmueble(idInmueble);
        compra.setInmueble(inmuebleDb);
        // fecha de compra...
        try {
            Date fecha = simpleDateFormat.parse(compraInputDTO.getFecha());
            compra.setFecha(fecha);
        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
        }
        // cuenta de cobro
        CuentaCobro cuentaCobro = new CuentaCobro();
        int lastItemIndex = inmuebleDb.getAvaluoList().size() - 1;

        cuentaCobro.setMonto(inmuebleDb.getAvaluoList().get(lastItemIndex).getPrecio());
        try {
            String codigo = generarUUID();
            cuentaCobro.setCuenta(codigo);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        CuentaCobro cuentaCobroDB = cobroServiceImp.crearCuentaCobro(cuentaCobro);
        compra.setCuentaCobro(cuentaCobroDB);
        Compra compraDB = compraRepository.save(compra);
        // personas relacionadas...
        List<PersonaCompra> personaCompraList = new ArrayList<>(List.of(
                personaCompraServiceImp.crearPersonaCompra(idPropietario, compraDB),
                personaCompraServiceImp.crearPersonaCompra(idComercial, compraDB),
                personaCompraServiceImp.crearPersonaCompra(idComprador, compraDB)
                ));
        compra.setPersonaCompraList(personaCompraList);
        return compra;
    }

    private String generarUUID() throws NoSuchAlgorithmException {
        // Generar un UUID
        String uuid = UUID.randomUUID().toString();
        // Crear un hash SHA-256 del UUID
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(uuid.getBytes());

        // Convertir el hash a una cadena Base64
        String base64Hash = Base64.getUrlEncoder().withoutPadding().encodeToString(hash);

        // Limitar la cadena resultante a 20 caracteres
        return base64Hash.substring(0, 20);
    }
}
