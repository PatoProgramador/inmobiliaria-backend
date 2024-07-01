package co.edu.inmobiliaria.backendverkev.servicios.cuentaCobro;

import co.edu.inmobiliaria.backendverkev.dominio.CuentaCobro;
import co.edu.inmobiliaria.backendverkev.repositorios.CuentaCobroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaCobroServiceImp implements CuentaCobroService{
    @Autowired
    private CuentaCobroRepository cuentaCobroRepository;

    @Override
    public CuentaCobro crearCuentaCobro(CuentaCobro cuentaCobro) {
        CuentaCobro cuentaCobroDb = cuentaCobroRepository.save(cuentaCobro);
        return cuentaCobroDb;
    }
}
