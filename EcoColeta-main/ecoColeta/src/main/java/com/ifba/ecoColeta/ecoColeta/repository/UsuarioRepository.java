package com.ifba.ecoColeta.ecoColeta.repository;

import com.ifba.ecoColeta.ecoColeta.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/*Interface só para implementar os métodos do JpaRepository(Que possui métodos de acesso ao banco)
Substituindo a necessidade da criação de querys*/
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    
}
