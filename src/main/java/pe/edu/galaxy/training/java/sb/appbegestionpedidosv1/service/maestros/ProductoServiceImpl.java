package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.service.maestros;

import org.springframework.stereotype.Service;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.dto.maestros.ProductoDTO;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.maestros.ProductoEntity;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.mappers.maestros.ProductoMapper;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.repository.maetros.ProductoRepository;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    public ProductoServiceImpl(final ProductoRepository productoRepository, ProductoMapper productoMapper) {
        super();
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }


    @Override
    public List<ProductoDTO> findAll() throws ServiceException {
        try {
            return productoMapper.toListDTO(productoRepository.findAllCustom());
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public ProductoDTO save(ProductoDTO productoDTO) throws ServiceException {
        try {

            ProductoEntity lstEntity = productoMapper.dtoToEntity(productoDTO);
            return productoMapper.entityToDTO(productoRepository.save(lstEntity));

        } catch (Exception e) {
            throw new ServiceException(e);

        }
    }
    @Override
    public ProductoDTO update(ProductoDTO productoDTO) throws ServiceException {

        return null;
/*        try {
            Optional<ProductoDTO> optProducto = productoRepository.findById(productoDTO.getId());

            if (optProducto.isPresent()) {
                ProductoDTO prmProductoDTO = optProducto.get();
                prmProductoDTO.setNombre(productoDTO.getNombre());
                prmProductoDTO.setPrecio(productoDTO.getPrecio());
                prmProductoDTO.setStock(productoDTO.getStock());
                prmProductoDTO.setEstado(productoDTO.getEstado());

                return productoRepository.save(prmProductoDTO);
            }

            return productoRepository.save(productoDTO);
        } catch (Exception e) {
            throw new ServiceException(e);
        }*/
    }

    @Override
    public void delete(Long id) throws ServiceException {

        return;
/*        try {
            productoRepository.deleteCustom(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }*/
    }

    @Override
    public List<ProductoDTO> findByLikeObject(ProductoDTO productoDTO) throws ServiceException {
        return null;
/*        try {
            return productoRepository.findByLikeNombre("%" + productoDTO.getNombre() + "%");
        } catch (Exception e) {
            throw new ServiceException(e);
        }*/
    }

    @Override
    public Optional<ProductoDTO> findById(Long id) throws ServiceException {
        return null;
/*        try {
            return productoRepository.findById(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }*/
    }

    @Override
    public boolean updateStock(Long id, Integer newStock) throws ServiceException {

        return false;
    }
}
