package com.br.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.loja.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("SELECT u FROM com.br.loja.entity.Usuario u WHERE u.email = :emailParam AND u.senha = :senhaParam")
    public Usuario loginUsuario(@Param("emailParam") String email, @Param("senhaParam") String senha);
	
	Usuario findByEmail(String email);
	
}
