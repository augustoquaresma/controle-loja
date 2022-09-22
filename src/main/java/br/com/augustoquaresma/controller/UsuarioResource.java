package br.com.augustoquaresma.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.augustoquaresma.dto.PostUsuario;
import br.com.augustoquaresma.model.Usuario;
import br.com.augustoquaresma.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarios;
	
	@PostMapping
	public ResponseEntity<Usuario> salvaUsuario(@RequestBody PostUsuario user){
		return new ResponseEntity<>(usuarios.save(user) ,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> retornarLista(){
		return new ResponseEntity<>(usuarios.retornaUsuarios() ,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> retornaUsuarioPorID(@PathVariable Long id){
		Optional<Usuario> user = usuarios.findById(id);
		if (user.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		}
	}

}
