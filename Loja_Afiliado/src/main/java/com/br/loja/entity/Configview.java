package com.br.loja.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the configview database table.
 * 
 */
@Entity
@NamedQuery(name="Configview.findAll", query="SELECT c FROM Configview c")
public class Configview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idconfigView;

	private String footerColor;

	private String footerFont;

	private String footerFontSize;

	private String footerText;

	private Integer gridColum;

	private Integer gridLinha;

	private String headColor;

	private String headFont;

	private String headFontSize;

	private String headText;

	private String imgLogo;

	private String registroAutoralText;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Tipostatus
	@ManyToOne
	@JoinColumn(name="idstatus")
	private Tipostatus tipostatus;

	public Configview() {
	}

	public Integer getIdconfigView() {
		return this.idconfigView;
	}

	public void setIdconfigView(Integer idconfigView) {
		this.idconfigView = idconfigView;
	}

	public String getFooterColor() {
		return this.footerColor;
	}

	public void setFooterColor(String footerColor) {
		this.footerColor = footerColor;
	}

	public String getFooterFont() {
		return this.footerFont;
	}

	public void setFooterFont(String footerFont) {
		this.footerFont = footerFont;
	}

	public String getFooterFontSize() {
		return this.footerFontSize;
	}

	public void setFooterFontSize(String footerFontSize) {
		this.footerFontSize = footerFontSize;
	}

	public String getFooterText() {
		return this.footerText;
	}

	public void setFooterText(String footerText) {
		this.footerText = footerText;
	}

	public Integer getGridColum() {
		return this.gridColum;
	}

	public void setGridColum(Integer gridColum) {
		this.gridColum = gridColum;
	}

	public Integer getGridLinha() {
		return this.gridLinha;
	}

	public void setGridLinha(Integer gridLinha) {
		this.gridLinha = gridLinha;
	}

	public String getHeadColor() {
		return this.headColor;
	}

	public void setHeadColor(String headColor) {
		this.headColor = headColor;
	}

	public String getHeadFont() {
		return this.headFont;
	}

	public void setHeadFont(String headFont) {
		this.headFont = headFont;
	}

	public String getHeadFontSize() {
		return this.headFontSize;
	}

	public void setHeadFontSize(String headFontSize) {
		this.headFontSize = headFontSize;
	}

	public String getHeadText() {
		return this.headText;
	}

	public void setHeadText(String headText) {
		this.headText = headText;
	}

	public String getImgLogo() {
		return this.imgLogo;
	}

	public void setImgLogo(String imgLogo) {
		this.imgLogo = imgLogo;
	}

	public String getRegistroAutoralText() {
		return this.registroAutoralText;
	}

	public void setRegistroAutoralText(String registroAutoralText) {
		this.registroAutoralText = registroAutoralText;
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