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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduto;

	private String commentProd;

	private String comprarLink;

	private String descriptionProd;

	private String email;

	private String imageProd;

	private String linkVideo;

	private String nameProd;

	private String whatsApp;

	//bi-directional many-to-one association to Tipostatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idstatus")
	private Tipostatus tipostatus;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public Produto() {
	}

	public int getIdProduto() {
		return this.idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getCommentProd() {
		return this.commentProd;
	}

	public void setCommentProd(String commentProd) {
		this.commentProd = commentProd;
	}

	public String getComprarLink() {
		return this.comprarLink;
	}

	public void setComprarLink(String comprarLink) {
		this.comprarLink = comprarLink;
	}

	public String getDescriptionProd() {
		return this.descriptionProd;
	}

	public void setDescriptionProd(String descriptionProd) {
		this.descriptionProd = descriptionProd;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageProd() {
		return this.imageProd;
	}

	public void setImageProd(String imageProd) {
		this.imageProd = imageProd;
	}

	public String getLinkVideo() {
		return this.linkVideo;
	}

	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}

	public String getNameProd() {
		return this.nameProd;
	}

	public void setNameProd(String nameProd) {
		this.nameProd = nameProd;
	}

	public String getWhatsApp() {
		return this.whatsApp;
	}

	public void setWhatsApp(String whatsApp) {
		this.whatsApp = whatsApp;
	}

	public Tipostatus getTipostatus() {
		return this.tipostatus;
	}

	public void setTipostatus(Tipostatus tipostatus) {
		this.tipostatus = tipostatus;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}