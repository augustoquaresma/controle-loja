package br.com.augustoquaresma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.augustoquaresma.dto.PostUsuario;
import br.com.augustoquaresma.model.Usuario;
import br.com.augustoquaresma.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarios;
	
	
	public Usuario save(PostUsuario post) {
		Usuario user = new Usuario();
		user.setName(post.getName());
		return usuarios.save(user);
	}
	
	public List<Usuario> retornaUsuarios(){
		return usuarios.findAll();
	}
	
	public Optional<Usuario> findById(Long id) {
		return usuarios.findById(id);
	}

}
