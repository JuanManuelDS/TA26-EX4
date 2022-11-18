package main.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	private String rol;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(Long id, String username, String password, String rol) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.rol = rol;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return rol;
	}

	public void setRole(String rol) {
		this.rol = rol;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + ", rol=" + rol + "]";
	}
	
}
