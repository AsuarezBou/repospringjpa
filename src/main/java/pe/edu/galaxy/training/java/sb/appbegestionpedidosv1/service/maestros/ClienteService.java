package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.service.maestros;

import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.maestros.ClienteEntity;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.service.exception.ServiceException;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.service.generic.GenericService;

import java.util.Optional;


public interface ClienteService extends GenericService<ClienteEntity> {
    Optional<ClienteEntity> findByRuc(String ruc)  throws ServiceException;

}
