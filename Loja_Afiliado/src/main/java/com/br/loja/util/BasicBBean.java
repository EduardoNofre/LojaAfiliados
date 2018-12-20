package com.br.loja.util;

import static com.br.loja.util.Constantes.CADASTROS;
import static com.br.loja.util.Constantes.MONITOR_DE_PROCESSO;
import static com.br.loja.util.Constantes.RELATORIOS;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.br.loja.entity.Usuario;

public abstract class BasicBBean implements BeanNameAware, Serializable {

	private static final long serialVersionUID = -7451189428350976222L;
	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected static final String SUCCESS = "Success";
	protected static final String ERROR = "Error";
	public transient boolean fromSerialization;
	private String beanName;
	private UsuarioLogado usuarioLogado;
	private Properties properties = new Properties();
	private boolean loaded = false;
	private static final String STANDARD_LOCATION_PREFIX = "classpath:META-INF/config/application.properties";
	private static final String STANDARD_LOCATION_PREFIX_PACK = "META-INF/config/application.properties";




	/**
	 * 
	 * @param acaoEnum
	 * @param TEXTO
	 * @param funcionalidadeEnum
	 */
//	public void addLog(AcaoEnum acaoEnum, String TEXTO, FuncionalidadeEnum funcionalidadeEnum) {
//		Log log = new Log();
//		log.setAcao(new Acao(acaoEnum.getIdAcao()));
//		log.setDataHora(StringUtil.hojeDataHoraTimestamp());
//		log.setDescricao(TEXTO);
//		log.setUsuario(getUsuarioLogado().getUsuario());
//		log.setIp(getUsuarioLogado().getEnderecoIpDoUsuario());
//		log.setFuncionalidade(funcionalidadeService.listarPorNome(funcionalidadeEnum.getNome()));
//		logService.inserirLog(log);
//	}

	/**
	 * Este metodo cria um novo value bind para o backing bean.
	 * 
	 * @param <T>
	 *            Tipo do Backing Bean.
	 * @param managedBeanName
	 *            nome do Backing Bean.
	 * @return Retorna a instancia do Backing Bean.
	 */
	@SuppressWarnings("unchecked")
	protected <T> T getBind(String managedBeanName) {
		return (T) getFacesContext().getApplication().createValueBinding(managedBeanName).getValue(getFacesContext());
	}

	/**
	 * Adiciona uma mensagem global ao FacesContext.
	 * 
	 * @param severity
	 *            Severidade da mensagem.
	 * @param summary
	 *            Sumario da mensagem.
	 * @param details
	 *            Detalhes da mensagem.
	 */
	protected void addMessage(FacesMessage.Severity severity, String summary, String details) {
		getFacesContext().addMessage(summary, new FacesMessage(severity, summary, details));
	}

