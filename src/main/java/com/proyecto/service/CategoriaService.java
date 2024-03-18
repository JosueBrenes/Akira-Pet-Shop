package com.proyecto.service;

import com.proyecto.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    
    public List<Categoria> getCategorias(boolean activos);
    
    //Se define el metodo para recuperar un registro de la tabla categoria,
    //Recuperando eun registro que toene el idCategoria, si no lo encuentra
    //Retorna null
    
    public Categoria getCategoria(Categoria categoria); 
    
    //Se define el metodo para crear o actualizar un registro de la tabla categoria,
    //si el idCategoria no tiene valor se agrega el registro, si tiene valor, entonces
    //modifica ese registro
    
    public void save(Categoria categoria); 
    
    //Se define el metodo para eliminar un registro de la tabla categoria,
    //considerando idCategoria
    
    public void delete(Categoria categoria); 
}
