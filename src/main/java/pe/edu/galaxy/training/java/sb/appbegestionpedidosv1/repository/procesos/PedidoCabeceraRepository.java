package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.repository.procesos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.procesos.PedidoCabeceraEntity;

import java.util.List;

public interface PedidoCabeceraRepository extends JpaRepository<PedidoCabeceraEntity,Long> {
    //JPQL
    @Query("Select p from PedidoCabecera p where p.estado='1'")
    List<PedidoCabeceraEntity> findAllCustom();

}