package com.ifba.ecoColeta.ecoColeta.repository;

import com.ifba.ecoColeta.ecoColeta.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    
}
