package main.services;

import static java.util.Collections.emptyList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import main.dao.IUsuarioDAO;
import main.dto.Usuario;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {

	@Autowired
	IUsuarioDAO iUsuarioDAO;
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = iUsuarioDAO.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(usuario.getUsername(), usuario.getPassword(), emptyList());
	}
	
	@Override
	public List<Usuario> listarUsuarios() {
		
		return iUsuarioDAO.findAll();
	}

	@Override
	public Usuario buscarUsuario(String username) {
		
		return iUsuarioDAO.findByUsername(username);
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {

		return iUsuarioDAO.save(usuario);
	}

}
