package com.br.loja.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.br.loja.dao.UsuarioDao;
import com.br.loja.entity.Usuario;
import com.br.loja.repository.UsuarioRepository;

@Component
public class UsuarioDaoImpl implements UsuarioDao{

	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	@Transactional
	public Usuario logar(Usuario usuario) {	
				
		return usuarioRepository.loginUsuario(usuario.getEmail());
	}

	@Override
	@Transactional
	public Usuario buscarPorLogin(String email) throws Exception {
		
		return usuarioRepository.loginUsuario(email);

	}

	@Override
	@Transactional
	public Usuario buscarPorLoginESenha(String login, String senha) {
		// TODO Auto-generated method stub
		return null;
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
		
		return usuarioRepository.loginUsuario(email);
	}

	@Override
	public Usuario cadastro(Usuario usuario) {
		
		return usuarioRepository.saveAndFlush(usuario);
	}
}
