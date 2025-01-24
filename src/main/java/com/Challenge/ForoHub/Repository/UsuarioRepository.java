package com.Challenge.ForoHub.Repository;

import com.Challenge.ForoHub.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
    Usuario findByNombre(String nombre);
}
