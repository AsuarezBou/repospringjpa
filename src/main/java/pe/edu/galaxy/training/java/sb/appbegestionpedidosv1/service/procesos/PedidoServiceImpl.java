package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.service.procesos;

import org.springframework.stereotype.Service;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.dto.procesos.PedidoCabeceraDTO;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.procesos.PedidoCabeceraEntity;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.mappers.procesos.PedidoCabeceraMapper;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.repository.procesos.PedidoCabeceraRepository;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService{

    private final PedidoCabeceraRepository pedidoCabeceraRepository;
    private final PedidoCabeceraMapper pedidoCabeceraMapper;

    public PedidoServiceImpl(PedidoCabeceraRepository pedidoCabeceraRepository, PedidoCabeceraMapper pedidoCabeceraMapper) {
        this.pedidoCabeceraRepository = pedidoCabeceraRepository;
        this.pedidoCabeceraMapper = pedidoCabeceraMapper;
    }


    @Override
    public List<PedidoCabeceraDTO> findAll() throws ServiceException {
        return null;
    }

    @Override
    public PedidoCabeceraDTO save(PedidoCabeceraDTO pedidoCabeceraDTO) throws ServiceException {
        return null;
    }

    @Override
    public PedidoCabeceraDTO update(PedidoCabeceraDTO pedidoCabeceraDTO) throws ServiceException {
        return null;
    }

    @Override
    public void delete(Long id) throws ServiceException {

    }

    @Override
    public List<PedidoCabeceraDTO> findByLikeObject(PedidoCabeceraDTO pedidoCabeceraDTO) throws ServiceException {
        return null;
    }

    @Override
    public Optional<PedidoCabeceraDTO> findById(Long id) throws ServiceException {
        Optional<PedidoCabeceraEntity> opt = pedidoCabeceraRepository.findById(id);

        if(opt.isEmpty()){
            throw new ServiceException(String.format("El pedido con el id %s no existe\"",id));
        }

        PedidoCabeceraDTO pDto = pedidoCabeceraMapper.toDto(opt.get());
        return Optional.ofNullable(pDto);
    }
}
