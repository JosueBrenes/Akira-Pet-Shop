package com.proyecto.service;

import com.proyecto.domain.Producto;
import java.util.List;

public interface ProductoService {

    /* Se define la firma del metodo que recupera la lista 
    de objetos tipo Producto que son los registros de la tabla producto */
    public List<Producto> getProductos(boolean activos);

    /* Se define  la firma del metodo para recuperar un registro de 
    la tabla producto, recuperando el registro que tiene el 
    idProducto, sino lo encuentra retorna null*/
    public Producto getProducto(Producto producto);

    /* Se define la firma del metodo para crear o actualizar un registro de 
    la tabla producto, Si el idProducto no tiene valor, se crea
    el registro, si tiene valor, entonces modifica ese registro */
    public void save(Producto producto);

    /* Se define la firma del metodo para eliminar un registro de 
    la tabla producto, considerando idProducto */
    public void delete(Producto producto);
    
    // Lista de productos con precio entre ordendados por descripción ConsultaAmpliada
    public List<Producto> consultaJPA(double precioInf, double precioSup);

    //Lista de productos utilizando consultas con JPQL    
    public List<Producto> metodoJPQL(double precioInf, double precioSup);

    //Lista de productos utilizando consultas con SQL Nativo
    public List<Producto> consultaSQL(double precioInf, double precioSup);

}