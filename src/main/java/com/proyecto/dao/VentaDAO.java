package com.proyecto.dao;

import com.proyecto.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaDAO extends JpaRepository< Venta, Long> {

}
