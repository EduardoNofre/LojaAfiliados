package com.br.loja.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produtos database table.
 * 
 */
@Entity
@Table(name="produtos")
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProduto;

	private String comentarioPord;

	private String comprarLink;

	private String descProduto;

	private String email;

	private String imagemProd;

	private String linkVideo;

	private String nomeProd;

	private String whatsApp;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Tipostatus
	@ManyToOne
	@JoinColumn(name="idstatus")
	private Tipostatus tipostatus;

	public Produto() {
	}

	public int getIdProduto() {
		return this.idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getComentarioPord() {
		return this.comentarioPord;
	}

	public void setComentarioPord(String comentarioPord) {
		this.comentarioPord = comentarioPord;
	}

	public String getComprarLink() {
		return this.comprarLink;
	}

	public void setComprarLink(String comprarLink) {
		this.comprarLink = comprarLink;
	}

	public String getDescProduto() {
		return this.descProduto;
	}

	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImagemProd() {
		return this.imagemProd;
	}

	public void setImagemProd(String imagemProd) {
		this.imagemProd = imagemProd;
	}

	public String getLinkVideo() {
		return this.linkVideo;
	}

	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}

	public String getNomeProd() {
		return this.nomeProd;
	}

	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}

	public String getWhatsApp() {
		return this.whatsApp;
	}

	public void setWhatsApp(String whatsApp) {
		this.whatsApp = whatsApp;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tipostatus getTipostatus() {
		return this.tipostatus;
	}

	public void setTipostatus(Tipostatus tipostatus) {
		this.tipostatus = tipostatus;
	}

}