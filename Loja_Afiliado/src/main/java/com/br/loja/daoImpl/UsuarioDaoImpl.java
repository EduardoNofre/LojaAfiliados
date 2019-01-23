package com.br.loja.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.br.loja.dao.UsuarioDao;
import com.br.loja.entity.Tipostatus;
import com.br.loja.entity.Usuario;
import com.br.loja.repository.UsuarioRepository;

@Component
public class UsuarioDaoImpl implements UsuarioDao{


	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	@Transactional
	public Usuario logar(Usuario usuario) {	

		return usuarioRepository.findByEmail(usuario.getEmail());
	}

	@Override
	@Transactional
	public Usuario buscarPorLogin(String email){

		return usuarioRepository.findByEmail(email);

	}

	@Override
	@Transactional
	public Usuario buscarPorLoginESenha(String email, String senha) {

		return usuarioRepository.loginUsuario(email,senha);
	}

	@Override
	@Transactional
	public Usuario inicializarPerfisDoUsuario(Usuario usuario) {

		//	usuarioRepository.initialize(usuario);

		return usuario;
	}

	@Override
	@Transactional
	public Usuario buscaUsuarioId(int idUsuario) {

		return usuarioRepository.findOne(idUsuario);
	}

	@Override
	@Transactional
	public Usuario emailExiste(String email) {

		return usuarioRepository.findByEmail(email);
	}

	@Override
	public Usuario cadastro(Usuario usuario) {

		return usuarioRepository.saveAndFlush(usuario);
	}

	@Override
	public Usuario alterarUsuario(Usuario usuario) {

		// passar o id para update
		return usuarioRepository.saveAndFlush(usuario);

	}

	@Override
	public Usuario exclusaoUsuario(Usuario usuario) {

		//Exclusão logica
		Tipostatus tp = new Tipostatus();
		
		tp.setIdstatus(2);
		
		usuario.setTipostatus(tp);
		
		return usuarioRepository.saveAndFlush(usuario);
	}
}
