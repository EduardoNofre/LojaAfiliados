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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idstatus;

	private String dscStatus;

	private String name;

	//bi-directional many-to-one association to Produto
	@OneToMany(mappedBy="tipostatus")
	private List<Produto> produtos;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tipostatus")
	private List<Usuario> usuarios;

	public Tipostatus() {
	}

	public int getIdstatus() {
		return this.idstatus;
	}

	public void setIdstatus(int idstatus) {
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