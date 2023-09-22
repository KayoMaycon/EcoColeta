package com.ifba.ecoColeta.ecoColeta.repository;

import com.ifba.ecoColeta.ecoColeta.model.Descarte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescarteRepository extends JpaRepository<Descarte,Long> {
    
}
