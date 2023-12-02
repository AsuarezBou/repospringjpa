package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.procesos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.maestros.ProductoEntity;

@Data
@Entity(name = "PedidoDetalle")
@Table(name = "tbl_pedido_detalle")
public class PedidoDetalleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_detalle_id")
    private Long id;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precio")
    private Double precio;

    @Column(name = "sub_total")
    private Double subTotal;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "producto_id",nullable = false)
    private ProductoEntity producto;

    @ManyToOne
    @JoinColumn(name = "pedido_id",nullable = false)
    private PedidoCabeceraEntity pedido;

    public PedidoDetalleEntity(){

    }

}