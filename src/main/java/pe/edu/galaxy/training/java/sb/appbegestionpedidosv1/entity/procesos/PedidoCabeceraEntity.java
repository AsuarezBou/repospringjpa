package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.procesos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.maestros.ClienteEntity;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.maestros.VendedorEntity;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "PedidoCabecera")
@Table(name = "tbl_pedido")
public class PedidoCabeceraEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private Long id;

    @Column(name = "resumen")
    private String resumen;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @Column(name = "total")
    private Double total;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "cliente_id",nullable = false)
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "vendedor_id",nullable = false)
    private VendedorEntity vendedor;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @Where(clause = "estado=1")
    @JsonIgnore
    @JsonIgnoreProperties("PedidoDetalle")
    private List<PedidoDetalleEntity> pedidoDetalleEntity;

    public PedidoCabeceraEntity(){

    }

}