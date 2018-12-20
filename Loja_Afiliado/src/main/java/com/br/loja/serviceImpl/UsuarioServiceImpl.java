package com.br.loja.serviceImpl;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.loja.dao.UsuarioDao;
import com.br.loja.entity.Usuario;
import com.br.loja.service.UsuarioService;
import com.br.loja.util.StringUtil;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private static final String AVIS0_LOGIN_SENHA_NAO_PREENCHIDO = "Usuário / Senha inválida";
	private static final String AVIS0_LOGIN_NAO_ENCONTRADO = "Usuário não encontrado";
	private static final String AVIS0_USUARIO_INATIVO = "Usuário esta inativo";

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public Usuario autentica(Usuario usuario) throws LoginException {

		String senhaDigitada = usuario.getPassword();

		if (!this.validaUsuarioESenha(usuario)) {

			throw new LoginException(AVIS0_LOGIN_SENHA_NAO_PREENCHIDO);
		}

		try {
			
			usuario = this.buscarPorLogin(usuario.getEmail());
			
		} catch (Exception e) {
			throw new LoginException(e.getMessage());
		}

		// verifica se existe
		if (usuario == null) {
			throw new LoginException(AVIS0_LOGIN_NAO_ENCONTRADO);
		}

		// verifica se esta ativo
		if (usuario.getTipostatus().getIdstatus() == 4) {
			throw new LoginException(AVIS0_USUARIO_INATIVO);
		}

		return usuario;
	}

	@Override
	public Usuario inicializarPerfisDoUsuario(Usuario usuario) {
		usuario = usuarioDao.buscaUsuarioId(usuario.getIdUsuario());
		return usuarioDao.inicializarPerfisDoUsuario(usuario);
	}

	private boolean validaUsuarioESenha(Usuario usuario) {
		return !StringUtil.isBlankOrNull(usuario.getEmail()) && !StringUtil.isBlankOrNull(usuario.getEmail());
	}

	@Override
	public Usuario buscarPorLoginESenha(String login, String senha) throws Exception {
		return usuarioDao.buscarPorLoginESenha(login, senha);
	}

	@Override
	public Usuario buscarPorLogin(String login) throws Exception {
		return usuarioDao.buscarPorLogin(login);
	}
}
