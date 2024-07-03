package co.edu.inmobiliaria.backendverkev.servicios.analisisRiesgo;

import co.edu.inmobiliaria.backendverkev.dominio.AnalisisRiesgo;
import co.edu.inmobiliaria.backendverkev.dominio.CuentaCobro;
import co.edu.inmobiliaria.backendverkev.dominio.Inmueble;
import co.edu.inmobiliaria.backendverkev.dtos.AnalisisRiesgoDTO;
import co.edu.inmobiliaria.backendverkev.inputdtos.AnalisisRiesgoInputDTO;
import co.edu.inmobiliaria.backendverkev.repositorios.AnalisisdeRiesgoRepository;
import co.edu.inmobiliaria.backendverkev.servicios.cuentaCobro.CuentaCobroServiceImp;
import co.edu.inmobiliaria.backendverkev.servicios.inmueble.InmuebleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnalisisRiesgoServiceImp implements analisisRiesgoService{
    @Autowired
    private AnalisisdeRiesgoRepository analisisdeRiesgoRepository;

    @Autowired
    private InmuebleServiceImp inmuebleServiceImp;

    @Autowired
    private CuentaCobroServiceImp cobroServiceImp;

    @Override
    public AnalisisRiesgoDTO crearAnalisisRiesgo(Long idInmueble, AnalisisRiesgoInputDTO analisisRiesgoInputDTO) {
        AnalisisRiesgo analisisRiesgo = new AnalisisRiesgo();
        CuentaCobro cuentaCobro = new CuentaCobro();
        // aun no ha sido paga
        analisisRiesgo.setAprobado(Boolean.FALSE);
        analisisRiesgo.setDescripcion(analisisRiesgoInputDTO.getDescripcion());
        // relacion con inmueble
        Inmueble inmuebleDb = inmuebleServiceImp.encontrarPorIdInmueble(idInmueble);
        analisisRiesgo.setInmueble(inmuebleDb);
        // cuenta de cobro
        try {
            String codigo = generarUUID();
            cuentaCobro.setCuenta(codigo);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // precio..
        int lastItemIndex = inmuebleDb.getAvaluoList().size() - 1;
        Double precio = inmuebleDb.getAvaluoList().get(lastItemIndex).getPrecio();
        Double porcentaje = 0.05;

        Double precioFinal = precio * porcentaje;
        cuentaCobro.setMonto(precioFinal);
        cuentaCobro = cobroServiceImp.crearCuentaCobro(cuentaCobro);
        // instancias...
        analisisRiesgo.setCuentaCobro(cuentaCobro);
        analisisRiesgo = analisisdeRiesgoRepository.save(analisisRiesgo);

        return new AnalisisRiesgoDTO(analisisRiesgo);
    }

    @Override
    public AnalisisRiesgo modificarAnalisisRiesgo(Long idAnalisisRiesgo, Boolean estado) {
        Optional<AnalisisRiesgo> analisisRiesgo = analisisdeRiesgoRepository.findById(idAnalisisRiesgo);

        if (analisisRiesgo.isPresent()) {
            AnalisisRiesgo analisisRiesgoDB = analisisRiesgo.get();
            analisisRiesgoDB.setAprobado(estado);
            return analisisdeRiesgoRepository.save(analisisRiesgoDB);
        }
        return null;
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