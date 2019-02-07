package com.br.loja.dao;

import com.br.loja.entity.Usuario;

public interface UsuarioDao {

	public Usuario logarDao(Usuario usuario);

	Usuario buscarPorLoginDao(String login);

	public Usuario buscarPorLoginESenhaDao(String login, String senha);

	public Usuario inicializarPerfisDoUsuarioDao(Usuario usuario);

	public Usuario buscaUsuarioIdDao(int idUsuario);

	public Usuario emailExisteDao(String email);

	public Usuario cadastroDao(Usuario usuario);

	public Usuario alterarUsuarioDao(Usuario usuario);

	public Usuario exclusaoUsuarioDao(Usuario usuario);
}
