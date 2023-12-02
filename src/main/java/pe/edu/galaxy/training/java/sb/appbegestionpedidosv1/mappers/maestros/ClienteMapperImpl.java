package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.mappers.maestros;

import org.springframework.stereotype.Component;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.dto.maestros.ClienteDTO;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.maestros.ClienteEntity;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.mappers.maestros.ClienteMapper;

@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDTO entityToDto(ClienteEntity e) {

        return ClienteDTO
                .builder()
                .id(e.getId())
                .razonSocial(e.getRazonSocial().toUpperCase())
                .correo(e.getCorreo())
                .ruc(e.getRuc())
                .estado(e.getEstado())
                .telefono(e.getTelefono())
                .direccion(e.getDireccion())
                .build();
    }
}
