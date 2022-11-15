package main.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="equipos")
public class Equipo {

	@Id
	private String numSerie;
	
	@Column
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="facultad")
	private Facultad facultad;
	
	@OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL )
	private List<Reserva> reservas;
	
	public Equipo() {
		// TODO Auto-generated constructor stub
	}

	public Equipo(String numSerie, String nombre, Facultad facultad, List<Reserva> reservas) {
		this.numSerie = numSerie;
		this.nombre = nombre;
		this.facultad = facultad;
		this.reservas = reservas;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
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

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Equipo [numSerie=" + numSerie + ", nombre=" + nombre + ", facultad=" + facultad + ", reservas="
				+ reservas + "]";
	}
	
}
