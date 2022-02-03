package com.dh.BibliotecaDeFilmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dh.BibliotecaDeFilmes.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByUserName(String username);
}
