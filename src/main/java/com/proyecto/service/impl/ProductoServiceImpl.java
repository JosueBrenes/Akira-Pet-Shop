package com.proyecto.service.impl;

import com.proyecto.dao.ProductoDAO;
import com.proyecto.domain.Producto;
import com.proyecto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDAO productoDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        List<Producto> lista = productoDAO.findAll();

        if (activos) { // Si desea solo los productos activos
            lista.removeIf(c -> !c.isActivo());
        }

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDAO.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDAO.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDAO.delete(producto);
    }
    
    // Lista de productos con precio entre ordendados por descripción ConsultaAmpliada
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaJPA(double precioInf, double precioSup) {
        return productoDAO.findByPrecioBetweenOrderByPrecio(precioInf, precioSup);
    }

    //Lista de productos utilizando consultas con JPQL    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> metodoJPQL(double precioInf, double precioSup) {
        return productoDAO.consultaJPQL(precioInf, precioSup);
    }

    //Lista de productos utilizando consultas con SQL Nativo
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaSQL(double precioInf, double precioSup) {
        return productoDAO.consultaSQL(precioInf, precioSup);
    }
}
