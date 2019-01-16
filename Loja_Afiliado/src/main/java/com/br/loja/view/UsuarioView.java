package com.br.loja.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.br.loja.entity.Usuario;
import com.br.loja.service.UsuarioService;
import com.br.loja.util.BasicBBean;
import com.br.loja.util.Constantes;
import com.br.loja.util.UsuarioLogado;

@Controller
@ManagedBean
@SessionScoped
public class UsuarioView  extends BasicBBean implements Serializable {


	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioService usuarioService;

	public Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String login() {

		Usuario usuarioAutentica = null;

		try {

			usuarioAutentica = usuarioService.autenticaService(usuario);

			if (!validaAdicionaUsuarioControleLogin(usuarioAutentica)) {

				RequestContext.getCurrentInstance().execute("PF('dlgUsuarioJaLogado').show();");

				return "";
			}

			usuario = usuarioService.inicializarPerfisDoUsuarioService(usuarioAutentica);

			//criaUsuarioUtilitario();

			usuario = new Usuario();

			return Constantes.PAGINA_SUCESSO_CONFIG;

		} catch (LoginException e) {

			e.printStackTrace();
		}

		return Constantes.PAGINA_ERRO_LOGIN;
	}

	private void criaUsuarioUtilitario() {

		//UsuarioLogado usuarioLogado = new UsuarioLogado();

		//usuarioLogado.setAutenticado(true);

		//usuarioLogado.setUsuario(usuario);

		// usuarioLogado.obtemPermissoesDoUsuario();

		//getHttpSession(true).setAttribute(Constantes.USUARIO_DA_SESSAO, usuarioLogado);

	}

	private static final String[] HEADERS_TO_TRY = { "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP",
			"HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED", "HTTP_X_CLUSTER_CLIENT_IP", "HTTP_CLIENT_IP",
			"HTTP_FORWARDED_FOR", "HTTP_FORWARDED", "HTTP_VIA", "REMOTE_ADDR" };

	private void obtemIpDoUsuario(UsuarioLogado usuarioLogado) {
		try {

			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

			String ipAddress = getClientIpAddress(request);

			usuarioLogado.setEnderecoIpDoUsuario(ipAddress);

		} catch (Exception e) {

			logger.error("Não foi possivel obter o ip do usuario " + e.getMessage());
		}
	}

	public static String getClientIpAddress(HttpServletRequest request) {
		for (String header : HEADERS_TO_TRY) {
			String ip = request.getHeader(header);
			if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
				return ip;
			}
		}
		return request.getRemoteAddr();
	}

	public boolean validaEmailExiste(String email) {

		try {

			if (usuarioService.emailExisteService(email) != null) {

				return true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}


	public String cadastroUsuario(){

		FacesContext context = FacesContext.getCurrentInstance();

		if(usuario.getNome() == null || usuario.getNome().trim() == ""){

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso",  "O campo nome não pode esta vazio."));

			return null;
		}

		if(usuario.getUltimoNome() == null || usuario.getUltimoNome().trim() == ""){

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso",  "O campo Sobrenome nome não pode esta vazio."));

			return null;
		}

		if(usuario.getEmail() == null || usuario.getEmail().trim() == ""){

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso",  "O campo E-mail não pode esta vazio."));

			return null;
		}

		if(usuario.getSenha() == null || usuario.getSenha().trim() == ""){

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso",  "Informe uma senha."));

			return null;
		}

		if(usuario.getConfirmaSenha().trim() == null || usuario.getConfirmaSenha().trim() == ""){

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso",  "Confirma senha não pode esta vazio."));

			return null;
		}

		if(usuario.getFoto() != null){

			return null;
		}


		if(!usuario.getSenha().equals(usuario.getConfirmaSenha())){

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso",  "As senhas  não conferem."));

			return null;
		}

		Usuario usuarioRetorno = usuarioService.cadastroService(usuario);

		if(usuarioRetorno.getIdUsuario() != 0) {

			usuario = new Usuario();

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso",  "Usuario cadastrado com sucesso.") );


		}else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro",  "Erro ao tentar cadastrar usuario.") );
		}
		return null;
	}

	public Usuario buscaEmail(){

		if(usuario.getEmail() == null || usuario.getEmail().trim() == ""){

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso",  "O campo E-mail não pode esta vazio."));

			return usuario = new Usuario();

		}else{

			Usuario usuarioRetorno = usuarioService.emailExisteService(usuario.getEmail());

			usuario = usuarioRetorno;

			 return usuarioRetorno;

		}
	}
}