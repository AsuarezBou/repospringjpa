package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.dto.maestros;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nombre;

    private Double precio;

    private Integer stock;

    private String estado;
}