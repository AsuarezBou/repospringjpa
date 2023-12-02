package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.dto.procesos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.maestros.ProductoEntity;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.procesos.PedidoCabeceraEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDetalleDTO {

    private Long id;
    private Integer cantidad;
    private Double precio;
    private Double subTotal;
    private String estado;
    private ProductoEntity producto;
    private PedidoCabeceraEntity pedido;

}
