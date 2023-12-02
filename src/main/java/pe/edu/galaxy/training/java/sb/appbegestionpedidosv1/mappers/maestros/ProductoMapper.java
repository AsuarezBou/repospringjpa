package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.mappers.maestros;

import org.mapstruct.Mapper;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.dto.maestros.ProductoDTO;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.maestros.ProductoEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    List<ProductoDTO> toListDTO(List<ProductoEntity> lstEntity);
    ProductoEntity dtoToEntity (ProductoDTO dto);

    ProductoDTO entityToDTO (ProductoEntity entity);
}
