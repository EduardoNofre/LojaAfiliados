package com.br.loja.dao;

import com.br.loja.entity.Usuario;

public interface UsuarioDao {

	public Usuario logar(Usuario usuario);
	
	Usuario buscarPorLogin(String login) throws Exception;
	
	public Usuario buscarPorLoginESenha(String login, String senha);
	
	public Usuario inicializarPerfisDoUsuario(Usuario usuario);
	
	public Usuario buscaUsuarioId(int idUsuario);
}
