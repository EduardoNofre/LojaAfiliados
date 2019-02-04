package com.br.loja.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the configservidor database table.
 * 
 */
@Entity
@NamedQuery(name="Configservidor.findAll", query="SELECT c FROM Configservidor c")
public class Configservidor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idconfigServidor;

	private String caminhorepositorio;

	private String nomeServidor;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public Configservidor() {
	}

	public int getIdconfigServidor() {
		return this.idconfigServidor;
	}

	public void setIdconfigServidor(int idconfigServidor) {
		this.idconfigServidor = idconfigServidor;
	}

	public String getCaminhorepositorio() {
		return this.caminhorepositorio;
	}

	public void setCaminhorepositorio(String caminhorepositorio) {
		this.caminhorepositorio = caminhorepositorio;
	}

	public String getNomeServidor() {
		return this.nomeServidor;
	}

	public void setNomeServidor(String nomeServidor) {
		this.nomeServidor = nomeServidor;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}