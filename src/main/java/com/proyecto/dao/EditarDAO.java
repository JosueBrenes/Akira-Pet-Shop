package com.proyecto.dao;

import com.proyecto.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditarDAO extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

    Usuario findByNombre(String nombre);

    Usuario findByApellidos(String apellidos);

    Usuario findByCorreo(String correo);

    Usuario findByTelefono(String telefono);
}
