package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.mappers.maestros;

import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.dto.maestros.ClienteDTO;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.maestros.ClienteEntity;

public interface ClienteMapper {

    ClienteDTO entityToDto(ClienteEntity e);
}
