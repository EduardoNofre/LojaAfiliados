package com.br.loja.serviceImpl;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.loja.dao.UsuarioDao;
import com.br.loja.entity.Perfil;
import com.br.loja.entity.Produto;
import com.br.loja.entity.Tipostatus;
import com.br.loja.entity.Usuario;
import com.br.loja.service.UsuarioService;
import com.br.loja.util.BasicBBean;
import com.br.loja.util.Constantes;
import com.br.loja.util.StringUtil;

@Service
public class UsuarioServiceImpl extends BasicBBean implements UsuarioService {

	private static final long serialVersionUID = 1L;
	private static final String AVIS0_LOGIN_SENHA_NAO_PREENCHIDO = "Usuário / Senha inválida";
	private static final String AVIS0_LOGIN_NAO_ENCONTRADO = "Usuário não encontrado";
	private static final String AVIS0_USUARIO_INATIVO = "Usuário esta inativo";

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public Usuario autenticaService(Usuario usuario) throws LoginException {

		String senhaDigitada = usuario.getSenha();

		if (!this.validaUsuarioESenha(usuario)) {

			throw new LoginException(AVIS0_LOGIN_SENHA_NAO_PREENCHIDO);
		}

		try {

			usuario = this.buscarPorLoginService(usuario.getEmail());

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

		// usuario = service.inicializarPerfisDoUsuario(usuario);

		criaColocaUsuarioSessao(usuario);

		return usuario;
	}

	private void criaColocaUsuarioSessao(Usuario usuario) {

		/**
		 * coloca usuario na sessão
		 */

		getHttpSession(true).setAttribute(Constantes.USUARIO_DA_SESSAO, usuario);

	}

	@Override
	public Usuario inicializarPerfisDoUsuarioService(Usuario usuario) {
		return usuario = usuarioDao.buscaUsuarioId(usuario.getIdUsuario());
		// return usuarioDao.inicializarPerfisDoUsuario(usuario);
	}

	private boolean validaUsuarioESenha(Usuario usuario) {
		return !StringUtil.isBlankOrNull(usuario.getEmail()) && !StringUtil.isBlankOrNull(usuario.getEmail());
	}

	@Override
	public Usuario buscarPorLoginESenhaService(String login, String senha) throws Exception {
		return usuarioDao.buscarPorLoginESenha(login, senha);
	}

	@Override
	public Usuario buscarPorLoginService(String login) throws Exception {
		return usuarioDao.buscarPorLogin(login);
	}

	@Override
	public Usuario emailExisteService(String email) throws Exception {

		return usuarioDao.buscarPorLogin(email);
	}

	@Override
	public Usuario cadastroService(Usuario usuario){
		
		Perfil perfil = new Perfil();
		Tipostatus tipostatus = new Tipostatus();
		
		
		perfil.setIdperfil(1);
		
		tipostatus.setIdstatus(1);
		
		Produto produto = new Produto();
		
		usuario.setPerfil(perfil);
		
		usuario.setTipostatus(tipostatus);
		
		return usuarioDao.cadastro(usuario);
	}
}
