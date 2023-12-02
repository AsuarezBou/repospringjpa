package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.dto.procesos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.dto.maestros.ClienteDTO;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.dto.maestros.VendedorDTO;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.procesos.PedidoDetalleEntity;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoCabeceraDTO {

    private Long id;
    private String resumen;
    private LocalDate fechaRegistro;
    private Double total;
    private String estado;
    private ClienteDTO cliente;
    private VendedorDTO vendedor;
    private List<PedidoDetalleDTO> pedidoDetalleEntity;
}
