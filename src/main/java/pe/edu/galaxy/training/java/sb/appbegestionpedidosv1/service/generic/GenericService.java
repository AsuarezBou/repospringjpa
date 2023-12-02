package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.service.generic;

import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {
    List<T> findAll() throws ServiceException;

    T save(T t) throws ServiceException;

    T update(T t) throws ServiceException;

    void delete(Long id) throws ServiceException;

    List<T> findByLikeObject(T t) throws ServiceException;

    Optional<T> findById(Long id) throws ServiceException;
}
