package com.proyecto.controller;

import com.proyecto.domain.Categoria;
import com.proyecto.domain.Producto;
import com.proyecto.service.CategoriaService;
import com.proyecto.service.ProductoService;
import com.proyecto.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {

        var lista = productoService.getProductos(false);

        model.addAttribute("productos", lista);
        model.addAttribute("totalProductos", lista.size());
        model.addAttribute("productos", lista);
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);

        return "/producto/listado";
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String guardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) { // Se debe subir una imagen 
            //Primero se guarda la producto... para obtener el idCtegoria nuevo
            productoService.save(producto);
            String ruta = firebaseStorageService.cargaImagen(imagenFile,
                    "Producto", producto.getIdProducto());
            producto.setRutaImagen(ruta);
        }
        productoService.save(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/modificar/{idProducto}")
    public String modifica(Producto producto,
            Model model) {
        producto = productoService
                .getProducto(producto);
        model.addAttribute("producto", producto);
        return "producto/modifica";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String elimina(Producto producto) {
        productoService.delete(producto);
        return "redirect:/producto/listado";
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

        return "producto/listado";
    }

    @PostMapping("/query1")
    public String consultaJPA(
            @RequestParam("precioInf") double precioInf,
            @RequestParam("precioSup") double precioSup,
            Model model) {
        var productos = productoService.consultaJPA(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "producto/listado2";
    }

    @PostMapping("/query2")
    public String metodoJPQL(@RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup, Model model) {
        var productos = productoService.metodoJPQL(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/producto/listado2";
    }

    @PostMapping("/query3")
    public String consultaSQL(@RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup, Model model) {
        var productos = productoService.consultaSQL(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/producto/listado2";
    }
}
