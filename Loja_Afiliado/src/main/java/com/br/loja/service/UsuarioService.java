/**
 * 
 */
package com.br.loja.service;

import java.security.NoSuchAlgorithmException;

import javax.security.auth.login.LoginException;

import com.br.loja.entity.Usuario;

/**
 * @author Eduardo
 *
 */
public interface UsuarioService {
	
	public Usuario autenticaService(Usuario usuario) throws LoginException, NoSuchAlgorithmException;
	
	public Usuario buscarPorLoginESenhaService(String login, String senha) throws Exception;
	
	public Usuario buscarPorLoginService(String login) throws Exception;
	
	public Usuario inicializarPerfisDoUsuarioService(Usuario usuario);
	
	public Usuario emailExisteService(String email);
	
	public Usuario cadastroService(Usuario usuario) throws NoSuchAlgorithmException ;
	
	public Usuario alterarUsuarioService(Usuario usuario);
	
	public Usuario exclusaoUsuarioService(Usuario usuario);

}
