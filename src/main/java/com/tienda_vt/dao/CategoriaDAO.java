package com.tienda_vt.dao;

import com.tienda_vt.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDAO extends JpaRepository<Categoria, Long> {

}
