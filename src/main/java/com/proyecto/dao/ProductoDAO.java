package com.proyecto.dao;

import com.proyecto.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoDAO extends JpaRepository<Producto, Long> {

    //Se define una consulta ampliada JPA para obtener la lista de productos en un rango de precios
    public List<Producto> findByPrecioBetweenOrderByPrecio(double precioInf, double precioSup);

    //Ejemplo de método utilizando Consultas con JPQL
    @Query(value = "SELECT p FROM Producto p where p.precio BETWEEN :precioInf AND :precioSup ORDER BY p.precio ASC")
    public List<Producto> consultaJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    //Ejemplo de método utilizando Consultas con SQL nativo
    @Query(nativeQuery = true,
            value = "SELECT * FROM producto where p.precio BETWEEN :precioInf AND :precioSup ORDER BY p.precio ASC")
    public List<Producto> consultaSQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
}
