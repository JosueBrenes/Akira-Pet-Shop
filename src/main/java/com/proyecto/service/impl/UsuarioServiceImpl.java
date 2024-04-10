package com.proyecto.service.impl;

import com.proyecto.dao.RolDAO;
import com.proyecto.dao.UsuarioDAO;
import com.proyecto.domain.Rol;
import com.proyecto.domain.Usuario;
import com.proyecto.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;
    @Autowired
    private RolDAO rolDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return usuarioDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDAO.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDAO.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameYPassword(String username, String password) {
        return usuarioDAO.findByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDAO.findByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDAO.existsByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional
    public void save(Usuario usuario, boolean crearRolUser) {
        usuario = usuarioDAO.save(usuario);
        if (crearRolUser) {  //Si se está creando el usuario, se crea el rol por defecto "USER"
            Rol rol = new Rol();
            rol.setNombre("ROLE_USER");
            rol.setIdUsuario(usuario.getIdUsuario());
            rolDAO.save(rol);
        }
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDAO.delete(usuario);
    }
}
