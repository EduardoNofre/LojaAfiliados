package com.br.loja.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUsuario;

	private Timestamp dtregistro;

	private String email;

	private String foto;

	private String nome;

	private String senha;

	private Timestamp ultimoAcesso;

	private String ultimoNome;

	@Transient
	private String confirmaSenha;

	@Transient
	private String message;

	@Transient
	private boolean existeEmail = true;

	// bi-directional many-to-one association to Configservidor
	@OneToMany(mappedBy = "usuario")
	private List<Configservidor> configservidors;

	// bi-directional many-to-one association to Configview
	@OneToMany(mappedBy = "usuario")
	private List<Configview> configviews;

	// bi-directional many-to-one association to Produto
	@OneToMany(mappedBy = "usuario")
	private List<Produto> produtos;

	// bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name = "idperfil")
	private Perfil perfil;

	// bi-directional many-to-one association to Tipostatus
	@ManyToOne
	@JoinColumn(name = "idstatus")
	private Tipostatus tipostatus;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Timestamp getDtregistro() {
		return this.dtregistro;
	}

	public void setDtregistro(Timestamp dtregistro) {
		this.dtregistro = dtregistro;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Timestamp getUltimoAcesso() {
		return this.ultimoAcesso;
	}

	public void setUltimoAcesso(Timestamp ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public String getUltimoNome() {
		return this.ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public List<Configservidor> getConfigservidors() {
		return this.configservidors;
	}

	public void setConfigservidors(List<Configservidor> configservidors) {
		this.configservidors = configservidors;
	}

	public Configservidor addConfigservidor(Configservidor configservidor) {
		getConfigservidors().add(configservidor);
		configservidor.setUsuario(this);

		return configservidor;
	}

	public Configservidor removeConfigservidor(Configservidor configservidor) {
		getConfigservidors().remove(configservidor);
		configservidor.setUsuario(null);

		return configservidor;
	}

	public List<Configview> getConfigviews() {
		return this.configviews;
	}

	public void setConfigviews(List<Configview> configviews) {
		this.configviews = configviews;
	}

	public Configview addConfigview(Configview configview) {
		getConfigviews().add(configview);
		configview.setUsuario(this);

		return configview;
	}

	public Configview removeConfigview(Configview configview) {
		getConfigviews().remove(configview);
		configview.setUsuario(null);

		return configview;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto addProduto(Produto produto) {
		getProdutos().add(produto);
		produto.setUsuario(this);

		return produto;
	}

	public Produto removeProduto(Produto produto) {
		getProdutos().remove(produto);
		produto.setUsuario(null);

		return produto;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Tipostatus getTipostatus() {
		return this.tipostatus;
	}

	public void setTipostatus(Tipostatus tipostatus) {
		this.tipostatus = tipostatus;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isExisteEmail() {
		return existeEmail;
	}

	public void setExisteEmail(boolean existeEmail) {
		this.existeEmail = existeEmail;
	}

}