/**
 * 
 */
package com.br.loja.service;

import javax.security.auth.login.LoginException;

import com.br.loja.entity.Usuario;

/**
 * @author Eduardo
 *
 */
public interface UsuarioService {
	
	public Usuario autentica(Usuario usuario) throws LoginException;
	
	public Usuario buscarPorLoginESenha(String login, String senha) throws Exception;
	
	public Usuario buscarPorLogin(String login) throws Exception;
	
	public Usuario inicializarPerfisDoUsuario(Usuario usuario);

}
