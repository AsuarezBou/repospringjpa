package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.controller.maestros;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.dto.maestros.ClienteDTO;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.maestros.ClienteEntity;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.mappers.maestros.ClienteMapper;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.service.maestros.ClienteService;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Slf4j
@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {
    private final ClienteService clienteService;
    private final ClienteMapper mapper;
    public ClienteController(final ClienteService clienteService,final ClienteMapper mapper) {
        super();
        this.clienteService = clienteService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){

        try {
            List<ClienteEntity> clientes = clienteService.findAll();
            if(clientes.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            List<ClienteDTO> dtoClientes =  clientes.stream()
                    .parallel()
                    .map(mapper::entityToDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(dtoClientes);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }

    }
    @GetMapping("/by-razonsocial")
    public ResponseEntity<?> findByLikeRazonSocial(@RequestParam  String razonSocial){
        try {
            List<ClienteEntity> cliente = clienteService.
                    findByLikeObject(ClienteEntity.builder().razonSocial(razonSocial).build());
            if(cliente.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClienteEntity clienteEntity){


        try {
            ClienteEntity oClienteEntity = clienteService.save(clienteEntity);
            if(isNull(oClienteEntity)) {

                Map<String,Object> body = new HashMap<>();
                body.put("Response", "Error al registrar");
                return ResponseEntity.badRequest().body("body");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(oClienteEntity);

        } catch (Exception e) {

            // e.printStackTrace();
            log.error("Error " + e.getMessage());
            Map<String, Object> body = new HashMap<>();
            body.put("response", "Error al registrar");
            return ResponseEntity.internalServerError().body(body);

        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ClienteEntity clienteEntity){

        clienteEntity.setId(id);

        try {
            ClienteEntity oClienteEntity = clienteService.update(clienteEntity);
            if (isNull(oClienteEntity)) {

                Map<String, Object> body = new HashMap<>();
                body.put("response", "Error al actualizar");
                return ResponseEntity.badRequest().body("body");
            }

            return ResponseEntity.status(HttpStatus.OK).body(oClienteEntity);
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            Map<String, Object> body = new HashMap<>();
            body.put("response", "Error al actualizar");
            return ResponseEntity.internalServerError().body(body);
        }
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        try {
            clienteService.delete(id);
        } catch (Exception e) {

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            Optional<ClienteEntity> optCliente = clienteService.findById(id);
            if (optCliente.isPresent()) {
                return ResponseEntity.ok(optCliente.get());
            }
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

}

