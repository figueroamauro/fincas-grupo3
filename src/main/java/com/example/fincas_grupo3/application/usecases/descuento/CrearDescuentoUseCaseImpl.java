package com.example.fincas_grupo3.application.usecases.descuento;


import com.example.fincas_grupo3.domain.models.descuento.Descuento;
import com.example.fincas_grupo3.domain.ports.in.descuento.CrearDescuentoUseCase;
import com.example.fincas_grupo3.domain.ports.out.descuento.DescuentoOutPort;
import org.springframework.stereotype.Service;

@Service
public class CrearDescuentoUseCaseImpl implements CrearDescuentoUseCase {
    
        private final DescuentoOutPort descuentoOutPort;
        
    public CrearDescuentoUseCaseImpl(DescuentoOutPort descuentoOutPort) {
        this.descuentoOutPort = descuentoOutPort;
    }

    @Override
        public Descuento crearDescuento(Descuento descuento) {
            return descuentoOutPort.guardar(descuento);
        }
    

}
