package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.repository.maetros;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.maestros.ClienteEntity;

import java.util.List;

@Transactional
@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity,Long> {
    //JPQL
    @Query("Select p from Cliente p where p.estado='1'")
    List<ClienteEntity> findAllCustom();

    @Query("Select p from Cliente p where upper(p.razonSocial) like upper(:razonSocial) and p.estado='1'")
    List<ClienteEntity> findByLikeRazonSocial(@Param("razonSocial") String razonSocial);



    //SQL
    @Modifying
    @Query(nativeQuery = true, value = "update tbl_cliente set estado='0' where cliente_id=:id")
    void deleteCustom(@Param("id") Long id);


    //Agregates(DTO,Optimizacion de consultas)

}
