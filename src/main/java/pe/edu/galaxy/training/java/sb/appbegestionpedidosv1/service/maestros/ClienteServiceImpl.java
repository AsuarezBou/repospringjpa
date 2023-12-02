package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.service.maestros;

import org.springframework.stereotype.Service;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.maestros.ClienteEntity;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.repository.maetros.ClienteRepository;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.service.exception.ServiceException;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.service.maestros.ClienteService;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(final ClienteRepository clienteRepository) {
        super();
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteEntity> findAll() throws ServiceException {
        try {
            return clienteRepository.findAllCustom();
        } catch(Exception e) {
            throw new ServiceException(e);
        }
    }
    @Override
    public ClienteEntity save(ClienteEntity clienteEntity) throws ServiceException {
        try {
            return clienteRepository.save(clienteEntity);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
    @Override
    public ClienteEntity update(ClienteEntity clienteEntity) throws ServiceException {
        try {
            Optional<ClienteEntity> optCliente = clienteRepository.findById(clienteEntity.getId());

            if (optCliente.isPresent()) {
                //
                ClienteEntity prmClienteEntity = optCliente.get();

                prmClienteEntity.setRazonSocial(clienteEntity.getRazonSocial());
                prmClienteEntity.setRuc(clienteEntity.getRuc());
                prmClienteEntity.setTelefono(clienteEntity.getTelefono());
                prmClienteEntity.setDireccion(clienteEntity.getDireccion());
                prmClienteEntity.setCorreo(clienteEntity.getCorreo());
                prmClienteEntity.setEstado(clienteEntity.getEstado());
                return clienteRepository.save(prmClienteEntity);
            }

            return clienteRepository.save(clienteEntity);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
    @Override
    public void delete(Long id) throws ServiceException {
        try {
            clienteRepository.deleteCustom(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
    @Override
    public List<ClienteEntity> findByLikeObject(ClienteEntity clienteEntity) throws ServiceException {
        try {
            return clienteRepository.findByLikeRazonSocial("%" + clienteEntity.getRazonSocial() + "%");
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
    @Override
    public Optional<ClienteEntity> findById(Long id) throws ServiceException {
        try {
            return clienteRepository.findById(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
    @Override
    public Optional<ClienteEntity> findByRuc(String ruc) throws ServiceException {
        try {
            return Optional.empty();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
