package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.service.maestros;

import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.dto.maestros.ProductoDTO;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.service.exception.ServiceException;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.service.generic.GenericService;

public interface ProductoService extends GenericService<ProductoDTO> {

    boolean updateStock(Long id, Integer newStock) throws ServiceException;

}
