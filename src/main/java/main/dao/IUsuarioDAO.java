package main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {
	
	public Usuario findByUsername(String username);
	
}
