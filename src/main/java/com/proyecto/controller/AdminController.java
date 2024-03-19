package com.proyecto.controller;

import com.proyecto.domain.Categoria;
import com.proyecto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyecto.service.CategoriaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = productoService.getProductos(false);
        model.addAttribute("productos", lista);
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/admin/listado";
    }

    @GetMapping("/listado/{idCategoria}")
    public String modifica(Categoria categoria,
            Model model) {
        categoria = categoriaService
                .getCategoria(categoria);
        var lista = categoria.getProductos();
        model.addAttribute("productos", lista);

        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);

        return "admin/listado";
    }
}
