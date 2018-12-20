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
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;

	private String email;

	private Timestamp lastacess;

	private String lastName;

	private String name;

	private String password;

	private Timestamp regdate;

	//bi-directional many-to-one association to Produto
	@OneToMany(mappedBy="usuario")
	private List<Produto> produtos;

	//bi-directional many-to-one association to Perfil
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idperfil")
	private Perfil perfil;

	//bi-directional many-to-one association to Tipostatus
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idstatus")
	private Tipostatus tipostatus;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getLastacess() {
		return this.lastacess;
	}

	public void setLastacess(Timestamp lastacess) {
		this.lastacess = lastacess;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegdate() {
		return this.regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
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

}