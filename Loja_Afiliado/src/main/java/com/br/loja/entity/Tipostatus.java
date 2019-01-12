package com.br.loja.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipostatus database table.
 * 
 */
@Entity
@NamedQuery(name="Tipostatus.findAll", query="SELECT t FROM Tipostatus t")
public class Tipostatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idstatus;

	private String dscStatus;

	private String name;

	//bi-directional many-to-one association to Configview
	@OneToMany(mappedBy="tipostatus")
	private List<Configview> configviews;

	//bi-directional many-to-one association to Produto
	@OneToMany(mappedBy="tipostatus")
	private List<Produto> produtos;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tipostatus")
	private List<Usuario> usuarios;

	public Tipostatus() {
	}

	public Integer getIdstatus() {
		return this.idstatus;
	}

	public void setIdstatus(Integer idstatus) {
		this.idstatus = idstatus;
	}

	public String getDscStatus() {
		return this.dscStatus;
	}

	public void setDscStatus(String dscStatus) {
		this.dscStatus = dscStatus;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Configview> getConfigviews() {
		return this.configviews;
	}

	public void setConfigviews(List<Configview> configviews) {
		this.configviews = configviews;
	}

	public Configview addConfigview(Configview configview) {
		getConfigviews().add(configview);
		configview.setTipostatus(this);

		return configview;
	}

	public Configview removeConfigview(Configview configview) {
		getConfigviews().remove(configview);
		configview.setTipostatus(null);

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
		produto.setTipostatus(this);

		return produto;
	}

	public Produto removeProduto(Produto produto) {
		getProdutos().remove(produto);
		produto.setTipostatus(null);

		return produto;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setTipostatus(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setTipostatus(null);

		return usuario;
	}

}