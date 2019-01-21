package com.br.loja.dao;

import com.br.loja.entity.Usuario;

public interface UsuarioDao {

	public Usuario logar(Usuario usuario);

	Usuario buscarPorLogin(String login);

	public Usuario buscarPorLoginESenha(String login, String senha);

	public Usuario inicializarPerfisDoUsuario(Usuario usuario);

	public Usuario buscaUsuarioId(int idUsuario);

	public Usuario emailExiste(String email);

	public Usuario cadastro(Usuario usuario);

	public Usuario alterarUsuario(Usuario usuario);

	public Usuario exclusaoUsuario(Usuario usuario);
}
