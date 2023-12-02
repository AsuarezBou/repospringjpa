package pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.repository.maetros;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.java.sb.appbegestionpedidosv1.entity.maestros.ProductoEntity;

import java.util.List;

@Transactional
@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity,Long> {
    //JPQL
    @Query("Select p from Producto p where p.estado='1'")
    List<ProductoEntity> findAllCustom();


    //SQL
    @Modifying
    @Query(nativeQuery = true, value = "update tbl_producto set estado='0' where id=:id")
    void deleteCustom(@Param("id") Long id);


    @Query("Select p from Producto p where upper(p.nombre) like upper(:nombre) and p.estado='1'")
    List<ProductoEntity> findByLikeNombre(@Param("nombre") String nombre);


    //Agregates(DTO,Optimizacion de consultas)
}
