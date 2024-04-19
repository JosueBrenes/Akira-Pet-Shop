package com.proyecto.controller;

import com.proyecto.domain.Usuario;
import com.proyecto.service.EditarService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editar")
public class EditarController {

    private final EditarService editarService;

    @Autowired
    public EditarController(EditarService editarService) {
        this.editarService = editarService;
    }

    @GetMapping("/listado")
    public String editarPerfil(Model model, Principal principal) {

        String username = principal.getName();
        Usuario usuario = editarService.buscarUsuarioPorUsername(username);

        model.addAttribute("usuario", usuario);

        return "/editar/listado";
    }

    @PostMapping("/listado")
    public String guardarPerfil(@ModelAttribute("usuario") Usuario usuario) {
        editarService.guardarUsuario(usuario);
        return "redirect:/editar/listado";
    }
}
