package com.proyecto.service.impl;

import com.proyecto.dao.UsuarioDAO;
import com.proyecto.domain.Rol;
import com.proyecto.domain.Usuario;
import com.proyecto.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl
        implements
        UsuarioDetailsService,
        UserDetailsService {

    @Autowired
    private UsuarioDAO usuarioDao;

    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        //Se busca el usuario que tiene el username
        Usuario usuario = usuarioDao.findByUsername(username);

        //Se debe validar si se encontró...
        if (usuario == null) {
            //El usuario NO se encontró
            throw new UsernameNotFoundException(username);

        }

        //Si estamos acá... si se encontró el usuario...
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());

        //Se deben de crear los roles de seguridad
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol r : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(r.getNombre()));
        }
        //Acá ya tenemos toda la info del usuario...
        return new User(usuario.getUsername(),
                usuario.getPassword(),
                roles);
    }

}
