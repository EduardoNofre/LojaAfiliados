package com.br.loja.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.br.loja.entity.Usuario;
import com.br.loja.service.UsuarioService;
import com.br.loja.util.BasicBBean;
import com.br.loja.util.UsuarioLogado;

@Controller
@ManagedBean
@ViewScoped
public class UsuarioView extends BasicBBean implements Serializable {

	private static String PAGINA_SUCESSO_LOGIN = "branca";
	private static final String PAGINA_ERRO_LOGIN = "login";

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

			usuarioAutentica = usuarioService.autentica(usuario);

			if (!validaAdicionaUsuarioControleLogin(usuarioAutentica)) {

				RequestContext.getCurrentInstance().execute("PF('dlgUsuarioJaLogado').show();");

				return "";
			}

			usuario = usuarioService.inicializarPerfisDoUsuario(usuarioAutentica);

			//criaUsuarioUtilitario();

			return PAGINA_SUCESSO_LOGIN;

		} catch (LoginException e) {

			e.printStackTrace();
		}

		return PAGINA_ERRO_LOGIN;
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

			if (usuarioService.emailExiste(email) != null) {

				return true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}
}