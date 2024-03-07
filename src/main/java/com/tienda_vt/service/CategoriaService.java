package com.tienda_vt.service;

import com.tienda_vt.domain.Categoria;
import java.util.List;

public interface CategoriaService {

    /* Se define la firma del metodo que recupera la lista 
    de objetos tipo Categoria que son los registros de la tabla categoria */
    public List<Categoria> getCategorias(boolean activos);

    /* Se define  la firma del metodo para recuperar un registro de 
    la tabla categoria, recuperando el registro que tiene el 
    idCategoria, sino lo encuentra retorna null*/
    public Categoria getCategoria(Categoria categoria);

    /* Se define la firma del metodo para crear o actualizar un registro de 
    la tabla categoria, Si el idCategoria no tiene valor, se crea
    el registro, si tiene valor, entonces modifica ese registro */
    public void save(Categoria categoria);

    /* Se define la firma del metodo para eliminar un registro de 
    la tabla categoria, considerando idCategoria */
    public void delete(Categoria categoria);

}
