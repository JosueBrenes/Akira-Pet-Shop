package com.tienda_vt.service.impl;

import com.tienda_vt.dao.ProductoDAO;
import com.tienda_vt.domain.Producto;
import com.tienda_vt.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDAO productoDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDAO.findAll();

        if (activos) { // Si desea solo las productos activas
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
}
