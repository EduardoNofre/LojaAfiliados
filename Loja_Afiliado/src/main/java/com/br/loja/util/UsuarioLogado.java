package com.br.loja.util;

import java.io.Serializable;

import com.br.loja.entity.Usuario;


/**
 * @author alex.braz
 */
public class UsuarioLogado implements Serializable {
	private static final long serialVersionUID = 2468717141649393264L;
	private String id_session;
	private Usuario usuario;
	private boolean autenticado;
	private String nome;
	private int idUsuario;
	private String enderecoIpDoUsuario;

	public UsuarioLogado() {		
	}

	public String getId_session() {
		return id_session;
	}

	public void setId_session(String id_session) {
		this.id_session = id_session;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario ausuario) {
		this.usuario = ausuario;
		this.setIdUsuario(usuario.getIdUsuario());
		this.setNome(usuario.getEmail());
	}


	
	public boolean isAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

//	public void obtemPermissoesDoUsuario() {
//		funcionalidadesDoUsuario                 = new HashMap<Integer, Funcionalidade>();
//		Set<PerfilAcessoUsuario> perfisDoUsuario = usuario.getPerfisDoUsuario();
//		/**
//		 * 
//		 */
//		if(perfisDoUsuario!=null&&!perfisDoUsuario.isEmpty()){
//			Iterator<PerfilAcessoUsuario> perfUsuario = perfisDoUsuario.iterator();
//			while(perfUsuario.hasNext()){
//				PerfilAcessoUsuario peracuss = perfUsuario.next();
//				PerfilAcesso pa              = peracuss.getPerfilAcesso();
//				
//				if(pa!=null){
//					for(Funcionalidade funcionalidade : pa.getFuncionalidades()){
//						funcionalidadesDoUsuario.put(funcionalidade.getIdFuncionalidade(), funcionalidade);
//					}
//				}
//			}
//		}
//		
//	}

	
	/**
	 * M�todo que valida se o usuario tem permiss�o de acessar a funcionalidade
	 * @param NOME_DA_PERMISSAO
	 * @return
	 */
//	public boolean tenhoPermissao(String NOME_DA_PERMISSAO){
//		
//		if(StringUtil.isBlankOrNull(NOME_DA_PERMISSAO)){
//			return false;
//		}
//		
//		boolean retorno                  = false;
//		Collection<Funcionalidade> lista = funcionalidadesDoUsuario.values();
//		
//		for(Funcionalidade funcionalidade : lista){
//			if(funcionalidade.getNome().equals(NOME_DA_PERMISSAO)){
//				return true;
//			}
//		}
//		
//		return retorno;
//	}
	
	/**
	 * 
	 * @param idFuncionalidade
	 * @return
	 */
//	public boolean temPermissao(Integer ID_DA_FUNCIONALIDADE) {
//		if(StringUtil.isBlankOrNull(ID_DA_FUNCIONALIDADE)){
//			return false;
//		}
//		
//		boolean retorno                  = false;
//		Collection<Funcionalidade> lista = funcionalidadesDoUsuario.values();
//		
//		for(Funcionalidade funcionalidade : lista){
//			if(funcionalidade.getIdFuncionalidade().intValue() == ID_DA_FUNCIONALIDADE.intValue()){
//				return true;
//			}
//		}
//		
//		return retorno;
//	}

	public String getEnderecoIpDoUsuario() {
		return enderecoIpDoUsuario;
	}

	public void setEnderecoIpDoUsuario(String enderecoIpDoUsuario) {
		this.enderecoIpDoUsuario = enderecoIpDoUsuario;
	}
	
	
			
}