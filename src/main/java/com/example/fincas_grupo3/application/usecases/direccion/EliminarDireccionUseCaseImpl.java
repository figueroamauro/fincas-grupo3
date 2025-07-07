    package com.example.fincas_grupo3.application.usecases.direccion;

    import com.example.fincas_grupo3.domain.ports.in.direccion.EliminarDireccionUseCase;
    import com.example.fincas_grupo3.domain.ports.out.direccion.DireccionOutPort;
    import org.springframework.stereotype.Service;

    @Service
    public class EliminarDireccionUseCaseImpl implements EliminarDireccionUseCase {
        private final DireccionOutPort direccionOutPort;

        public EliminarDireccionUseCaseImpl(DireccionOutPort direccionOutPort) {
            this.direccionOutPort = direccionOutPort;
        }

        @Override
        public Boolean eliminarDireccionPorId(Long id) {
            return direccionOutPort.eliminarPorId(id);
        }


    }
