package main.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="investigadores")
public class Investigador {
	
	@Id
	private String dni;
	
	@Column
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="facultad")
	private Facultad facultad;
	
	@OneToMany( mappedBy = "investigador", cascade = CascadeType.ALL)
	private List<Reserva> reservas;
	
	public Investigador() {
		// TODO Auto-generated constructor stub
	}

	public Investigador(String dni, String nombre, Facultad facultad, List<Reserva> reservas) {
		this.dni = dni;
		this.nombre = nombre;
		this.facultad = facultad;
		this.reservas = reservas;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Investigador [dni=" + dni + ", nombre=" + nombre + ", facultad=" + facultad + ", reservas=" + reservas
				+ "]";
	}
	
}
