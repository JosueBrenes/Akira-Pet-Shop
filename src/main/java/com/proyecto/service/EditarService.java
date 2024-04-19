package com.proyecto.service;

import com.proyecto.domain.Usuario;

public interface EditarService {

    Usuario guardarUsuario(Usuario usuario);

    Usuario buscarUsuarioPorUsername(String username);
    
    public void save(Usuario usuario);
}
