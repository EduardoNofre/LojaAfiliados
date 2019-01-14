package com.br.loja.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the perfil database table.
 * 
 */
@Entity
@NamedQuery(name="Perfil.findAll", query="SELECT p FROM Perfil p")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idperfil;

	private String dscPerfil;

	private String perfil;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="perfil")
	private List<Usuario> usuarios;

	public Perfil() {
	}

	public int getIdperfil() {
		return this.idperfil;
	}

	public void setIdperfil(int idperfil) {
		this.idperfil = idperfil;
	}

	public String getDscPerfil() {
		return this.dscPerfil;
	}

	public void setDscPerfil(String dscPerfil) {
		this.dscPerfil = dscPerfil;
	}

	public String getPerfil() {
		return this.perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPerfil(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPerfil(null);

		return usuario;
	}

}