package main.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="reservas")
public class Reserva {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="investigador")
	private Investigador investigador;
	
	@ManyToOne
	@JoinColumn(name="num_serie")
	private Equipo equipo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date comienzo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fin;
	
	public Reserva() {
		// TODO Auto-generated constructor stub
	}

	public Reserva(Long id, Investigador investigador, Equipo equipo, Date comienzo, Date fin) {
		this.id = id;
		this.investigador = investigador;
		this.equipo = equipo;
		this.comienzo = comienzo;
		this.fin = fin;
	}

	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Date getComienzo() {
		return comienzo;
	}

	public void setComienzo(Date comienzo) {
		this.comienzo = comienzo;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", investigador=" + investigador + ", equipo=" + equipo + ", comienzo=" + comienzo
				+ ", fin=" + fin + "]";
	}
}
