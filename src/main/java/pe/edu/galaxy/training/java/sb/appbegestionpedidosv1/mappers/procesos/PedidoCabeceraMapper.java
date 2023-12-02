package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.mappers.procesos;

import org.mapstruct.Mapper;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.dto.procesos.PedidoCabeceraDTO;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.procesos.PedidoCabeceraEntity;

@Mapper(componentModel = "spring")
public interface PedidoCabeceraMapper {
    PedidoCabeceraDTO toDto (PedidoCabeceraEntity entity);
}
