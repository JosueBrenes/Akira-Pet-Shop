package com.proyecto.dao;

import com.proyecto.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDAO extends JpaRepository< Factura, Long> {

}
