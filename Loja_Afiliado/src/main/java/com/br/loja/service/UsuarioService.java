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
	
	public Usuario autenticaService(Usuario usuario) throws LoginException;
	
	public Usuario buscarPorLoginESenhaService(String login, String senha) throws Exception;
	
	public Usuario buscarPorLoginService(String login) throws Exception;
	
	public Usuario inicializarPerfisDoUsuarioService(Usuario usuario);
	
	public Usuario emailExisteService(String email)  throws Exception;
	
	public Usuario cadastroService(Usuario usuario);

}
