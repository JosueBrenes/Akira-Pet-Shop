package com.proyecto.service.impl;

import com.proyecto.domain.Usuario;
import com.proyecto.service.EditarService;
import com.proyecto.dao.EditarDAO;
import com.proyecto.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditarServiceImpl implements EditarService {

    private final EditarDAO editarDAO;
    

    @Autowired
    public EditarServiceImpl(EditarDAO editarDAO) {
        this.editarDAO = editarDAO;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return editarDAO.save(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorUsername(String username) {
        return editarDAO.findByUsername(username);
    }
    
    @Override
    @Transactional
    public void save(Usuario usuario) {
        editarDAO.save(usuario);
    }
}
