package main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.dto.Usuario;
import main.services.UsuarioService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public UsuarioController(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@GetMapping("/response-entity-builder-with-http-headers")
	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Baeldung-Example-Header", 
	      "Value-ResponseEntityBuilderWithHttpHeaders");

	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body("Response with header using ResponseEntity");
	}
	
	@GetMapping("/usuarios")
	public List<Usuario> listasrUsuarios(){
		return usuarioService.listarUsuarios();
	}
	
	@GetMapping("/usuarios/buscar/{username}")
	public Usuario buscarUsuario(@PathVariable(name="username")String username) {
		return usuarioService.buscarUsuario(username);
	}
	
	@PostMapping("/usuarios")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		return usuarioService.guardarUsuario(usuario);
	}
	
}
