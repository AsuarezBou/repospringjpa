package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.controller.procesos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.dto.procesos.PedidoCabeceraDTO;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.mappers.procesos.PedidoCabeceraMapper;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.service.procesos.PedidoService;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;
    private final PedidoCabeceraMapper mapper;
    public PedidoController(final PedidoService pedidoService,final PedidoCabeceraMapper mapper) {
        super();
        this.pedidoService = pedidoService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id ){
        try{
            Optional<PedidoCabeceraDTO> optPedidoCabecera = pedidoService.findById(id);
            if(optPedidoCabecera.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(optPedidoCabecera.get());
        } catch (Exception e){
            return  ResponseEntity.internalServerError().body(null);
        }
    }
}
