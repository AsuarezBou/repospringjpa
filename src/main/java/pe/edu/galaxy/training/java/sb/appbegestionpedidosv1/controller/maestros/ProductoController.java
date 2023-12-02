package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.controller.maestros;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.dto.maestros.ProductoDTO;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.mappers.maestros.ProductoMapper;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.service.maestros.ProductoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

@Slf4j
@RestController
@RequestMapping("api/v1/productos")
public class ProductoController {
    private final ProductoService productoService;
    private final ProductoMapper mapper;

    public ProductoController(final ProductoService productoService, ProductoMapper mapper) {
        super();
        this.productoService = productoService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            List<ProductoDTO> productos = productoService.findAll();
            if (productos.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

/*            List<ProductoDTO> dtoProducto =  productos.stream()
                                                    .parallel()
                                                    .map(mapper::entityToDto)
                                                    .collect(Collectors.toList());*/

            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }

    }

/*    @GetMapping("/by-nombre")
    public ResponseEntity<?> findByLikeNombre(@RequestParam String nombre) {
        try {
            List<ProductoEntity> productos = productoService
                    .findByLikeObject(ProductoEntity.builder().nombre(nombre).build());
            if (productos.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Optional<ProductoEntity> optProducto = productoService.findById(id);
            if (optProducto.isPresent()) {
                return ResponseEntity.ok(optProducto.get());
            }
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }*/

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductoDTO productoDTO) {
        try {
            ProductoDTO oProductoDTO = productoService.save(productoDTO);
            // if (oProductoEntity!=null) {
            if (isNull(oProductoDTO)) {

                Map<String, Object> body = new HashMap<>();
                body.put("response", "Error al registrar");
                return ResponseEntity.badRequest().body("body");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(oProductoDTO);
        } catch (Exception e) {
            // e.printStackTrace();
            log.error("Error " + e.getMessage());
            Map<String, Object> body = new HashMap<>();
            body.put("response", "Error al registrar");
            return ResponseEntity.internalServerError().body(body);
        }

    }
/*
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductoEntity productoEntity) {
        productoEntity.setId(id);
        try {
            ProductoEntity oProductoEntity = productoService.update(productoEntity);
            if (isNull(oProductoEntity)) {

                Map<String, Object> body = new HashMap<>();
                body.put("response", "Error al actualizar");
                return ResponseEntity.badRequest().body("body");
            }

            return ResponseEntity.status(HttpStatus.OK).body(oProductoEntity);
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            Map<String, Object> body = new HashMap<>();
            body.put("response", "Error al actualizar");
            return ResponseEntity.internalServerError().body(body);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
            productoService.delete(id);
        } catch (Exception e) {

        }
    }*/
}