	/**
	 * Retorna uma instancia do <code>FacesContext</code>.
	 * 
	 * @return Instancia do <code>FacesContext</code>.
	 */
	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	/**
	 * Retorna o <code>HttpServletRequest</code> corrente.
	 * 
	 * @return Instancia do <code>HttpServletRequest</code>.
	 */
	protected HttpServletRequest getHttpRequest() {
		return (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
	}

	/**
	 * Retorna o <code>HttpServletResponse</code> corrente.
	 * 
	 * @return Instancia do <code>HttpServletResponse</code>.
	 */
	protected HttpServletResponse getHttpResponse() {
		return (HttpServletResponse) getFacesContext().getExternalContext().getResponse();
	}

	/**
	 * Retorna uma instancia <code>HttpSession</code>.
	 * 
	 * @param create
	 *            Caso seja true cria uma nova caso nao exista uma, caso seja
	 *            false nao cria uma nova caso nao exista.
	 * @return Uma instancia <code>HttoSession</code> ou <code>null</code>.
	 */
	protected HttpSession getHttpSession(boolean create) {
		return (HttpSession) getFacesContext().getExternalContext().getSession(create);
	}

	/**
	 * Retorna uma instancia de Application Todos os objetos armazenados aqui,
	 * estar�o disponiveis para todos os usuarios da aplica��o<br/>
	 * 
	 * @return
	 */
	protected ServletContext getApplication() {
		return getHttpSession(false).getServletContext();
	}

	/**
	 * Retorna um atributo do scopo Request.
	 * 
	 * @param <T>
	 *            Tipo do Atributo.
	 * @param attributeName
	 *            Nome do Atributo.
	 * @return A instancia do atributo ou <code>null</code>.
	 */
	@SuppressWarnings("unchecked")
	protected <T> T getRequestAttribute(String attributeName) {
		return (T) getHttpRequest().getAttribute(attributeName);
	}

	/**
	 * Retorna um parametro do escopo Request.
	 * 
	 * @param paramName
	 *            Nome do parametro.
	 * @return Valor do parametro.
	 */
	protected String getRequestParameter(String paramName) {
		return getHttpRequest().getParameter(paramName);
	}

	/**
	 * Retorna um atributo do scopo Session.
	 * 
	 * @param <T>
	 *            Tipo do Atributo.
	 * @param attributeName
	 *            Nome do Atributo.
	 * @return A instancia do atributo ou <code>null</code>.
	 */
	@SuppressWarnings("unchecked")
	protected <T> T getSessionAttribute(String attributeName) {
		return (T) getHttpSession(true).getAttribute(attributeName);
	}

	/**
	 * Adiciona um atributo a Session.
	 * 
	 * @param attributeName
	 *            Nome do Atributo.
	 * @param attributeValue
	 *            Valor do Atributo.
	 */
	protected void setSessionAttribute(String attributeName, Object attributeValue) {
		getHttpSession(true).setAttribute(attributeName, attributeValue);
	}

	/**
	 * Retorna um atributo do scopo faces.
	 * 
	 * @param <T>
	 *            Tipo do Atributo.
	 * @param event
	 *            ActionEvent do componente.
	 * @param attName
	 *            Nome do Atributo.
	 * @return Valor do atributo.
	 */
	@SuppressWarnings("unchecked")
	protected <T> T getAttribute(ActionEvent event, String attName) {
		return (T) event.getComponent().getAttributes().get(attName);
	}

	public void setBeanName(String name) {
		beanName = name;
	}

	public String getBeanName() {
		return beanName;
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		fromSerialization = true;
		autowire();
	}

	/**
	 * 
	 */
	protected void autowire() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		ServletContext servletContext = (ServletContext) externalContext.getContext();
		WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).getAutowireCapableBeanFactory().autowireBean(this);
	}

	protected void load() {
		try {
			if (loaded) {
				return;
			}
			InputStream in = this.getClass().getClassLoader().getResourceAsStream(STANDARD_LOCATION_PREFIX_PACK);

			if (in != null) {
				properties.load(in);
				loaded = true;
			}
		} catch (Exception e) {
		}
	}

	public String getApplicationName() {

		if (!loaded) {
			load();
		}

		return properties.getProperty(Constantes.APLICATION_NAME);
	}

	public String getApplicationVersion() {

		if (!loaded) {
			load();
		}

		return properties.getProperty(Constantes.APLICATION_VERSION);
	}

	public String getApplicationTitle() {

		if (!loaded) {
			load();
		}

		return properties.getProperty(Constantes.APLICATION_TITLE);
	}

	public UsuarioLogado getUsuarioLogado() {

		if (usuarioLogado == null) {
			usuarioLogado = getSessionAttribute(Constantes.USUARIO_DA_SESSAO);
		}

		return usuarioLogado;
	}

	public void setUsuarioLogado(UsuarioLogado usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public String getTempoGastoEmSegundos(Long inicioConsulta) {
		/* calculo de quanto tempo demorou pra retornar a busca */
		BigDecimal tempoFinalEmSegundos = new BigDecimal(System.currentTimeMillis() - inicioConsulta);
		tempoFinalEmSegundos = tempoFinalEmSegundos.divide(new BigDecimal(1000), 3, RoundingMode.DOWN);
		return tempoFinalEmSegundos.toString();
	}


//	public boolean tenhoPermissao(String NOME_DA_PERMISSAO) {
//		if (getUsuarioLogado() == null) {
//			return false;
//		}
//		return getUsuarioLogado().tenhoPermissao(NOME_DA_PERMISSAO);
//	}


//	public boolean temPermissao(Integer ID_DA_FUNCIONALIDADE) {
//		if (getUsuarioLogado() == null) {
//			return false;
//		}
//		return getUsuarioLogado().temPermissao(ID_DA_FUNCIONALIDADE);
//	}

	/**
	 * 
	 * @param NOME_DA_PERMISSAO
	 * @return
	 * @author pedro.lucas
	 */
//	public boolean tenhoVariasPermissoes(String NOME_DA_PERMISSAO) {
//		try {
//			String permissoes[] = NOME_DA_PERMISSAO.split(",");
//
//			for (String permissao : permissoes) {
//				if (!tenhoPermissao(permissao)) {
//					return false;
//				}
//			}
//			return true;
//		} catch (Exception e) {
//		}
//
//		return false;
//	}
	
	/**
	 * 
	 * @param NOME_DA_PERMISSAO
	 * @return
	 * @author pedro.lucas
	 */
//	public boolean tenhoUmaOuMaisPermissoes(String NOME_DA_PERMISSAO) {
//		try {
//			String permissoes[] = NOME_DA_PERMISSAO.split(",");
//
//			for (String permissao : permissoes) {
//				if (tenhoPermissao(permissao)) {
//					return true;
//				}
//			}
//			return false;
//		} catch (Exception e) {
//		}
//		return false;
//	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public boolean temPermissoes(String s) {
		return s != null && (MONITOR_DE_PROCESSO.equals(s) || RELATORIOS.equals(s) || CADASTROS.equals(s));
	}

	@SuppressWarnings("unchecked")
	protected Map<String, HttpSession> getSessoesUsuariosLogados(){
		if (getApplication().getAttribute("LISTA_ACESSOS") == null) {
			getApplication().setAttribute("LISTA_ACESSOS", new HashMap<String, HttpSession>());
		} 
		return (Map<String, HttpSession>) getApplication().getAttribute("LISTA_ACESSOS");
	}
	
	
	
	/**
	 * <b>M�todos de valida��o:<b/> de usu�rios logados via Contexto da
	 * aplica��o<br/>
	 */
	protected boolean validaAdicionaUsuarioControleLogin(Usuario objUsuario) {
		if (this.getSessoesUsuariosLogados().containsKey(objUsuario.getEmail())) {
			HttpSession sessaoAtual = this.getSessoesUsuariosLogados().get(objUsuario.getEmail());
			if (sessaoAtual.getId() == getHttpSession(true).getId()) {
				return true;
			} else {
				return false;
			}
		} else {
			this.getSessoesUsuariosLogados().put(objUsuario.getEmail().toUpperCase(), getHttpSession(true));
			return true;
		}
	}

	protected void destroiLogDoUsuario(String nomeLogin) {
		if (nomeLogin == null || nomeLogin == "")
			return;
		
		try {
			if (nomeLogin != null) {
				HttpSession sessionAlvo = this.getSessoesUsuariosLogados().get(nomeLogin.toUpperCase());
				this.getSessoesUsuariosLogados().remove(nomeLogin.toUpperCase());
				sessionAlvo.invalidate();
			}
		} catch (IllegalStateException e) {
			return;
		} catch (Exception e) {
			logger.error("Erro liberando usuario logado " + e.getMessage());
		}
	}

}