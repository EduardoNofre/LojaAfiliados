package com.br.loja.util;

/**
 * 
 * @author alex.braz
 * 
 * Representa��o da tabela ACAO, onde no enum:
 * 
 * idAcao = id_acao
 * nome   = descricao
 *
 */
public enum AcaoEnum {
	INSERIR(1, "INSERIR"), 
	ALTERAR(2, "ALTERAR"),
	REMOVER(3, "REMOVER"),
	CONSULTAR(4, "CONSULTAR"),
	LOGIN(6, "LOGIN"),
	LOGOUT(7, "LOGOUT"),
	VISUALIZAR(9, "VISUALIZAR"),
	ABRIR(16, "ABRIR"),
	SUSPENDER(17, "SUSPENDER"),
	ASSINAR(20,"ASSINAR"),
	ANEXAR(21,"ANEXAR"),
	DOWNLOAD(22,"DOWNLOAD"),
	SOLICITAR(23, "SOLICITAR");
	
	private final Integer idAcao;
	private final String nome;
	
	AcaoEnum(Integer id, String anome){
		idAcao = id;
		nome = anome;
	}
	
	public Integer getIdAcao(){
		return idAcao;
	}
	
	
	public String getNome(){
		return nome;
	}

}
