package main.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="facultades")
public class Facultad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column
	private String nombre;
	
	@OneToMany(mappedBy = "facultad", cascade = CascadeType.ALL)
	private List<Equipo> equipos;
	
	@OneToMany( mappedBy = "facultad", cascade = CascadeType.ALL)
	private List<Investigador> investigadores;
	
	public Facultad() {
		// TODO Auto-generated constructor stub
	}

	public Facultad(Long codigo, String nombre, List<Equipo> equipos, List<Investigador> investigadores) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.equipos = equipos;
		this.investigadores = investigadores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	public List<Investigador> getInvestigadores() {
		return investigadores;
	}

	public void setInvestigadores(List<Investigador> investigadores) {
		this.investigadores = investigadores;
	}

	public Long getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Facultad [codigo=" + codigo + ", nombre=" + nombre + ", equipos=" + equipos + ", investigadores="
				+ investigadores + "]";
	}
	
	
}
